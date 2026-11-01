package beatdz;

/** Network defaults matched to Desktop/langla/langla/Client (1). */
public final class NetworkConfig {
    private NetworkConfig() {}
    public static String host() { return System.getProperty("langla.host", "daichienshinibi.com"); }
    public static int port() { return Integer.getInteger("langla.port", 6868); }
    public static String website() { return "http://daichienshinibi.com/"; }
    public static String assets() {
        String url = System.getProperty("langla.assets", website());
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
