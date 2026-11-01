import beatdz.AssetHttp;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.zip.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/** Desktop audit utility; not included in the iOS application. */
public class AssetHostingAudit {
    public static void main(String[] args) throws Exception {
        ImageIO.setUseCache(false);
        ExecutorService pool = Executors.newFixedThreadPool(4);
        List<Future<String>> results = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(args[0]));
        for (String line : lines.subList(1, lines.size())) {
            String[] fields = line.split(";");
            if (fields.length < 7 || !fields[1].endsWith(".zip")) continue;
            for (int zoom = 1; zoom <= 4; zoom++) {
                final String url = "http://daichienshinibi.com/img/zoom" + zoom + "/" + fields[1];
                final int expected = Integer.parseInt(fields[zoom + 2]);
                results.add(pool.submit(() -> audit(url, expected)));
            }
        }
        pool.shutdown();
        int failures = 0;
        for (Future<String> result : results) {
            try { System.out.println(result.get()); }
            catch (ExecutionException error) { failures++; System.out.println("FAIL " + error.getCause()); }
        }
        if (failures > 0) throw new AssertionError(failures + " archives failed");
    }
    private static String audit(String url, int expected) throws Exception {
        byte[] archive = AssetHttp.download(url, 1, 20000);
        if (archive == null || archive.length != expected) throw new IOException("Wrong size: " + url);
        int images = 0, other = 0;
        try (ZipInputStream zip = new ZipInputStream(new ByteArrayInputStream(archive))) {
            ZipEntry entry;
            byte[] buffer = new byte[16384];
            while ((entry = zip.getNextEntry()) != null) {
                if (entry.isDirectory()) continue;
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                int count;
                while ((count = zip.read(buffer)) >= 0) output.write(buffer, 0, count);
                byte[] data = output.toByteArray();
                if (!imageHeader(data)) {
                    for (int a = 0, b = Math.min(51, data.length) - 1; a < b; a++, b--) {
                        byte value = data[a]; data[a] = data[b]; data[b] = value;
                    }
                }
                if (imageHeader(data)) {
                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(data));
                    if (image == null) throw new IOException("Invalid image: " + url + "!" + entry.getName());
                    image.flush();
                    images++;
                } else {
                    if (entry.getName().endsWith(".png")) throw new IOException("Not an image: " + url + "!" + entry.getName());
                    other++;
                }
            }
        }
        return "PASS " + url + " images=" + images + " other=" + other;
    }
    private static boolean imageHeader(byte[] bytes) {
        return bytes.length >= 8 && ((bytes[0] == (byte)137 && bytes[1] == 80 && bytes[2] == 78 && bytes[3] == 71)
                || (bytes[0] == (byte)255 && bytes[1] == (byte)216 && bytes[2] == (byte)255));
    }
}
