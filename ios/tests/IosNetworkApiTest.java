import java.io.*;
import java.util.*;
import java.util.jar.*;

/** Verify actual compiled HTTP calls against the iOS runtime, rather than the desktop JDK. */
public class IosNetworkApiTest {
    private static final class ClassInfo {
        Object[] pool;
        int[] tags;
        String parent;
        Set<String> methods = new HashSet<>();
        String text(int index) { return (String)pool[index]; }
        String className(int index) { return text((Integer)pool[index]); }
    }
    public static void main(String[] args) throws Exception {
        try (JarFile runtime = new JarFile(args[0]); InputStream input = args.length > 1
                ? new FileInputStream(args[1]) : IosNetworkApiTest.class.getResourceAsStream("/beatdz/AssetHttp.class")) {
            ClassInfo client = read(input);
            int checked = 0;
            for (int index = 1; index < client.pool.length; index++) {
                if (client.tags[index] != 10 && client.tags[index] != 11) continue;
                int[] reference = (int[])client.pool[index];
                String owner = client.className(reference[0]);
                if (!owner.startsWith("java/net/")) continue;
                int[] nameType = (int[])client.pool[reference[1]];
                String signature = client.text(nameType[0]) + client.text(nameType[1]);
                if (!available(runtime, owner, signature)) {
                    throw new AssertionError("RoboVM runtime has no " + owner + "." + signature);
                }
                checked++;
            }
            if (checked < 5) throw new AssertionError("HTTP bytecode not inspected");
            System.out.println("PASS: " + checked + " compiled HTTP method calls exist in the actual RoboVM iOS runtime");
        }
    }
    private static boolean available(JarFile runtime, String owner, String method) throws Exception {
        JarEntry entry = runtime.getJarEntry(owner + ".class");
        if (entry == null) return false;
        ClassInfo type;
        try (InputStream input = runtime.getInputStream(entry)) { type = read(input); }
        return type.methods.contains(method) || (type.parent != null && available(runtime,type.parent,method));
    }
    private static ClassInfo read(InputStream input) throws IOException {
        DataInputStream data = new DataInputStream(input);
        if (data.readInt() != 0xcafebabe) throw new IOException("Invalid class file");
        data.readUnsignedShort(); data.readUnsignedShort();
        ClassInfo result = new ClassInfo();
        int count = data.readUnsignedShort(); result.pool = new Object[count]; result.tags = new int[count];
        for (int index = 1; index < count; index++) {
            int tag = data.readUnsignedByte(); result.tags[index] = tag;
            switch (tag) {
                case 1: result.pool[index] = data.readUTF(); break;
                case 3: case 4: data.readInt(); break;
                case 5: case 6: data.readLong(); index++; break;
                case 7: case 8: case 16: case 19: case 20: result.pool[index] = data.readUnsignedShort(); break;
                case 9: case 10: case 11: case 12: case 17: case 18:
                    result.pool[index] = new int[]{data.readUnsignedShort(),data.readUnsignedShort()}; break;
                case 15: data.readUnsignedByte(); data.readUnsignedShort(); break;
                default: throw new IOException("Unknown constant pool tag " + tag);
            }
        }
        data.readUnsignedShort(); data.readUnsignedShort();
        int parent = data.readUnsignedShort(); result.parent = parent == 0 ? null : result.className(parent);
        int interfaces = data.readUnsignedShort(); for (int i=0;i<interfaces;i++) data.readUnsignedShort();
        int fields = data.readUnsignedShort();
        for (int i=0;i<fields;i++) { data.readUnsignedShort(); data.readUnsignedShort(); data.readUnsignedShort(); attributes(data); }
        int methods = data.readUnsignedShort();
        for (int i=0;i<methods;i++) {
            data.readUnsignedShort(); int name=data.readUnsignedShort(), descriptor=data.readUnsignedShort();
            result.methods.add(result.text(name)+result.text(descriptor)); attributes(data);
        }
        return result;
    }
    private static void attributes(DataInputStream data) throws IOException {
        int count=data.readUnsignedShort(); byte[] buffer=new byte[8192];
        for (int i=0;i<count;i++) {
            data.readUnsignedShort(); int length=data.readInt();
            while (length>0) { int size=Math.min(length,buffer.length); data.readFully(buffer,0,size); length-=size; }
        }
    }
}
