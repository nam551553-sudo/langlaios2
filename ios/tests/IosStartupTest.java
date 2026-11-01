import beatdz.*;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.GdxNativesLoader;
import java.io.*;
import java.lang.reflect.*;
import java.nio.file.*;
import java.util.concurrent.*;

/** Runs the actual loading-screen -> login transition with web access unavailable. */
public class IosStartupTest {
    public static void main(String[] args) {
        try { verify(); System.exit(0); }
        catch (Throwable failure) { failure.printStackTrace(); System.exit(1); }
    }
    private static void verify() throws Exception {
        GdxNativesLoader.load();
        Path root = Files.createTempDirectory("ios-startup-test");
        Path assets = Paths.get("data").toAbsolutePath();
        System.setProperty("langla.assets", "http://127.0.0.1:1/");
        Gdx.files = (com.badlogic.gdx.Files)Proxy.newProxyInstance(com.badlogic.gdx.Files.class.getClassLoader(),
                new Class[]{com.badlogic.gdx.Files.class}, (p,m,a) -> {
                    if (m.getName().equals("local")) return new com.badlogic.gdx.files.FileHandle(root.resolve((String)a[0]).toFile());
                    if (m.getName().equals("internal")) {
                        String name = (String)a[0];
                        Path file = name.startsWith("resource/") ? Paths.get("..").resolve(name) : assets.resolve(name);
                        return new com.badlogic.gdx.files.FileHandle(file.toFile());
                    }
                    return defaultValue(m.getReturnType());
                });
        Gdx.app = (Application)Proxy.newProxyInstance(Application.class.getClassLoader(),new Class[]{Application.class},
                (p,m,a) -> m.getName().equals("getType") ? Application.ApplicationType.iOS : defaultValue(m.getReturnType()));
        Gdx.graphics = (com.badlogic.gdx.Graphics)Proxy.newProxyInstance(com.badlogic.gdx.Graphics.class.getClassLoader(),
                new Class[]{com.badlogic.gdx.Graphics.class}, (p,m,a) -> defaultValue(m.getReturnType()));
        Gdx.gl = Gdx.gl20 = (GL20)Proxy.newProxyInstance(GL20.class.getClassLoader(),new Class[]{GL20.class},
                (p,m,a) -> m.getReturnType() == int.class ? 1 : defaultValue(m.getReturnType()));
        // A tiny real bitmap font provides widget metrics without a window or GPU.
        Pixmap pixel = new Pixmap(1,1,Pixmap.Format.RGBA8888);
        Texture texture = new Texture(pixel); pixel.dispose();
        BitmapFont.BitmapFontData metrics = new BitmapFont.BitmapFontData();
        metrics.lineHeight = 24; metrics.capHeight = 20; metrics.xHeight = 18; metrics.spaceXadvance = 10;
        for (char letter : mFont.k.toCharArray()) {
            BitmapFont.Glyph glyph = new BitmapFont.Glyph();
            glyph.id = letter; glyph.width = 1; glyph.height = 1; glyph.xadvance = 10;
            metrics.setGlyph(letter, glyph);
        }
        BitmapFont font = new BitmapFont(metrics,new TextureRegion(texture),false);
        for (String name : new String[]{"D","E","F","G","H"}) {
            Field field = beatdz.Graphics.class.getDeclaredField(name); field.setAccessible(true); field.set(null,font);
        }
        com.tgame.model.Caption.loadVN();
        DataCenter data = DataCenter.gI();
        data.widthScreen=640; data.heightScreen=360; data.zoomLevel=2; data.zoomLevelScreen=2;
        mConfig.gI().writeByte(18,(byte)2);
        // No cached metadata and an unavailable website must still allow the login form.
        CheckVersionScreen screen = new CheckVersionScreen(); data.currentScreen = screen;
        long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(8);
        while (!(data.currentScreen instanceof LoginPCScreen) && System.nanoTime() < deadline) {
            screen.b(); Thread.sleep(10);
        }
        check(data.currentScreen instanceof LoginPCScreen,"Cold iOS launch did not reach login");
        LoginPCScreen login = (LoginPCScreen)data.currentScreen;
        check(login.a != null && login.b != null,"Username/password widgets missing");
        check(data.ba && data.bb,"Metadata/UI readiness not published");
        check("img/zoom".equals(data.aY),"Web image prefix was not initialized");
        check(data.aP != null && data.aP.ip.equals("160.250.128.28"),"Offline server selection missing");
        int itemCount = data.ItemTemplate.length;
        // A damaged previous cache recovers from the packaged metadata without a web request.
        Binary.write("arr_data_game",new byte[]{1,2,3});
        data.readArrDataGame(false);
        check(data.ba && data.H.length > 0 && data.ItemTemplate.length == itemCount,"Corrupt metadata did not recover");
        check(Binary.read("arr_data_game").length > 1000,"Recovered metadata not cached");
        CheckVersionScreen warm = new CheckVersionScreen(); data.currentScreen = warm;
        deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(8);
        while (!(data.currentScreen instanceof LoginPCScreen) && System.nanoTime() < deadline) {
            warm.b(); Thread.sleep(10);
        }
        check(data.currentScreen instanceof LoginPCScreen,"Warm iOS launch did not reach login");
        for (int[] size : new int[][]{{568,320},{844,390},{1883,875},{1920,1080}}) {
            data.widthScreen = size[0] / 2; data.heightScreen = size[1] / 2;
            LoginPCScreen resized = new LoginPCScreen();
            LangLa_dz enter = null;
            for (Object widget : resized.cG) {
                if (widget instanceof LangLa_dz && ((LangLa_dz)widget).b == 1001) enter = (LangLa_dz)widget;
            }
            check(enter != null, "Login button missing");
            check(enter.cx >= 0 && enter.cx + enter.width <= resized.width, "Login button clipped horizontally");
            check(enter.cy >= 0 && enter.cy + enter.height <= resized.height - 24, "Login button clipped by screen/home indicator");
            check(resized.a.cy >= 0 && resized.b.cy + resized.b.height <= enter.cy, "Login fields overlap button");
        }
        System.out.println("PASS: login button fits 4 landscape screen sizes at zoom2, including screenshot aspect ratio and home-indicator margin");
        System.out.println("PASS: cold iOS loading screen reaches actual username/password form without web; corrupt cache recovers; metadata and UI ready");
    }
    private static void check(boolean value,String message) { if (!value) throw new AssertionError(message); }
    private static Object defaultValue(Class<?> type) {
        if (type == boolean.class) return false;
        if (type == int.class) return 0;
        if (type == long.class) return 0L;
        if (type == float.class) return 0f;
        if (type == double.class) return 0d;
        return null;
    }
}
