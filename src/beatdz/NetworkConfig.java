package beatdz;

/** Shared game server and resource hosting defaults. */
public final class NetworkConfig {
    private NetworkConfig() {}
    public static String host() { return System.getProperty("langla.host", "160.191.55.105"); }
    public static int port() { return Integer.getInteger("langla.port", 2907); }
    public static String website() { return "http://160.191.55.105/"; }
    public static String assets() {
        String url = System.getProperty("langla.assets", website());
        return url.endsWith("/") ? url : url + "/";
    }
    public static String serverList() {
        return "id = Làng Lá\r\n" + AppBranding.NAME + " = 100:" + host() + ":" + port() + ":2908";
    }
    public static String validServerList(String value) {
        if (value == null || !value.contains("id") || !value.contains("=")) return serverList();
        String normalized = value.replace("\uFEFF", "").replace("\r\n", "\n").replace('\r', '\n');
        // Keep the configured endpoint for the main server, including JVM overrides.
        String server = java.util.regex.Matcher.quoteReplacement(AppBranding.NAME + " = 100:" + host() + ":" + port());
        return normalized.replaceAll("(?im)^[^=\\n]+=[ \\t]*100:[^:\\n]+:[0-9]+(?=:)", server)
                .replace("\n", "\r\n");
    }
}
