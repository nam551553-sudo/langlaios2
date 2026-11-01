package beatdz;

import beatdz.*;

import beatdz.DataCenter;
import com.badlogic.gdx.files.FileHandle;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Binary {

    public static String a = "LangLaZ/";

    public static String c = "1.1.2_16";
    private static byte[] b = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 2, 0, 0, 0, 2, 8, 6, 0, 0, 0, 114, -74, 13, 36, 0, 0, 0, 11, 73, 68, 65, 84, 120, 94, 99, 96, 64, 7, 0, 0, 18, 0, 1, 11, -69, 36, -100, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

    public static Reader createReader(String var0) {
        byte[] var1;
        return (var1 = read(var0)) != null ? new Reader(var1) : null;
    }

    public static short[] a() {
        Reader var0 = null;

        try {
            if ((var0 = createReader("arr_keys")) != null) {
                short[] var1 = new short[]{var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort()};
                return var1;
            }
        } catch (Exception var4) {
            Utlis.println(var4);
        } finally {
            if (var0 != null) {
                var0.close();
            }

        }

        return new short[]{45, 51, 33, 46, 48, 19, 20, 21, 22, 34};
    }

    public static short[] b() {
        Reader var0 = null;

        short[] var1;
        try {
            if ((var0 = createReader("arr_screen")) == null) {
                return new short[]{1024, 600};
            }

            var1 = new short[]{var0.dis.readShort(), var0.dis.readShort()};
        } catch (Exception var4) {
            Utlis.println(var4);
            return new short[]{1024, 600};
        } finally {
            if (var0 != null) {
                var0.close();
            }

        }

        return var1;
    }

    public static byte[] b(String var0) {
        return a(var0, (ByteArrayOutputStream) null, (byte[]) null, new int[1], new int[1], 2);
    }

    public static byte[] c(String var0) {
        return a(var0, (ByteArrayOutputStream) null, (byte[]) null, new int[1], new int[1], 4);
    }

    private static byte[] a(String url, ByteArrayOutputStream ignored, byte[] unused,
                            int[] received, int[] attempts, int retries) {
        return AssetHttp.download(Utlis.i(url), DataCenter.ar ? 1 : retries, Utlis.timeOut,
                new AssetHttp.Progress() {
                    public void received(int bytes) {
                        Session.gI().countRecv += bytes;
                        Session.gI().k += bytes;
                    }
                });
    }
    public static String d(String var0) {
        HttpURLConnection var1 = null;
        BufferedReader var2 = null;
        String var3 = "";
        boolean var9 = false;

        label131:
        {
            try {
                var9 = true;
                (var1 = (HttpURLConnection) (new URL(var0)).openConnection()).setConnectTimeout(3000);
                var1.setReadTimeout(3000);
                var1.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36");

                for (var2 = new BufferedReader(new InputStreamReader(var1.getInputStream(), "UTF-8")); (var0 = var2.readLine()) != null; var3 = var3 + var0 + "\r\n") {
                }

                var9 = false;
                break label131;
            } catch (Exception var13) {
                var9 = false;
            } finally {
                if (var9) {
                    try {
                        if (var2 != null) {
                            var2.close();
                        }
                    } catch (Exception var10) {
                        Utlis.println(var10);
                    }

                    if (var1 != null) {
                        var1.disconnect();
                    }

                }
            }

            try {
                if (var2 != null) {
                    var2.close();
                }
            } catch (Exception var11) {
                Utlis.println(var11);
            }

            if (var1 != null) {
                var1.disconnect();
            }

            return var3;
        }

        try {
            var2.close();
        } catch (Exception var12) {
            Utlis.println(var12);
        }

        if (var1 != null) {
            var1.disconnect();
        }

        return var3;
    }

    public static String a(String url, int retries) {
        byte[] data = AssetHttp.download(url, retries, Utlis.timeOut);
        if (data == null) return null;
        try {
            return new String(data, "UTF-8");
        } catch (java.io.UnsupportedEncodingException impossible) {
            throw new AssertionError(impossible);
        }
    }
    public static byte[] read(String var0) {
        if (mConfig.isGDL() > 1) {
            if (var0.contains("tree_") || var0.contains("char_") || var0.contains("client_") || var0.contains("mapmini_") || var0.contains("mapsmall_")) {
                return b;
            }
        } else if (mConfig.isGDL() == 1 && (var0.contains("tree_") || var0.contains("char_") || var0.contains("mapsmall_"))) {
            return b;
        }

        mFileHandle var1 = null;
        byte[] var2 = null;
        boolean var10 = false;

        label275:
        {
            try {
                var10 = true;
                if ((var2 = (var1 = mFileHandle.a(Binary2.a(var0), false)).a(1)) == null) {
                    int var3 = DataCenter.gI().zoomLevel;
                    if (var0.contains("tree") && var3 >= 2) {
                        var3 = 2;
                    }

                    if (!var0.equals("arr_data_game") && !var0.equals("arr_check_0")) {
                        var1 = mFileHandle.b("data/" + var3 + "/" + var0 + ".beatdz", false);
                    } else {
                        var1 = mFileHandle.b("data/" + var0 + ".beatdz", false);
                    }

                    if ((var2 = var1.a(1)) != null && var0.equals("arr_check_0")) {
                        try {
                            var3 = Integer.parseInt(new String(var2, "UTF-8"));
                            writeInt(var0, var3);
                            DataCenter.gI().a(true);
                        } catch (Exception var14) {
                        }
                    }
                }

                if (var2 != null) {
                    if (var0.equals("arr_data_game")) {
                        var2 = Utlis.inflateByteArray(var2);
                        var10 = false;
                    } else if (!var0.contains("size")) {
                        if (!var0.contains("mapmini") && !var0.contains("mapsmall") && !var0.contains("mapscale") && !var0.contains("char_") && !var0.contains("client_") && !var0.contains("tree_") && !var0.contains("font_")) {
                            var10 = false;
                        } else {
                            Utlis.a(var2);
                            var10 = false;
                        }
                    } else {
                        var10 = false;
                    }
                } else {
                    var10 = false;
                }
                break label275;
            } catch (Exception var15) {
                Utlis.println(var15);
                var10 = false;
            } finally {
                if (var10) {
                    try {
                        if (var1 != null) {
                            var1.a = null;
                        }
                    } catch (Exception var11) {
                        Utlis.println(var11);
                    }

                }
            }

            try {
                if (var1 != null) {
                    var1.a = null;
                    return var2;
                }
            } catch (Exception var12) {
                Utlis.println(var12);
            }

            return var2;
        }

        try {
            if (var1 != null) {
                var1.a = null;
            }
        } catch (Exception var13) {
            Utlis.println(var13);
        }

        return var2;
    }

    public static int readInt(String var0) {
        try {
            return Integer.parseInt(readUTF(var0));
        } catch (Exception var1) {
            return Integer.MIN_VALUE;
        }
    }

    public static boolean readBoolan(String var0) {
        byte[] var1;
        if ((var1 = read(var0)) == null) {
            return false;
        } else {
            return var1[0] != 0;
        }
    }

    public static String readUTF(String var0) {
        Object var1 = null;

        try {
            byte[] var3;
            return (var3 = read(var0)) == null ? null : new String(var3, "UTF-8");
        } catch (Exception var2) {
            Utlis.println(var2);
            return new String((byte[]) var1);
        }
    }

    public static void write(String var0, byte[] var1) {
        if (var0.contains("arr_map_") || var0.contains("arr_data_game") || LangLa_ep.g <= 0 || mConfig.isGDL() <= 0) {
            mFileHandle var2 = null;
            boolean var8 = false;

            label103:
            {
                try {
                    var8 = true;
                    if ((var2 = mFileHandle.a(Binary2.a(var0), true)).a() > 0) {
                        var2.a(1, var1, 0, var1.length);
                        var8 = false;
                    } else {
                        var2.a(var1, 0, var1.length);
                        var8 = false;
                    }
                    break label103;
                } catch (Exception var12) {
                    var8 = false;
                } finally {
                    if (var8) {
                        try {
                            if (var2 != null) {
                                var2.a = null;
                            }
                        } catch (Exception var9) {
                            Utlis.println(var9);
                        }

                    }
                }

                try {
                    if (var2 != null) {
                        var2.a = null;
                    }

                    return;
                } catch (Exception var10) {
                    Utlis.println(var10);
                    return;
                }
            }

            try {
                if (var2 != null) {
                    var2.a = null;
                }

            } catch (Exception var11) {
                Utlis.println(var11);
            }
        }
    }

    public static void write(String var0, byte[] var1, String var2) {
        if (var0.contains("arr_map_") || var0.contains("arr_data_game") || LangLa_ep.g <= 0 || mConfig.isGDL() <= 0) {
            mFileHandle var3 = null;
            boolean var9 = false;

            label104:
            {
                try {
                    var9 = true;
                    if ((var3 = mFileHandle.a(Binary2.a(var0, var2), true)).a() > 0) {
                        var3.a(1, var1, 0, var1.length);
                        var9 = false;
                    } else {
                        var3.a(var1, 0, var1.length);
                        var9 = false;
                    }
                    break label104;
                } catch (Exception var13) {
                    Utlis.println(var13);
                    var9 = false;
                } finally {
                    if (var9) {
                        try {
                            if (var3 != null) {
                                var3.a = null;
                            }
                        } catch (Exception var11) {
                            Utlis.println(var11);
                        }

                    }
                }

                try {
                    if (var3 != null) {
                        var3.a = null;
                    }

                    return;
                } catch (Exception var10) {
                    Utlis.println(var10);
                    return;
                }
            }

            try {
                if (var3 != null) {
                    var3.a = null;
                }

            } catch (Exception var12) {
                Utlis.println(var12);
            }
        }
    }

    public static void writeUTF(String var0, String var1) {
        try {
            Binary.write(var0, var1.getBytes("UTF-8"));
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void writeInt(String var0, int var1) {
        try {
            Binary.write(var0, String.valueOf(var1).getBytes("UTF-8"));
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void writeBoolean(String var0, boolean var1) {
        try {
            Binary.write(var0, new byte[]{(byte) (var1 ? 1 : 0)});
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static mImage createImage(String var0) {
        try {
            byte[] var2;
            return mImage.a(var2 = read(var0), 0, var2.length);
        } catch (Exception var1) {
            return null;
        }
    }

    public static mImage createImage(byte[] var0) {
        try {
            return mImage.a(var0, 0, var0.length);
        } catch (Exception var1) {
            Utlis.println(var1);
            return null;
        }
    }

    public static mImage createImage(int var0, int var1) {
        try {
            return mImage.a(var0, var1);
        } catch (Exception var2) {
            Utlis.println(var2);
            return null;
        }
    }

    public static void disposeImage(mImage var0) {
        if (var0 != null) {
            var0.d();
        }

    }

    public static void cleanImage(mImage var0) {
        if (var0 != null) {
            var0 = var0;

            try {
                if (var0.equals(LangLa_fq.a)) {
                    return;
                }

                if (var0.b != null) {
                    var0.b.dispose();
                    var0.b = null;
                }

                if (var0.a != null) {
                    var0.a.dispose();
                    var0.a = null;
                }

                return;
            } catch (Exception var1) {
                Utlis.println(var1);
            }
        }

    }

    public static void delete(String var0) {
        try {
            Utlis.external(a + var0).delete();
        } catch (Exception var1) {
            Utlis.println(var1);
        }
    }

    public static void deleteStartsWith(String var0) {
        try {
            FileHandle[] var1;
            int var2 = (var1 = Utlis.external(a).list()).length;

            for (int var3 = 0; var3 < var2; ++var3) {
                FileHandle var4;
                if ((var4 = var1[var3]).name().startsWith(var0)) {
                    var4.delete();
                }
            }

        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public static void deleteAll() {
        if (DataCenter.k()) {
            DataCenter.gI().aG = true;
        }

        try {
            FileHandle[] var0;
            int var1 = (var0 = Utlis.external(a).list()).length;

            for (int var2 = 0; var2 < var1; ++var2) {
                FileHandle var3 = var0[var2];

                try {
                    if (!var3.name().startsWith("arr_acc") && !var3.name().startsWith("arr_config") && !var3.name().startsWith("arr_screen") && !var3.name().startsWith("arr_server") && !var3.name().startsWith("arr_binary")) {
                        var3.delete();
                    }
                } catch (Exception var4) {
                }
            }

            DataCenter var6;
            DataCenter var10000 = var6 = DataCenter.gI();
            DataCenter.aQ = 0;
            var10000.typeArr = var6.A = var6.B = var6.D = var6.C = 0;
            CheckVersionScreen.b = false;
            DataCenter.bd = 0;
        } catch (Exception var5) {
            Utlis.println(var5);
        }

        DataCenter.gI().setScreen((MainScreen) (new LangLa_ff()));
    }

    public static void a(byte[] bytes, boolean refresh) {
        extractArchive(bytes, refresh, null);
    }

    public static void extractArchive(byte[] bytes, boolean refresh, String prefix) {
        int files = 0;
        try (ZipInputStream zip = new ZipInputStream(new ByteArrayInputStream(bytes))) {
            ZipEntry entry;
            byte[] buffer = new byte[16384];
            while ((entry = zip.getNextEntry()) != null) {
                if (entry.isDirectory()) continue;
                String name = entry.getName().replace('\\', '/');
                if (name.startsWith("/") || name.contains("..")) {
                    throw new java.io.IOException("Invalid asset path: " + name);
                }
                if (name.endsWith(".png")) name = name.substring(0, name.length() - 4);
                else if (name.endsWith(".beatdz")) name = name.substring(0, name.length() - 7);
                if (prefix != null && !name.contains("_") && !name.contains("/")) name = prefix + name;
                String key = name.replace("bitmapC", "c").replace("iconTree", "tree")
                        .replace("iconChar", "char_icon").replace("iconClient", "client_icon").replace('/', '_');
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                int count;
                while ((count = zip.read(buffer)) != -1) output.write(buffer, 0, count);
                byte[] data = output.toByteArray();
                if (data.length == 0) continue;
                Binary.write(key, data);
                files++;
                if (refresh) {
                    Hashtable images = key.startsWith("char_") ? LangLa_fq.g
                            : key.startsWith("client_") ? LangLa_fq.e
                            : key.startsWith("tree_") ? LangLa_fq.f : null;
                    if (images != null) {
                        short id = Short.parseShort(key.substring(key.lastIndexOf('_') + 1));
                        if (images.get(id) != null) {
                            mImage image = Binary.createImage(Utlis.a(data));
                            if (image != null) images.put(id, image);
                        }
                    }
                }
            }
            if (files == 0) throw new java.io.IOException("Empty or invalid asset archive");
        } catch (java.io.IOException failure) {
            // Do not mark a failed archive as installed in arr_check_*.
            throw new IllegalArgumentException("Cannot unpack assets", failure);
        }
    }
}
