package beatdz;

import com.badlogic.gdx.graphics.Pixmap;

/** Softens the sky edges of the winter tiles without moving their world anchors. */
public final class KonohaScenery {
    public static boolean active() {
        return DataCenter.gI().currentScreen instanceof GameSrc
                && GameSrc.gI().mapID == 86 && !mConfig.gI().readBoolean(18);
    }

    static mImage featherSkyEdges(mImage tile) {
        mImage result = mImage.a(tile.c, tile.d);
        if (result == null) return tile;
        result.b.setBlending(Pixmap.Blending.None);
        result.b.drawPixmap(tile.b, 0, 0);
        int feather = Math.max(8, tile.c / 22);
        for (int y = 0; y < tile.d; y++) {
            for (int x = 0; x < tile.c; x++) {
                int distance = Math.min(y, Math.min(x, tile.c - 1 - x));
                if (distance >= feather) continue;
                int rgba = tile.b.getPixel(x, y);
                int red = rgba >>> 24;
                int green = rgba >>> 16 & 255;
                int blue = rgba >>> 8 & 255;
                if (blue < 115 || blue - red < 15 || blue - green < 7) continue;
                float weight = (float) distance / feather;
                int alpha = Math.round((rgba & 255) * weight * weight * (3 - 2 * weight));
                result.b.drawPixel(x, y, rgba & 0xffffff00 | alpha);
            }
        }
        result.smoothScaling = true;
        tile.a();
        return result;
    }

    private KonohaScenery() {}
}
