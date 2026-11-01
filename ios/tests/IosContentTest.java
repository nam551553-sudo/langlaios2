import beatdz.*;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import java.lang.reflect.Proxy;
import java.nio.file.*;
import java.io.*;
import java.util.*;

/** Exercises the actual -126 SQL costume protocol and iOS asset selection without a GL context. */
public class IosContentTest {
    public static void main(String[] args) throws Exception {
        Gdx.app = (Application)Proxy.newProxyInstance(Application.class.getClassLoader(),
                new Class[]{Application.class}, (proxy, method, values) ->
                        method.getName().equals("getType") ? Application.ApplicationType.iOS : null);
        Path sandbox = Files.createTempDirectory("kage-ios-test");
        Gdx.files = (com.badlogic.gdx.Files)Proxy.newProxyInstance(com.badlogic.gdx.Files.class.getClassLoader(),
                new Class[]{com.badlogic.gdx.Files.class}, (proxy, method, values) -> {
                    if (method.getName().equals("local") || method.getName().equals("internal")) {
                        return new com.badlogic.gdx.files.FileHandle(sandbox.resolve((String)values[0]).toFile());
                    }
                    return null;
                });
        // This protocol test does not run the asynchronous render/download workers.
        mConfig.gI().writeByte(18, (byte)2);
        TestCanvas canvas = new TestCanvas();
        for (int[] size : new int[][]{{568,320},{844,390},{1920,1080},{2732,2048}}) {
            canvas.width = size[0]; canvas.height = size[1]; canvas.setZoomLevel();
            check(DataCenter.gI().zoomLevel == 3 && DataCenter.gI().zoomLevelScreen == 3, "iOS zoom: " + Arrays.toString(size));
            for (String asset : new String[]{"iconChar", "iconClient", "iconTree", "mapmini.zip", "iconCharNew2.zip"}) {
                check(DataCenter.a(asset) + 1 == 3, "Wrong iOS resource zoom: " + asset);
            }
        }
        Map<Integer,List<int[]>> frames = new LinkedHashMap<>();
        List<String> rows = Files.readAllLines(Paths.get("tests/fixtures/new1-23-frames.csv"));
        for (String row : rows.subList(1, rows.size())) {
            int[] fields = Arrays.stream(row.split(",")).mapToInt(Integer::parseInt).toArray();
            frames.computeIfAbsent(fields[0], ignored -> new ArrayList<>()).add(fields);
        }
        check(frames.size() == 23, "Missing SQL appearances");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream packet = new DataOutputStream(bytes);
        packet.writeShort(frames.size());
        for (Map.Entry<Integer,List<int[]>> appearance : frames.entrySet()) {
            check(appearance.getValue().size() == 28, "Wrong SQL frame count");
            packet.writeShort(appearance.getKey()); packet.writeShort(28);
            for (int[] fields : appearance.getValue()) {
                for (int index : new int[]{2,3,4,5,6,7}) packet.writeShort(fields[index]);
            }
        }
        DataCenter data = DataCenter.gI();
        data.H = new LangLa_js[50]; data.G = new LangLa_jt[0]; data.F = new LangLa_jr[0];
        Controller controller = new Controller();
        controller.a(new Message((byte)-126, bytes.toByteArray()));
        for (Map.Entry<Integer,List<int[]>> appearance : frames.entrySet()) {
            int id = appearance.getKey();
            check(data.H[id] != null, "Appearance not installed: " + id);
            LangLa_jr part = data.F[data.G[data.H[id].a[0][0]].a[0]];
            check(part.b == 98 && part.d.length == 33, "Invalid native animation: " + id);
            for (int pose = 0; pose < 33; pose++) {
                int expected = appearance.getValue().get(TopupCostumes.sourceFrame(pose))[2];
                check(part.d[pose].a == (short)expected, "Wrong SQL image/pose for " + id);
            }
        }
        controller.a(new Message((byte)-126, bytes.toByteArray()));
        check(data.F.length == 23 && data.G.length == 23, "Repeated SQL packet duplicated parts");
        System.out.println("PASS: iOS zoom3 on 4 screen sizes, all asset families, 23 SQL costumes / 644 source frames / 33 engine poses, repeated packet");
    }
    private static void check(boolean value, String message) { if (!value) throw new AssertionError(message); }
    private static class TestCanvas extends Canvas {
        public void create() {}
        public void update() {}
        public void paint(Graphics graphics) {}
        public void a(int key) {}
        public void a(char key) {}
        public void b(int key) {}
        public void a(int x, int y) {}
        public void b(int x, int y) {}
        public void c(int x, int y) {}
    }
}
