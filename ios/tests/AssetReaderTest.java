import beatdz.Reader;
import beatdz.Utlis;
import java.io.*;
import java.util.Arrays;
import java.util.zip.DeflaterOutputStream;

public class AssetReaderTest {
    public static void main(String[] args) throws Exception {
        byte[] bytes = new byte[]{1,2,3,4,5,6,7,8};
        check(Arrays.equals(bytes, new Reader(chunked(bytes)).readFully()), "Stream available() used as file length");
        ByteArrayOutputStream framed = new ByteArrayOutputStream();
        DataOutputStream writer = new DataOutputStream(framed);
        writer.writeInt(bytes.length); writer.write(bytes);
        check(Arrays.equals(bytes, new Reader(chunked(framed.toByteArray())).read()), "Short read in length-prefixed asset");
        byte[] destination = new byte[10];
        new Reader(chunked(bytes)).read(destination, 1, 8);
        check(Arrays.equals(bytes, Arrays.copyOfRange(destination,1,9)), "Short read in buffer asset");
        ByteArrayOutputStream compressed = new ByteArrayOutputStream();
        try (DeflaterOutputStream deflater = new DeflaterOutputStream(compressed)) { deflater.write(bytes); }
        byte[] encoded = compressed.toByteArray();
        check(Arrays.equals(bytes, Utlis.inflateByteArray(encoded)), "Valid compressed data rejected");
        byte[] truncated = Arrays.copyOf(encoded, encoded.length - 2);
        long start = System.nanoTime();
        check(Arrays.equals(truncated, Utlis.inflateByteArray(truncated)), "Truncated data accepted");
        check(System.nanoTime() - start < 1000000000L, "Inflater stalled");
        System.out.println("PASS: partial stream reads, unknown length, complete and truncated compressed assets");
    }
    private static InputStream chunked(byte[] bytes) {
        return new ByteArrayInputStream(bytes) {
            public int available() { return 0; }
            public synchronized int read(byte[] b, int offset, int length) { return super.read(b,offset,Math.min(length,1)); }
        };
    }
    private static void check(boolean value, String message) { if (!value) throw new AssertionError(message); }
}
