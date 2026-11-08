package beatdz;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;

/** Animation rig and filtering for top-up costume images loaded by the web/cache queue. */
public final class TopupCostumes {
    private TopupCostumes() {}
    private static final int[] ICONS = {31000,31001,31002,31100,31101,31200,31201,31202,
            31300,31400,31401,31402,31403,31700,31701,31800,31801,31802,
            31900,31901,31902,32000,32001,32064,32100,32132,32164,32200,32232};

    // Cached catalogs may predate the installed costume pack. Populate only the
    // pack's reserved, missing metadata after parsing; never change packet offsets.
    public static ItemTemplate[] installItems(ItemTemplate[] source) {
        if (source == null) return null;
        ItemTemplate[] result = java.util.Arrays.copyOf(source, Math.max(source.length, 1200 + ICONS.length));
        for (int i = 0; i < ICONS.length; i++) {
            int id = 1200 + i;
            ItemTemplate old = result[id];
            if (old != null && old.name != null && !old.name.isEmpty()) continue;
            ItemTemplate item = new ItemTemplate(id);
            item.name = "Cải trang new" + (i + 1);
            item.detail = "Có thể ghép, tách và chọn ngoại hình như cải trang thường.";
            item.gioiTinh = 2; item.type = 14; item.idIcon = (short)ICONS[i];
            item.levelNeed = 10; item.idChar = (short)(500 + i);
            result[id] = item;
        }
        return result;
    }

    public static ItemOptionTemplate[] installOptions(ItemOptionTemplate[] source) {
        if (source == null) return null;
        ItemOptionTemplate[] result = java.util.Arrays.copyOf(source, Math.max(source.length, 404 + ICONS.length));
        for (int i = 0; i < ICONS.length; i++) {
            int id = 404 + i;
            ItemOptionTemplate old = result[id];
            if (old != null && old.name != null && !old.name.isEmpty()) continue;
            ItemOptionTemplate option = new ItemOptionTemplate(id);
            option.name = "Cải trang new" + (i + 1);
            option.type = 14; option.level = 10; option.strOption = "";
            result[id] = option;
        }
        return result;
    }

    public static boolean isAppearance(int id) { return id >= 500 && id < 500 + ICONS.length; }

    public static mImage finishImage(int id, String cacheKey, mImage image) {
        if (image == null || id < 31000 || id > 32259 ||
                !(cacheKey.startsWith("char_") || cacheKey.startsWith("client_"))) return image;
        try {
            image.smoothScaling = true;
            if (cacheKey.startsWith("client_")) {
                int size = 24 * DataCenter.gI().zoomLevel;
                if (image.c == size && image.d == size) return image;
                Pixmap scaled = new Pixmap(size, size, Format.RGBA8888);
                scaled.setBlending(Pixmap.Blending.None);
                scaled.setFilter(Pixmap.Filter.BiLinear);
                scaled.drawPixmap(image.b, 0, 0, image.c, image.d, 0, 0, size, size);
                image.b.dispose();
                image.b = scaled;
                image.c = size;
                image.d = size;
            }
            return image;
        } catch (Exception e) {
            Utlis.writeLog("Topup image " + cacheKey + ": " + e);
            return image;
        }
    }

    // Engine poses, shared by the original costume and equipped weapon (F[].d[0..32]).
    // Air poses reuse one silhouette; the native rig supplies the small motion offsets.
    private static final int[] NATIVE_POSES = {
        0,25, 1,2,3,4,5,6, 7,7,7, 7,7,7, 7,20,
        13,14,10,11,15,12,10,16,17,11,12,18,19,10,24,26,27
    };

    // Luffy's source sheet has 27 poses, unlike the earlier 28-pose packs:
    // 0/1 idle, 2..7 run, 8/9 airborne, 10..25 combat, 26 seated.
    // Native idle slots 0,1,31,32 must never select back-facing combat/seated art.
    private static final int[] LUFFY_POSES = {
        0,1, 2,3,4,5,6,7, 9,9,9, 9,9,9, 9,26,
        13,14,10,11,15,12,10,16,17,11,12,18,19,10,24,0,1
    };

    // New25 sheet: idle 0/1; run 2..7; airborne 8; combat 10..25; hurt 26; seated 27.
    private static final int[] NEW25_POSES = {
        1,1, 2,3,4,5,6,7, 8,8,8, 8,8,8, 9,27,
        12,16,11,12,17,13,11,16,17,12,13,18,19,11,26,1,1
    };

    static int sourceFrame(int enginePose, boolean luffy) {
        return (luffy ? LUFFY_POSES : NATIVE_POSES)[pose(enginePose)];
    }

    public static int pose(int enginePose) {
        return enginePose >= 0 && enginePose < NATIVE_POSES.length ? enginePose : 0;
    }

    public static int sourceFrame(int enginePose) { return NATIVE_POSES[pose(enginePose)]; }

    // Native idle cycle is 0 -> 1 -> 31 -> 32. Some supplied idle PNGs are identical.
    // Breathe by gently compressing the canvas, anchored at the feet, on that same cycle.
    public static int idleCompression(int enginePose) {
        return enginePose == 31 ? 2 : enginePose == 1 || enginePose == 32 ? 1 : 0;
    }

    public static LangLa_jr nativeReference() {
        DataCenter data = DataCenter.gI();
        if (data.H != null && data.H.length > 40 && data.H[40] != null) {
            int group = data.H[40].a[0][0];
            for (short id : data.G[group].a) {
                LangLa_jr part = data.F[id];
                if (part.b == 2 && part.d != null && part.d.length >= 33) return part;
            }
        }
        return null;
    }

    // Measured opaque sole edges in new25's 320px (zoom4) source canvases.
    // Rendering anchors the canvas bottom, so transparent padding otherwise floats above ground.
    private static final int[] NEW25_SOLE_BOTTOM = {298,296,296,296,293,293,293,299};

    static boolean new25GroundPose(int pose) {
        return (pose >= 0 && pose <= 7) || pose == 31 || pose == 32;
    }

    static int new25GroundOffset(int sourceFrame, int drawnHeight) {
        int padding = 319 - NEW25_SOLE_BOTTOM[sourceFrame];
        return Math.round(drawnHeight * padding / 320f);
    }

    public static void prepareNativePart(LangLa_jr part, LangLa_ju[] source, LangLa_jr reference) {
        if (source == null || source.length != 28) throw new IllegalArgumentException("Expected 28 topup source poses");
        boolean luffy = source[0] != null && source[0].a == 32100;
        boolean new25 = source[0] != null && source[0].a == 32200;
        LangLa_ju[] poses = new LangLa_ju[NATIVE_POSES.length];
        for (int i = 0; i < poses.length; i++) {
            LangLa_ju raw = source[new25 ? NEW25_POSES[i] : sourceFrame(i, luffy)];
            if (raw == null) throw new IllegalArgumentException("Missing topup source pose " + sourceFrame(i));
            LangLa_ju frame = new LangLa_ju(raw.a);
            frame.b = raw.b;
            frame.c = (short)(i == 18 || i == 19 || i == 21 || i == 22 || i == 25 || i == 26 || i == 29 ? 1 : 2);
            int motionX = 0, motionY = 0;
            if (reference != null && reference.d != null && reference.d.length >= poses.length) {
                frame.c = reference.d[i].c;
                if (luffy && i >= 8 && i <= 14) {
                    // Keep one airborne silhouette and a stable offset throughout flight.
                    frame.c = reference.d[8].c;
                } else if (i >= 2 && i <= 7) { motionX = reference.d[i].d - reference.d[2].d; motionY = reference.d[i].e - reference.d[2].e; } else if (i >= 8 && i <= 13) {
                    int start = i <= 10 ? 8 : 11;
                    motionX = reference.d[i].d - reference.d[start].d;
                    motionY = reference.d[i].e - reference.d[start].e;
                }
            }
            // Match the original costume's ~50-unit body height and hand position.
            frame.width = (short)Math.max(1, Math.round((raw.width > 0 ? raw.width : 80) * 0.85f));
            frame.height = (short)Math.max(1, Math.round((raw.height > 0 ? raw.height : 80) * 0.85f));
            frame.height = (short)Math.max(1, frame.height - idleCompression(i));
            frame.d = (short)(raw.d + 2 + motionX);
            frame.e = (byte)(raw.e + motionY);
            if (new25 && new25GroundPose(i)) {
                // Grounded feet stay on the baseline while idle breathing changes body height.
                frame.e = (byte)(raw.e + new25GroundOffset(NEW25_POSES[i], frame.height));
            }
            poses[i] = frame;
        }
        part.b = 98;
        part.d = poses;
    }
}
