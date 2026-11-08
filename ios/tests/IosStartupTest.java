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
import java.util.Hashtable;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

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
        check(mConfig.gI().readByte(18) == 0,"iOS is hiding characters/scenery");
        check("img/zoom".equals(data.aY),"Web image prefix was not initialized");
        check(data.aP != null && data.aP.ip.equals("160.191.55.105") && data.aP.port == 2907,
                "Offline server selection has the wrong endpoint");
        String hostedList = "id = Làng Lá\nDAI CHIEN KAGE = 100:160.191.55.105:2473:2908";
        check(NetworkConfig.validServerList(hostedList).endsWith("100:160.191.55.105:2907:2908"),
                "Hosted list replaced the configured game port");
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
        verifyWorldImageQueue();
        verifyAutoCombat();
    }
    private static void verifyAutoCombat() throws Exception {
        GameSrc game = GameSrc.gI();
        DataCenter.gI().currentScreen = game;
        SettingsTab settings = SettingsTab.gI();
        check(settings.a != null, "Auto settings not ready");
        // Simulate an upgrade with distinct visible options and saved legacy slots.
        settings.a[100]=0; settings.a[101]=-1; settings.a[102]=0;
        settings.a[103]=0; settings.a[104]=0; settings.a[105]=-1; settings.a[106]=0; settings.z();
        settings.A(); settings.e();
        check(settings.a[103] == 0 && AutoPro.isAuto(3), "Saved speed setting was not restored");
        check(AutoPro.isAuto(4) && !AutoPro.isAuto(5) && AutoPro.isAuto(6), "Upgrade shifted saved options");
        Field field = SettingsTab.class.getDeclaredField("s"); field.setAccessible(true);
        LangLa_ce[] rows = ((LangLa_ce[][])field.get(settings))[3];
        check(rows.length == 3 && SettingsTab.arrayAuto.length == 3, "Unexpected auto option count");
        check(rows[0].a && !rows[1].a && rows[2].a, "Visible rows use wrong saved slots");
        rows[1].a=true; settings.a(2908,null,null);
        settings.A(); settings.e();
        check(AutoPro.isAuto(1) && rows[1].a, "Elite priority toggle was not saved");
        check(settings.a[103] == 0 && settings.a[104] == 0 && settings.a[105] == -1 && settings.a[106] == 0,
                "Visible toggle changed a legacy slot");
        short oldX=Char.gI().cx, oldY=Char.gI().cy;
        Char.gI().setXY(100,100); game.mapID=17;
        game.vMob.clear();
        Mob far=mob(1,300,100,0), near=mob(1,120,100,0), dead=mob(1,101,100,4), other=mob(2,102,100,0);
        game.vMob.add(far); game.vMob.add(near); game.vMob.add(dead); game.vMob.add(other);
        for(int tick=0;tick<1000;tick++) {
            check(GameSrc.findMobWithLevelBoss(1)==near,"Auto selected wrong elite target");
            check(GameSrc.findMobWithLevelBoss(2)==other,"Auto selected wrong boss target");
            check(GameSrc.findMobWithLevelBoss(9)==null,"Auto selected absent target");
        }
        settings.a(true);
        check(settings.autoTrain && settings.b==17 && SettingsTab.d==100 && SettingsTab.e==100,"Treo did not capture current position");
        settings.a(false); check(!settings.autoTrain && settings.b==-1,"Cannot stop treo");
        game.vMob.clear(); check(GameSrc.findMobWithLevelBoss(1)==null,"Empty map target lookup failed");
        Char.gI().setXY(oldX,oldY);
        System.out.println("PASS: treo start/stop, 3000 target lookups, visible auto options and legacy slots preserved");
    }
    private static Mob mob(int level,int x,int y,int status) {
        Mob mob = new Mob() { @Override public boolean q() { return false; } };
        mob.levelBoss=(byte)level; mob.status=(byte)status; mob.setXY(x,y); return mob;
    }
    private static void verifyWorldImageQueue() throws Exception {
        HttpServer web = HttpServer.create(new InetSocketAddress("127.0.0.1",0),0);
        ExecutorService handlers = Executors.newCachedThreadPool(task -> {
            Thread thread = new Thread(task,"asset-test-http"); thread.setDaemon(true); return thread;
        });
        web.setExecutor(handlers);
        CountDownLatch slowStarted = new CountDownLatch(1);
        Set<String> paths = ConcurrentHashMap.newKeySet();
        AtomicInteger charRequests = new AtomicInteger();
        byte[] png = Files.readAllBytes(Paths.get("../resource/6.png"));
        web.createContext("/", exchange -> {
            String path = exchange.getRequestURI().getPath(); paths.add(path);
            if (path.contains("iconChar")) charRequests.incrementAndGet();
            if (path.contains("iconTree")) {
                slowStarted.countDown();
                try { Thread.sleep(4000); } catch (InterruptedException ignored) { Thread.currentThread().interrupt(); }
            }
            exchange.sendResponseHeaders(200,png.length);
            exchange.getResponseBody().write(png); exchange.close();
        });
        web.start();
        try {
            DataCenter data=DataCenter.gI();
            data.aU="http://127.0.0.1:"+web.getAddress().getPort()+"/";
            data.currentScreen=GameSrc.gI(); Utlis.timeOut=4000;
            LangLa_fb tree=request((short)32063,"iconTree/32063.png","tree_32063");
            LangLa_cz.cW.add(tree); LangLa_cz.S();
            check(slowStarted.await(3,TimeUnit.SECONDS),"Scenery request did not reach HTTP worker");
            // A metadata refresh must not discard the independent iOS image request.
            data.ba=false;
            Binary.write("char_icon_32061",new byte[]{1,2,3});
            LangLa_fq.requestIconChar(32061); LangLa_fq.a(32062);
            LangLa_fb map=request((short)32064,"map/32064.png","mapsmall_32064");
            LangLa_cz.cW.add(map); LangLa_cz.S();
            long deadline=System.nanoTime()+TimeUnit.MILLISECONDS.toNanos(2500);
            while ((!ready(LangLa_fq.g,(short)32061) || !ready(LangLa_fq.e,(short)32062) || !ready(map.g,(short)32064)) && System.nanoTime()<deadline) Thread.sleep(10);
            check(ready(LangLa_fq.g,(short)32061),"Character images blocked by scenery/metadata");
            check(ready(LangLa_fq.e,(short)32062),"Item icons blocked by scenery/metadata");
            check(ready(map.g,(short)32064),"Map images did not decode");
            check(((mImage)LangLa_fq.g.get((short)32061)).b()!=null,"Character texture unavailable on render thread");
            data.ba=true;
            int requests=charRequests.get(); LangLa_fq.g.remove((short)32061);
            LangLa_fq.requestIconChar(32061);
            deadline=System.nanoTime()+TimeUnit.SECONDS.toNanos(2);
            while (!ready(LangLa_fq.g,(short)32061) && System.nanoTime()<deadline) Thread.sleep(10);
            check(ready(LangLa_fq.g,(short)32061) && charRequests.get()==requests,"Valid image cache was not reused");
            check(paths.contains("/img/zoom2/iconChar/32061.png") && paths.contains("/img/zoom2/iconClient/32062.png") && paths.contains("/img/zoom2/map/32064.png"),"Wrong world image URLs");
            deadline=System.nanoTime()+TimeUnit.SECONDS.toNanos(6);
            while (!ready(tree.g,(short)32063) && System.nanoTime()<deadline) Thread.sleep(10);
            check(ready(tree.g,(short)32063),"Scenery image did not complete");
            System.out.println("PASS: actual iOS queue downloads/decodes character, item, scenery and map images; slow scenery does not block other images; corrupt cache repaired and valid cache reused");
        } finally { web.stop(0); handlers.shutdownNow(); }
    }
    private static LangLa_fb request(short id,String path,String key) {
        LangLa_fb request=new LangLa_fb(); request.a=id; request.d=path; request.e=key; request.g=new Hashtable(); return request;
    }
    private static boolean ready(Hashtable images,short id) {
        mImage image=(mImage)images.get(id); return image!=null && image.c>1 && image.d>1;
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
