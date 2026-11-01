package beatdz;
import com.badlogic.gdx.utils.Disposable;
import com.listener.VoiceRecordCallback;

public class LangLa_dt implements Disposable {
   public static long b;
   public static String c = "";
   public boolean d;
   private static LangLa_dt h;
   VoiceRecordCallback e;

   public static boolean a() {
      return false;
   }

   public static LangLa_dt b() {
      if (h == null) {
         h = new LangLa_dt();
      }
      return h;
   }

   public void c() {
   }

   public void dispose() {
   }

   public static void a(boolean var0, String var1) {
   }

   public static void a(boolean var0) {
   }
}
