import beatdz.AssetHttp;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class AssetHttpTest {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        AtomicInteger attempts = new AtomicInteger();
        AtomicInteger missing = new AtomicInteger();
        byte[] expected = new byte[61000000];
        Arrays.fill(expected, (byte) 42);
        server.createContext("/large", exchange -> {
            exchange.sendResponseHeaders(200, expected.length);
            exchange.getResponseBody().write(expected);
            exchange.close();
        });
        server.createContext("/retry", exchange -> {
            int attempt = attempts.incrementAndGet();
            exchange.sendResponseHeaders(200, 8);
            exchange.getResponseBody().write(attempt == 1 ? new byte[]{1,2} : new byte[]{1,2,3,4,5,6,7,8});
            exchange.close();
        });
        server.createContext("/missing", exchange -> {
            missing.incrementAndGet();
            exchange.sendResponseHeaders(404, -1);
            exchange.close();
        });
        server.createContext("/fail", exchange -> {
            exchange.sendResponseHeaders(503, -1);
            exchange.close();
        });
        server.start();
        try {
            String root = "http://127.0.0.1:" + server.getAddress().getPort();
            check(Arrays.equals(expected, AssetHttp.download(root + "/large", 0, 5000)), "61 MB download corruption");
            check(Arrays.equals(new byte[]{1,2,3,4,5,6,7,8}, AssetHttp.download(root + "/retry", 2, 1000)), "Partial bytes retained on retry");
            check(attempts.get() == 2, "Partial response was not retried");
            check(AssetHttp.download(root + "/missing", 4, 1000) == null && missing.get() == 1, "404 retried");
            long start = System.currentTimeMillis();
            check(AssetHttp.download(root + "/fail", 2, 1000) == null, "503 accepted");
            check(System.currentTimeMillis() - start < 5000, "Retry loop did not terminate");
            System.out.println("PASS: large file, truncated response recovery, 404, bounded retry");
        } finally {
            server.stop(0);
        }
    }
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}
