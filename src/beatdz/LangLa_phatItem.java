package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

/**
 * Màn hình nhập tên thành viên để nhận vật phẩm từ kho gia tộc.
 * Chỉ tộc trưởng (d==5) và tộc phó (d==4) mới thấy nút Phân Phát.
 * 
 * Protocol gửi server: CMD -90
 *   writeUTF(tênThànhViên)
 *   writeShort(indexItemInGetItems)
 */
public class LangLa_phatItem extends LangLa_fo {
   private mTextBox inputTen;  // ô nhập tên thành viên
   private int itemIndex;      // index vật phẩm trong getItems()

   public LangLa_phatItem(MainScreen screen, int idx) {
      this.itemIndex = idx;
      this.cF = 2;
      this.p = screen;
      this.r = false;
      this.a(230, 100);
      // mTextBox(x, y, width, defaultText, parent, type, maxLen)
      this.inputTen = new mTextBox(70, 45, 140, "", this, -11, 24);
      this.a(this.inputTen);
      this.a(Caption.aP, 100);  // nút Xác Nhận (OK)
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics g) {
      // Vẽ nền hộp thoại
      this.a(g, 0, 0, this.width, this.height, 80, 55, 56);
      // Tiêu đề
      mFont.b(mFont.d, g, Caption.is, this.width / 2, 10, 1, -1, -16777216);
      // Nhãn "Tên thành viên:"
      mFont.b(mFont.d, g, Caption.rG[3] + ":", 10, 35, 0, -1, -16777216);
   }

   public void b() {
   }

   public Vector c() {
      super.c();
      Vector v = new Vector();
      v.addElement(new LangLa_jz(0, 0, 0, this.width, this.height, this.q, this));
      return v;
   }

   public void a(LangLa_jz evt, int x, int y) {
      if (evt.b == 100) {
         try {
            String ten = this.inputTen.f().trim();  // f() trả về String nội dung nhập
            if (ten.length() == 0) {
               DataCenter.gI().currentScreen.showMessage("Vui lòng nhập tên thành viên!", -65536);
               return;
            }
            Message msg = Message.c((byte) -90);
            msg.writeUTF(ten);
            msg.writeShort(this.itemIndex);
            msg.send();
            this.R();  // Đóng hộp thoại
         } catch (Exception e) {
            DataCenter.gI().currentScreen.showMessage("Lỗi gửi lệnh!", -65536);
         }
      }
   }
}
