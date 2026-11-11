package beatdz;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** Visual sequence for the Sasuke costume's existing Susano effect. */
final class SasukeSusanoMotion {
    private static Texture pixel;

    private SasukeSusanoMotion() {}

    static void draw(Graphics graphics, int x, int y, boolean mirror, long elapsed) {
        SpriteBatch batch = graphics.getSpriteBatch();
        if (!batch.isDrawing() || mConfig.gI().readByte(18) > 1) return;
        if (pixel == null) {
            Pixmap white = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
            white.drawPixel(0, 0, 0xffffffff);
            try {
                pixel = new Texture(white);
            } finally {
                white.dispose();
            }
        }

        float previousColor = batch.getPackedColor();
        float scale = DataCenter.gI().zoomLevel;
        float centerX = (x + graphics.a) * scale;
        float centerY = (y + graphics.b - 36) * scale;
        int side = mirror ? -1 : 1;
        try {
            if (elapsed >= 1100 && elapsed < 3600) {
                float charge = Math.min(1f, (elapsed - 1100) / 1750f);
                float radius = (3 + 9 * charge) * scale;
                float handX = centerX + side * 18 * scale;
                float handY = centerY + 9 * scale;
                arc(batch, handX, handY, radius, elapsed / 150f, 5.6f, 4 * scale, .32f);
                arc(batch, handX, handY, radius * .74f, -elapsed / 150f, 5.2f, 1.3f * scale, .86f);
                batch.setColor(.95f, .74f, 1f, .72f);
                batch.draw(pixel, handX - scale, handY - scale, scale * 2, scale * 2);
            }
            if (elapsed >= 3600 && elapsed < 4680) {
                slash(batch, centerX, centerY, scale, side, (elapsed - 3600) / 680f);
                slash(batch, centerX, centerY, scale, -side, (elapsed - 3820) / 760f);
            }
            if (elapsed >= 4140 && elapsed < 5400) {
                float pulse = (elapsed - 4140) / 1260f;
                arc(batch, centerX, centerY, (8 + 50 * pulse) * scale, pulse * 2,
                        6.28f, 3 * scale, (1 - pulse) * .65f);
            }
            sparks(batch, centerX, centerY, scale, elapsed);
        } finally {
            batch.setPackedColor(previousColor);
        }
    }

    private static void slash(SpriteBatch batch, float x, float y, float scale, int side, float progress) {
        if (progress < 0 || progress >= 1) return;
        float span = Math.min(1, progress * 3);
        float endX = x + side * (90 * span - 45) * scale;
        float endY = y + (52 * span - 26) * scale;
        float alpha = 1 - progress;
        batch.setColor(.71f, .22f, 1f, alpha * .38f);
        segment(batch, x - side * 45 * scale, y - 26 * scale, endX, endY, 10 * scale);
        batch.setColor(.96f, .74f, 1f, alpha * .96f);
        segment(batch, x - side * 45 * scale, y - 26 * scale, endX, endY, 2 * scale);
    }

    private static void arc(SpriteBatch batch, float x, float y, float radius,
                            float start, float span, float width, float alpha) {
        batch.setColor(.79f, .39f, 1f, alpha);
        float lastX = x + radius * (float) Math.cos(start);
        float lastY = y + radius * (float) Math.sin(start);
        for (int i = 1; i <= 18; i++) {
            float angle = start + span * i / 18;
            float nextX = x + radius * (float) Math.cos(angle);
            float nextY = y + radius * (float) Math.sin(angle);
            segment(batch, lastX, lastY, nextX, nextY, width);
            lastX = nextX;
            lastY = nextY;
        }
    }

    private static void sparks(SpriteBatch batch, float x, float y, float scale, long elapsed) {
        for (int spark = 0; spark < 7; spark++) {
            float life = ((elapsed + spark * 129) % 910) / 910f;
            float angle = spark * 2.4f + life * .8f;
            float radius = (24 + life * 27) * scale;
            float sx = x + radius * (float) Math.cos(angle);
            float sy = y + radius * (float) Math.sin(angle);
            batch.setColor(.84f, .45f, 1f, (1 - life) * .72f);
            segment(batch, sx - 3 * scale, sy + 2 * scale, sx, sy - scale, scale);
            segment(batch, sx, sy - scale, sx + 3 * scale, sy, scale);
        }
    }

    private static void segment(SpriteBatch batch, float x1, float y1, float x2, float y2, float width) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        float length = (float) Math.sqrt(dx * dx + dy * dy);
        float rotation = (float) Math.toDegrees(Math.atan2(dy, dx));
        batch.draw(pixel, x1, y1 - width / 2, 0, width / 2, length, width,
                1, 1, rotation, 0, 0, 1, 1, false, false);
    }
}
