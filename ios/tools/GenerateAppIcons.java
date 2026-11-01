import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.regex.*;
import javax.imageio.ImageIO;

/** Deterministic iOS asset generation from the existing 1024px application icon. */
public class GenerateAppIcons {
    public static void main(String[] args) throws Exception {
        Path directory = Paths.get(args[0]);
        BufferedImage master = ImageIO.read(directory.resolve("app-store-icon-1024@1x.png").toFile());
        String catalog = new String(Files.readAllBytes(directory.resolve("Contents.json")), StandardCharsets.UTF_8);
        Matcher entry = Pattern.compile("\\{[^{}]*\\}").matcher(catalog);
        int count = 0;
        while (entry.find()) {
            String object = entry.group();
            String filename = value(object, "filename");
            if (filename == null) continue;
            String[] dimensions = value(object, "size").split("x");
            double scale = Double.parseDouble(value(object, "scale").replace("x", ""));
            int width = (int)Math.round(Double.parseDouble(dimensions[0]) * scale);
            int height = (int)Math.round(Double.parseDouble(dimensions[1]) * scale);
            Path target = directory.resolve(filename);
            BufferedImage current = Files.exists(target) ? ImageIO.read(target.toFile()) : null;
            if (current != null && current.getWidth() == width && current.getHeight() == height) continue;
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = image.createGraphics();
            graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            graphics.drawImage(master, 0, 0, width, height, null);
            graphics.dispose();
            ImageIO.write(image, "png", target.toFile());
            count++;
        }
        System.out.println("Generated " + count + " application icon sizes");
    }
    private static String value(String object, String key) {
        Matcher matcher = Pattern.compile("\"" + key + "\"\\s*:\\s*\"([^\"]+)\"").matcher(object);
        return matcher.find() ? matcher.group(1) : null;
    }
}
