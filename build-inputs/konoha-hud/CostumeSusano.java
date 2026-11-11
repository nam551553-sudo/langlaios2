package beatdz;

/** Costume artwork for the existing server-side Susano transformation. */
enum CostumeSusano {
    NARUTO(1304, 32670, 10, 196, 160, 12),
    // Compensate for the smaller height, then lift the face another 12 units.
    ITACHI(1318, 32710, 4, 212, 102, 30),
    SASUKE(1327, 32714, 1, 92, 84, 0);

    private static final int EFFECT_ID = 101;
    private static final int NARUTO_FRAME_MS = 90;
    private static final int NARUTO_INTRO_MS = 10 * NARUTO_FRAME_MS;
    private static final int ITACHI_FRAME_MS = 100;
    private static final int[] ITACHI_CYCLE = {0, 1, 2, 3, 2, 1};
    private final int itemId, firstFrame, width, height, verticalLift;
    private final mImage[][] frames;

    CostumeSusano(int itemId, int firstFrame, int frameCount, int width, int height, int verticalLift) {
        this.itemId = itemId;
        this.firstFrame = firstFrame;
        this.width = width;
        this.height = height;
        this.verticalLift = verticalLift;
        this.frames = new mImage[4][frameCount];
    }

    private static CostumeSusano forItem(int itemId) {
        if (itemId == NARUTO.itemId) return NARUTO;
        if (itemId == ITACHI.itemId) return ITACHI;
        if (itemId == SASUKE.itemId) return SASUKE;
        return null;
    }

    static boolean hasCustomArt(int itemId) {
        return forItem(itemId) != null;
    }

    static boolean canCast(Item costume) {
        if (costume == null) return false;
        if (hasCustomArt(costume.id) || costume.id == 788) return true;
        return costume.strOptions != null && (";" + costume.strOptions + ";").contains(";333,0;");
    }

    static boolean replacesShisui(Char character) {
        Item[] equipment = character.arrItemBody;
        return equipment != null && equipment.length > 14 && equipment[14] != null
                && hasCustomArt(equipment[14].id);
    }

    static void draw(Graphics graphics, Char character, int x, int y) {
        Item[] equipment = character.arrItemBody;
        if (character.hp <= 0 || character.aQ || equipment == null || equipment.length <= 14
                || equipment[14] == null) return;
        CostumeSusano art = forItem(equipment[14].id);
        if (art == null) return;

        for (int i = 0; i < character.vEffect.size(); i++) {
            Effect effect = (Effect) character.vEffect.elementAt(i);
            if (effect.id != EFFECT_ID) continue;
            long elapsed = Math.max(0, Utlis.time() - effect.timeStart);
            if (effect.maintain >= 0 && elapsed >= effect.maintain) return;
            mImage image = art.frameImage(DataCenter.gI().zoomLevel, art.frameAt(elapsed));
            if (image == null || image.c <= 1) return;
            float bob = art == NARUTO && elapsed >= NARUTO_INTRO_MS ? (float) Math.sin(elapsed / 210.0) * 1.2f : 0;
            float width = art.width;
            float height = art.height;
            float sway = 0;
            if (art == SASUKE) {
                double phase = (elapsed % 1500L) * 2 * Math.PI / 1500.0;
                width += 3 * (float) Math.sin(phase);
                height += 2 * (float) Math.sin(phase + 0.6);
                sway = 1.5f * (float) Math.sin(phase - 0.5);
                bob = 1.7f * (float) Math.cos(phase);
            }
            graphics.drawTopupGripRegion(image, 0, 0, image.c, image.d,
                    x - width / 2f + sway, y - height + 3 - art.verticalLift + bob, width, height, character.i());
            return;
        }
    }

    int frameAt(long elapsed) {
        if (this == SASUKE) return 0;
        if (this == ITACHI) return ITACHI_CYCLE[(int) ((elapsed / ITACHI_FRAME_MS) % ITACHI_CYCLE.length)];
        return elapsed < NARUTO_INTRO_MS ? (int) (elapsed / NARUTO_FRAME_MS) : 4;
    }

    private mImage frameImage(int zoom, int frame) {
        if (zoom < 1 || zoom > frames.length) return null;
        mImage image = frames[zoom - 1][frame];
        if (image == null) {
            int id = firstFrame + frame;
            try {
                image = Binary.createImage(Utlis.internal(
                        "resource/susano" + itemId + "/zoom" + zoom + "/" + id + ".png").readBytes());
                if (image != null && image.c > 1) frames[zoom - 1][frame] = image;
            } catch (Exception ignored) {
                // Resource updates can also supply this frame through the icon cache.
            }
            if (image == null || image.c <= 1) image = LangLa_fq.a(id);
            if (image != null && image.c > 1) image.smoothScaling = true;
        }
        return image;
    }
}
