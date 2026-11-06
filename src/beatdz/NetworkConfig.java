package beatdz;

/** Shared game server and resource hosting defaults. */
public final class NetworkConfig {
    private NetworkConfig() {}
    public static String host() { return System.getProperty("langla.host", "127.0.0.1"); }
    public static int port() { return Integer.getInteger("langla.port", 2907); }
    public static String website() { return "http://127.0.0.1/"; }
    public static String assets() {
        String url = System.getProperty("langla.assets", website() + "langlaapp/");
        return url.endsWith("/") ? url : url + "/";
    }
    public static String serverList() {
        return "id = Làng Lá\r\nLocalHost = 100:" + host() + ":2907:2908";
    }
    public static String validServerList(String value) {
        if (value == null || !value.contains("id") || !value.contains("=")) return serverList();
        return value.replace("\uFEFF", "").replace("\r\n", "\n").replace('\r', '\n').replace("\n", "\r\n");
    }
}
