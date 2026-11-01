package beatdz;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/** File decoding and HTTP transfers do not block the render loop or one another. */
public final class IosAssetQueue {
    private static final AtomicInteger IDS = new AtomicInteger();
    private static final ThreadFactory THREADS = task -> {
        Thread thread = new Thread(task, "ios-assets-" + IDS.incrementAndGet());
        thread.setDaemon(true);
        return thread;
    };
    private static final ExecutorService CACHE = Executors.newSingleThreadExecutor(THREADS);
    private static final ExecutorService DOWNLOADS = Executors.newFixedThreadPool(4, THREADS);
    private IosAssetQueue() {}

    public static void drain() {
        LangLa_fb request;
        while ((request = poll(LangLa_cz.cW)) != null) {
            final LangLa_fb next = request;
            CACHE.execute(() -> {
                LangLa_cz.a(next);
                drainDownloads();
            });
        }
        drainDownloads();
    }
    private static void drainDownloads() {
        LangLa_fb request;
        while ((request = poll(LangLa_cz.cX)) != null) {
            final LangLa_fb next = request;
            DOWNLOADS.execute(() -> LangLa_cz.b(next));
        }
    }
    private static LangLa_fb poll(Vector queue) {
        synchronized (queue) {
            return queue.isEmpty() ? null : (LangLa_fb)queue.remove(0);
        }
    }
}
