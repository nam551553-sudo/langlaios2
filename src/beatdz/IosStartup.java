package beatdz;

/** Required login data is bundled; optional web assets never gate the login screen. */
public final class IosStartup implements Runnable {
    public volatile boolean ready;
    public volatile String status = "Đang đọc dữ liệu đăng nhập...";
    public volatile Exception failure;

    public void run() {
        try {
            // Mode 1 hides characters/scenery; mode 2 also stops legacy image workers.
            mConfig.gI().writeByte(18, 0);
            DataCenter data = DataCenter.gI();
            data.aY = data.aZ = "img/zoom";
            data.readArrDataGame(false);
            if (data.ItemTemplate == null || data.H == null || data.F == null) {
                throw new IllegalStateException("Dữ liệu game chưa đầy đủ");
            }
            installDefaultServer();
            status = "Đang chuẩn bị giao diện đăng nhập...";
            mFont.a();
            LangLa_fq.a(false);
            DataCenter.at = true;
            ready = true;
        } catch (Exception error) {
            failure = error;
            status = "Không đọc được dữ liệu. Vui lòng thử lại.";
            Utlis.println(error);
        }
    }

    public static void installDefaultServer() {
        DataCenter data = DataCenter.gI();
        ArrayServer group = new ArrayServer();
        group.nameServers = AppBranding.NAME;
        Server server = new Server();
        server.array = group;
        server.name = AppBranding.NAME;
        server.id = 100;
        server.ip = NetworkConfig.host();
        server.port = 2907;
        server.portCheck = 2908;
        server.version1 = 81;
        server.version2 = 131;
        group.servers = new Server[]{server};
        data.arrayServers = new ArrayServer[]{group};
        data.setServer(server);
    }
}
