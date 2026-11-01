package beatdz;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/** Downloads whole responses; failed attempts never leak partial bytes into the cache. */
public final class AssetHttp {
    private AssetHttp() {}

    public static byte[] download(String url, int retries, int timeout) {
        for (int attempt = 0; attempt <= Math.max(0, retries); attempt++) {
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setConnectTimeout(timeout);
                connection.setReadTimeout(timeout * 2);
                connection.setRequestProperty("User-Agent", "LangLa/1.0");
                connection.setRequestProperty("Accept-Encoding", "identity");
                int status = connection.getResponseCode();
                if (status != HttpURLConnection.HTTP_OK) {
                    if (status >= 400 && status < 500 && status != 408 && status != 429) return null;
                    throw new IOException("HTTP " + status);
                }
                try (InputStream input = connection.getInputStream();
                     ByteArrayOutputStream output = new ByteArrayOutputStream()) {
                    byte[] buffer = new byte[16384];
                    int count;
                    while ((count = input.read(buffer)) != -1) output.write(buffer, 0, count);
                    byte[] bytes = output.toByteArray();
                    long expected = connection.getContentLengthLong();
                    if (bytes.length == 0 || (expected >= 0 && expected != bytes.length)) {
                        throw new IOException("Incomplete response");
                    }
                    return bytes;
                }
            } catch (IOException failure) {
                if (attempt == Math.max(0, retries)) {
                    System.err.println("Asset download failed: " + url + " (" + failure.getMessage() + ")");
                }
            } finally {
                if (connection != null) connection.disconnect();
            }
        }
        return null;
    }
}
