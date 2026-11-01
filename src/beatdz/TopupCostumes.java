package beatdz;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;

/** Animation rig and filtering for new1-new23 images loaded by the normal web/cache queue. */
public final class TopupCostumes {
    private TopupCostumes() {}

    public static boolean isAppearance(int id) { return id >= 500 && id < 523; }

    public static mImage finishImage(int id, String cacheKey, mImage image) {
        if (image == null || id < 31000 || id > 32059 ||
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

    public static void prepareNativePart(LangLa_jr part, LangLa_ju[] source, LangLa_jr reference) {
        if (source == null || source.length != 28) throw new IllegalArgumentException("Expected 28 topup source poses");
        LangLa_ju[] poses = new LangLa_ju[NATIVE_POSES.length];
        for (int i = 0; i < poses.length; i++) {
            LangLa_ju raw = source[sourceFrame(i)];
            if (raw == null) throw new IllegalArgumentException("Missing topup source pose " + sourceFrame(i));
            LangLa_ju frame = new LangLa_ju(raw.a);
            frame.b = raw.b;
            frame.c = (short)(i == 18 || i == 19 || i == 21 || i == 22 || i == 25 || i == 26 || i == 29 ? 1 : 2);
            int motionX = 0, motionY = 0;
            if (reference != null && reference.d != null && reference.d.length >= poses.length) {
                frame.c = reference.d[i].c;
                if (i >= 2 && i <= 7) { motionX = reference.d[i].d - reference.d[2].d; motionY = reference.d[i].e - reference.d[2].e; } else if (i >= 8 && i <= 13) {
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
            poses[i] = frame;
        }
        part.b = 98;
        part.d = poses;
    }
}
