package beatdz;import com.listener.IKeyboard;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_kl extends LangLa_ge implements IKeyboard {
   public int I;
   public int J;
   public static void log(String var0) {
   }

   public int a;
   public LangLa_ij[][] K;
   public LangLa_ii[][] L;
   public LangLa_ii[] M;
   public LangLa_ii[] N;
   public LangLa_gx b;
   public LangLa_gx gx_detu;
   public LangLa_lf P_detu;
   private LangLa_gx O;
   private LangLa_lf[] P;
   public mTextBox[] c;
   public mTextBox[] c_detu;
   private LangLa_dz Q_detu;
   private LangLa_dz R_detu;
   private LangLa_dz X_detu;
   private LangLa_dz Y_detu;
   public boolean d;
   public int e;
   public int f;
   public int g;
   public int h;
   public int i;
   public int u;
   public int v;
   public int[] w;
   public int[] x;
   private LangLa_dz Q;
   private LangLa_dz R;
   private LangLa_dz S;
   private LangLa_dz T;
   private LangLa_dz U;
   private LangLa_dz[] V;
   private LangLa_lk[] W;
   public Char y;
   public Skill[] z;
   private LangLa_dz X;
   private LangLa_dz Y;
   private LangLa_dz Z;
   private LangLa_dz aa;
   private LangLa_dz ab;
   private LangLa_cg ac;
   public LangLa_cg A;
   public LangLa_ce B;
   private static LangLa_kl ad;
   public Item C;
   private LangLa_ij ae;
   private boolean af;
   public String[] D;
   public int E;
   public int F;
   Vector G;
   public SkillClan H;
   public int a_detu = -1;

   public void e() {
      if (this.b == null) {
         return;
      }

      int var2 = this.a_() + 11;
      this.K = new LangLa_ij[Caption.rb.length + Caption.rb_d_sub.length][];
      int offset = this.b.c();
      int startX = offset + 10;
      this.K[0] = new LangLa_ij[12];
      // Cá»™t chÃ­nh ngoÃ i cÃ¹ng (startX vÃ  startX + 160)
      this.K[0][0] = new LangLa_ij((byte)1, startX, var2, this.I, this.I * 5, this.I, 5, 1);
      this.K[0][1] = new LangLa_ij((byte)1, startX + 160, var2, this.I, this.I * 5, this.I, 5, 1);
      
      // HÃ ng 5 (DÆ°á»›i cÃ¹ng)
      this.K[0][2] = new LangLa_ij((byte)1, startX + 32, var2 + this.I * 4, this.I, this.I, this.I, 1, 1);  // ThÃº nuÃ´i
      this.K[0][8] = new LangLa_ij((byte)1, startX + 64, var2 + this.I * 4, this.I, this.I, this.I, 1, 1);  // Ão choÃ ng
      this.K[0][9] = new LangLa_ij((byte)1, startX + 96, var2 + this.I * 4, this.I, this.I, this.I, 1, 1);  // BÃ­ kÃ­p
      this.K[0][11] = new LangLa_ij((byte)1, startX + 128, var2 + this.I * 4, this.I, this.I, this.I, 1, 1); // BÃ¹a ná»•

      // CÃ¡c Ã´ xáº¿p chá»“ng phÃ­a trÃªn
      this.K[0][3] = new LangLa_ij((byte)1, startX + 32, var2 + this.I * 3, this.I, this.I, this.I, 1, 1);  // Cáº£i trang (trÃªn ThÃº nuÃ´i)
      this.K[0][4] = new LangLa_ij((byte)1, startX + 128, var2 + this.I * 3, this.I, this.I, this.I, 1, 1); // Tanto (trÃªn BÃ¹a ná»•)
      this.K[0][5] = new LangLa_ij((byte)1, startX + 128, var2 + this.I * 2, this.I, this.I, this.I, 1, 1); // Thá» i trang (trÃªn Tanto)
      this.K[0][7] = new LangLa_ij((byte)1, startX + 128, var2 + this.I * 1, this.I, this.I, this.I, 1, 1); // Máº¯t (trÃªn Thá» i trang)
      
      this.K[1] = new LangLa_ij[12];
      System.arraycopy(this.K[0], 0, this.K[1], 0, 12);
      this.L = new LangLa_ii[Caption.rb.length + Caption.rb_d_sub.length][];
      this.L[0] = new LangLa_ii[1];
      int var1 = this.b.c() + 40;
      this.L[0][0] = new LangLa_ii((byte)1, var1, var2, 128, 78, 13, Caption.rT.length);
      this.L[1] = new LangLa_ii[1];
      this.L[1][0] = new LangLa_ii((byte)1, this.b.c() + 40, this.a_() + 11, 128, 91, 13, Caption.rT.length);
      this.L[2] = new LangLa_ii[4];
      var1 = this.b.c() + 5;
      var2 = this.a_() + 34;
      this.L[2][0] = new LangLa_ii((byte)1, var1, var2 + 108, 40, 12, 24, 4);
      this.L[2][1] = new LangLa_ii((byte)1, var1, var2, super.width - 8 - 96, 120, 15, Caption.rd.length);
      this.L[2][2] = new LangLa_ii((byte)1, var1, var2, super.width - 8 - 96, 120, 15, this.x.length);
      this.L[2][3] = new LangLa_ii((byte)1, var1, var2, super.width - 8 - 96, 120, 15, Caption.rf.length);
      this.L[3] = new LangLa_ii[1];
      this.J = 26;
      var1 = this.b.c() + 8;
      int var10000 = this.b.cy + 7 + 6;
      DataCenter.gI();
      var2 = var10000 + 0;
      int var111 = 0;
      if (this.z != null) var111 = this.z.length;
      this.L[3][0] = new LangLa_ii((byte)1, var1, var2, 190, this.J * 5 + 1, this.J, var111);
      this.L[4] = new LangLa_ii[2];
      var1 = this.b.c() + 5;
      var2 = this.a_() + 34;
      this.L[4][0] = new LangLa_ii((byte)1, var1, var2, super.width - 8 - 96, 119, 17, this.y.aG.length * 2);
      this.L[4][1] = new LangLa_ii((byte)1, var1, var2, super.width - 8 - 96, 75, 15, 6);
      this.K[4] = new LangLa_ij[2];
      var1 = this.b.c() + 8;
      var2 = this.a_() + 11 + this.I * 4;
      this.K[4][0] = new LangLa_ij((byte)1, var1, var2, this.I * 6, this.I, this.I, 1, 6);
      this.K[4][1] = new LangLa_ij((byte)1, var1, var2 - this.I, this.I, this.I, this.I, 1, 1);

      // KHá»žI Táº O LAYOUT CHO Ä á»† Tá»¬
      // Index 5: NhÃ¢n váº­t Ä á»‡ tá»­ (NhÃ¢n váº­t)
      this.K[5] = new LangLa_ij[12];
      System.arraycopy(this.K[0], 0, this.K[5], 0, 12);
      this.L[5] = new LangLa_ii[1];
      this.L[5][0] = new LangLa_ii((byte)1, this.b.c() + 40, this.a_() + 11, 128, 78, 13, Caption.rT.length);

      // Index 6: Tiá» m nÄƒng Ä á»‡ tá»­ (Tiá» m nÄƒng)
      this.L[6] = new LangLa_ii[4];
      var1 = this.b.c() + 5;
      var2 = this.a_() + 34;
      this.L[6][0] = new LangLa_ii((byte)1, var1, var2 + 108, 40, 12, 24, 4);
      this.L[6][1] = new LangLa_ii((byte)1, var1, var2, super.width - 8 - 96, 120, 15, Caption.rd.length);
      this.L[6][2] = new LangLa_ii((byte)1, var1, var2, super.width - 8 - 96, 120, 15, this.x.length);
      this.L[6][3] = new LangLa_ii((byte)1, var1, var2, super.width - 8 - 96, 120, 15, Caption.rf.length);

      if (this.gx_detu != null) this.gx_detu.d();
      if (this.P_detu != null) this.P_detu.a();

      this.c_detu = new mTextBox[4];
      Vector var10_detu = new Vector();
      int base_y_d = this.a_() + 38;
      int base_x_d = this.b.c() + 62;
      this.c_detu[0] = this.a(base_x_d, base_y_d, 72, "" + this.y.arrayTiemNang_d[0], this, 2);
      this.c_detu[0].n = this.y.arrayTiemNang_d[0];
      var10_detu.addElement(this.c_detu[0]);
      var10_detu.addElement(this.a(this.b.c() + 145 - 5, base_y_d + 3, "", this, 5001, 58));
      var10_detu.addElement(this.a(this.b.c() + 145 + 15, base_y_d + 3, "", this, 5002, 57));
      var10_detu.addElement(this.a(this.b.c() + 145 + 35, base_y_d + 3, "", this, 5012, 244));
      
      this.c_detu[1] = this.a(base_x_d, base_y_d + 25, 72, "" + this.y.arrayTiemNang_d[1], this, 2);
      this.c_detu[1].n = this.y.arrayTiemNang_d[1];
      var10_detu.addElement(this.c_detu[1]);
      var10_detu.addElement(this.a(this.b.c() + 145 - 5, base_y_d + 25 + 3, "", this, 5003, 58));
      var10_detu.addElement(this.a(this.b.c() + 145 + 15, base_y_d + 25 + 3, "", this, 5004, 57));
      var10_detu.addElement(this.a(this.b.c() + 145 + 35, base_y_d + 25 + 3, "", this, 5014, 244));
      
      this.c_detu[2] = this.a(base_x_d, base_y_d + 50, 72, "" + this.y.arrayTiemNang_d[2], this, 2);
      this.c_detu[2].n = this.y.arrayTiemNang_d[2];
      var10_detu.addElement(this.c_detu[2]);
      var10_detu.addElement(this.a(this.b.c() + 145 - 5, base_y_d + 50 + 3, "", this, 5005, 58));
      var10_detu.addElement(this.a(this.b.c() + 145 + 15, base_y_d + 50 + 3, "", this, 5006, 57));
      var10_detu.addElement(this.a(this.b.c() + 145 + 35, base_y_d + 50 + 3, "", this, 5016, 244));
      
      this.c_detu[3] = this.a(base_x_d, base_y_d + 75, 72, "" + this.y.arrayTiemNang_d[3], this, 2);
      this.c_detu[3].n = this.y.arrayTiemNang_d[3];
      var10_detu.addElement(this.c_detu[3]);
      var10_detu.addElement(this.a(this.b.c() + 145 - 5, base_y_d + 75 + 3, "", this, 5007, 58));
      var10_detu.addElement(this.a(this.b.c() + 145 + 15, base_y_d + 75 + 3, "", this, 5008, 57));
      var10_detu.addElement(this.a(this.b.c() + 145 + 35, base_y_d + 75 + 3, "", this, 5018, 244));
      
      this.R_detu = this.a(super.width - 8 - 45, this.height - 33, Caption.cP, this, 5010, 7);
      this.R_detu.setSize(40, 20);
      var10_detu.addElement(this.R_detu);
      this.Q_detu = this.a(this.R_detu.cx - 43, this.height - 33, Caption.cQ, this, 5009, 7);
      this.Q_detu.setSize(40, 20);
      var10_detu.addElement(this.Q_detu);
      
      this.gx_detu.a(var10_detu, 1);
      this.P_detu.a(var10_detu, 0);
      if (this.b.b.b != 2 || this.gx_detu.b.b != 1) {
         this.gx_detu.d();
         this.P_detu.a();
      }

      var10_detu = new Vector();
      int var7_d = super.width - 8 - 45;
      int var9_d = this.height - 33;
      this.Y_detu = this.a(var7_d, var9_d, Caption.cP, this, 5021, 7);
      this.Y_detu.setSize(40, 20);
      var10_detu.addElement(this.Y_detu);
      this.X_detu = this.a(this.Y_detu.cx - 43, var9_d, Caption.bk, this, 5020, 7);
      this.X_detu.setSize(40, 20);
      var10_detu.addElement(this.X_detu);
      this.gx_detu.a(var10_detu, 2);
      if (this.b.b.b != 2 || this.gx_detu.b.b != 2) {
         this.gx_detu.d();
      }

      // Index 7: ChiÃªu thá»©c Äá»‡ tá»­ (ChiÃªu thá»©c)
      this.L[7] = new LangLa_ii[1];
      var1 = this.gx_detu.c() + 8;
      var2 = this.gx_detu.cy + 7 + 6;
      this.L[7][0] = new LangLa_ii((byte)1, var1, var2, 190, 131, 26, 0); // Äá»‡ tá»­ chÆ°a cÃ³ skill nÃªn length = 0

      this.g();
   }

   public int j() {
      return 1;
   }

   public void g() {
      this.G = new Vector();

      for(int var2 = 0; var2 < this.y.aH.size(); ++var2) {
         SkillClan var1;
         if ((var1 = (SkillClan)this.y.aH.elementAt(var2)).id == 19) {
            this.H = var1;
         } else {
            this.G.add(var1);
         }
      }

   }

   public LangLa_kl(MainScreen var1, Char var2, Skill[] var3) {
      super(var1, new String[]{Caption.W, Caption.q});
      this.I = 32;
      this.J = 15;
      this.w = new int[17];
      this.x = new int[18];
      this.F = -1;

      try {
         ad = this;
         this.p = var1;
         this.y = var2;
         this.z = var3;
         this.r = false;
         this.a(CHARACTER_PANEL_WIDTH, 212);
         LangLa_kd var6 = new LangLa_kd(1001);
         DataCenter.gI();
         var6.c = Caption.rb;
         int var10000 = this.a_() - 3;
         DataCenter.gI();
         int var9 = var10000 - 0;
         this.b = new LangLa_gx(var6, this.width, 1, var9, 90, this.G() + 6, 33, this);
         LangLa_kd var_detu = new LangLa_kd(1002);
         var_detu.c = Caption.rb_d_sub;
         this.gx_detu = new LangLa_gx(var_detu, this.width, 1, var9, 80, this.G() + 6, 33, this);
         this.P_detu = new LangLa_lf(new LangLa_kd(2020, Caption.sh), this.b.c() + 5, this.a_() + 7, 196, 23, 64, this, false);
         this.e();
         var10000 = super.width - 8 - 162;
         DataCenter.gI();
         int var7 = var10000 + 0;
         var10000 = this.a_() + this.G() - 134;
         DataCenter.gI();
         var9 = var10000 + 0;
         this.V = new LangLa_dz[4];

/*         for(int var4 = 0; var4 < this.V.length; ++var4) {
            this.V[var4] = new LangLa_dz(var7, var9 + 20 * var4 - 20, 0, 0, Caption.tI[var4], this, 1100 + var4, -27);
            this.V[var4].setSize(30, 18);
            this.b.a((LangLa_cs)this.V[var4], 1);
         }*/

         Vector var10 = new Vector();
         var10000 = super.width - 8 - 45;
         DataCenter.gI();
         var7 = var10000 + 0;
         var10000 = this.height - 33;
         DataCenter.gI();
         var9 = var10000 + 0;
         LangLa_dz var8;
         (var8 = this.a(var7, var9, Caption.cP, this, 2010, 7)).setSize(40, 20);
         this.Q = var8;
         var10.addElement(this.Q);
         (var8 = this.a(this.Q.cx - 43, this.Q.cy, Caption.cQ, this, 2009, 7)).setSize(40, 20);
         var10.addElement(var8);
         this.R = var8;
         var10.addElement(this.R);
         var10000 = this.b.c() + 62;
         DataCenter.gI();
         var7 = var10000 + 0;
         var10000 = this.a_() + this.G() - 41;
         DataCenter.gI();
         var9 = var10000 + 0;
         this.B = this.a(var7, var9, Caption.cR, 1234);
         var10.addElement(this.B);
         this.P = new LangLa_lf[2];
         var10000 = this.b.c() + 5;
         DataCenter.gI();
         var7 = var10000 + 0;
         var10000 = this.a_() + 7;
         DataCenter.gI();
         var9 = var10000 + 0;
         this.P[0] = new LangLa_lf(new LangLa_kd(2000, Caption.sh), var7, var9, 196, 23, 64, this, false);
         this.P[1] = new LangLa_lf(new LangLa_kd(2011, Caption.sD), var7, var9, 196, 23, 64, this, false);
         this.c = new mTextBox[4];
         DataCenter.gI();
         DataCenter.gI();
         this.c[0] = this.a(this.b.c() + 62 + 0, this.a_() + 38, 72, "", this, 2);
         var10.addElement(this.c[0]);
         var8 = this.Z = this.a(this.b.c() + 145 - 5 + 0, this.a_() + 38 + 3, "", this, 2001, 58);
         var10.addElement(var8);
         var8 = this.aa = this.a(this.b.c() + 145 + 15 + 0, this.a_() + 38 + 3, "", this, 2002, 57);
         var10.addElement(var8);
         var8 = this.ab = this.a(this.b.c() + 145 + 35 + 0, this.a_() + 38 + 3, "", this, 2012, 244);
         var10.addElement(var8);
         this.c[1] = this.a(this.b.c() + 62 + 0, this.a_() + 38 + 25, 72, "", this, 2);
         var10.addElement(this.c[1]);
         var8 = this.a(this.b.c() + 145 - 5 + 0, this.a_() + 38 + 25 + 3, "", this, 2003, 58);
         var10.addElement(var8);
         var8 = this.a(this.b.c() + 145 + 15 + 0, this.a_() + 38 + 25 + 3, "", this, 2004, 57);
         var10.addElement(var8);
         var8 = this.a(this.b.c() + 145 + 35 + 0, this.a_() + 38 + 25 + 3, "", this, 2014, 244);
         var10.addElement(var8);
         this.c[2] = this.a(this.b.c() + 62 + 0, this.a_() + 38 + 50, 72, "", this, 2);
         var10.addElement(this.c[2]);
         var8 = this.a(this.b.c() + 145 - 5 + 0, this.a_() + 38 + 50 + 3, "", this, 2005, 58);
         var10.addElement(var8);
         var8 = this.a(this.b.c() + 145 + 15 + 0, this.a_() + 38 + 50 + 3, "", this, 2006, 57);
         var10.addElement(var8);
         var8 = this.a(this.b.c() + 145 + 35 + 0, this.a_() + 38 + 50 + 3, "", this, 2016, 244);
         var10.addElement(var8);
         this.c[3] = this.a(this.b.c() + 62 + 0, this.a_() + 38 + 75, 72, "", this, 2);
         var10.addElement(this.c[3]);
         var8 = this.a(this.b.c() + 145 - 5 + 0, this.a_() + 38 + 75 + 3, "", this, 2007, 58);
         var10.addElement(var8);
         var8 = this.a(this.b.c() + 145 + 15 + 0, this.a_() + 38 + 75 + 3, "", this, 2008, 57);
         var10.addElement(var8);
         var8 = this.a(this.b.c() + 145 + 35 + 0, this.a_() + 38 + 75 + 3, "", this, 2018, 244);
         var10.addElement(var8);
         this.P[0].a((Vector)var10, 0);
         this.P[0].a();
         var10 = new Vector();
         var10000 = super.width - 8 - 45;
         DataCenter.gI();
         var7 = var10000 + 0;
         var10000 = this.height - 33;
         DataCenter.gI();
         var9 = var10000 + 0;
         this.Y = this.a(var7, var9, Caption.cP, this, 3001, 7);
         this.Y.setSize(40, 20);
         var10.addElement(this.Y);
         this.X = this.a(this.Y.cx - 43, var9, Caption.bk, this, 3000, 7);
         this.X.setSize(40, 20);
         var10.addElement(this.X);
         this.b.a((Vector)var10, 3);
         LangLa_kd var11;
         (var11 = new LangLa_kd(1235)).c = Caption.tJ;
         var10000 = this.b.c() + 71;
         DataCenter.gI();
         var7 = var10000 + 0;
         var10000 = this.a_() + this.G() - 61;
         DataCenter.gI();
         var9 = var10000 + 0;
         this.A = this.a(var7, var9, 64, 4, var11, this, 1);
         this.A.a(var2.selectCaiTrang);
         this.b.a((LangLa_cs)this.A, 0);
         (var8 = this.a(super.width - 8 - 55, this.height - 68, Caption.bj, this, 4001, 7)).setSize(50, 20);
         this.S = var8;
         this.b.a((LangLa_cs)this.S, 4);
         (var8 = this.a(super.width - 8 - 110, this.height - 68, Caption.qi, this, 4002, 7)).setSize(50, 20);
         this.T = var8;
         this.b.a((LangLa_cs)this.T, 4);
         (var8 = this.a(super.width - 8 - 165, this.height - 68, Caption.lQ, this, 4003, 7)).setSize(50, 20);
         this.U = var8;
         this.b.a((LangLa_cs)this.U, 4);
         this.b.a(!this.v());
         this.P[0].a(!this.v());
         this.b.a(0);
         this.b(0);
         if (var2.isMe()) {
            this.a(GameSrc.gI().aw);
         } else {
            this.a(0);
         }
      } catch (Exception var5) {
         Utlis.println(var5);
      }

      if (this.v()) {
         this.i = GameSrc.gI().diemTiemNang;
         this.v = GameSrc.gI().diemKyNang;
      }

   }
   public static LangLa_kl l() {
      return ad;
   }

   private boolean t() {
      return this.y.idClass == 0 || this.y.idClass == 1 || this.y.idClass == 5;
   }

   public int m() {
      return this.k();
   }

   public int n() {
      if (this.k() == 2 && this.gx_detu != null) {
         return this.gx_detu.b.b;
      }
      return this.b.b.b;
   }

   private void a(LangLa_ii var1, int var2) {
      this.af = false;

      for(int var3 = 0; var3 < this.K.length; ++var3) {
         if (this.K[var3] != null) {
            for(int var4 = 0; var4 < this.K[var3].length; ++var4) {
               if (this.K[var3][var4] != null) {
                  this.K[var3][var4].k = -1;
               }
            }
         }
      }

      var1.k = var2;
      if (this.P_detu != null && var1.equals(this.P_detu.a)) {
         log("CLICK_HANDLER: P_detu Scroll Hit, Index: " + var2);
         this.P_detu.a(var2);
      }

      }

public void d() {
      super.d();
      GameSrc.gI().aw = this.k();
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      beatdz.Utlis.writeLog("=== LangLa_kl EVENT CLICK: id=" + var1.b + " cx=" + var2 + " cy=" + var3 + " d=" + this.d + " ===");
      boolean var13 = false;

      label826: {
         label827: {
            label828: {
               label829: {
                  label851: {
                     label852: {
                        label853: {
                           try {
                              var13 = true;
                              LangLa_kl var4;
                              Message var5;
                              if (!this.d) {
                                 var4 = this;

                                 try {
                                    (var5 = new Message((byte)63)).writeUTF(var4.y.name);
                                    var5.send();
                                 } catch (Exception var16) {
                                    Utlis.println(var16);
                                 }
                              }

                              super.a(var1, var2, var3);
                              Message var22;
                              label810:
                              switch(var1.b) {
                              case 200:
                                 var4 = this;

                                 try {
                                    (var5 = new Message((byte)-24)).writeByte(var4.ac.b.b);
                                    var5.send();
                                    var13 = false;
                                 } catch (Exception var15) {
                                    Utlis.println(var15);
                                    var13 = false;
                                 }
                                 break;
                              case 1001:
                                 if (var1.j.k >= 0) {
                                    this.b.a(var1.j.k);
                                    switch(this.b.b.b) {
                                    case 0:
                                    case 1:
                                       if (this.P != null && this.P[0] != null) {
                                          this.P[0].a();
                                       }
                                       this.e(this.b.b.b);
                                       var13 = false;
                                       break label810;
                                    case 2:
                                       DataCenter.gI();
                                       this.P[0].a(this.P[0].b.b);
 
                                       var13 = false;
                                       break label810;
                                    case 3:
                                    default:
                                       if (this.P != null && this.P[0] != null) this.P[0].a();
                                       var13 = false;
                                       break label810;
                                    case 4:
                                       if (this.P != null && this.P[0] != null) this.P[0].a();
                                       DataCenter.gI();
                                       this.P[1].a(this.P[1].b.b);
                                       var13 = false;
                                    }
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 1002:
                                 if (var1.j.k >= 0) {
                                    // Clean P_detu components before switching outer detu tab
                                    if (this.P_detu != null) {
                                       this.P_detu.a();
                                    }
                                    this.gx_detu.a(var1.j.k);

                                    
                                    if (this.gx_detu.b.b == 1 && this.P_detu != null) {
                                        this.P_detu.a(this.P_detu.b.b);
                                     }
                                     var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 1030:
                                 if (var1.j.k < 0) {
                                    var13 = false;
                                 } else {
                                    this.a = var1.j.k;
                                    if (var1.j.k < this.z.length) {
                                       if (var2 - var1.j.cx >= 56) {
                                          var13 = false;
                                          break;
                                       }

                                       String var24 = this.b(var1.j.k);
                                       this.w();
                                       boolean var25 = this.X.u;
                                       boolean var28 = this.Y.u;
                                       if (this.y.idClass == 0 || !this.v()) {
                                          var28 = true;
                                          var25 = true;
                                       }

                                       String var10001 = var24;
                                       int var10003 = var1.j.cx + 27;
                                       int var10004 = var1.j.cy + var1.j.k * var1.j.h - var1.j.f + 1;
                                       boolean var7 = this.y.isMe();
                                       boolean var6 = var28;
                                       boolean var20 = true;
                                       var2 = var10004;
                                       int var21 = var10003;
                                       String var30 = var10001;
                                       LangLa_ie var27;
                                       if ((var27 = new LangLa_ie(var21, var2, 220, this, var30, var25, var6, var7)).cx > DataCenter.gI().widthScreen - var27.width - super.cx) {
                                          var27.cx = (short)(DataCenter.gI().widthScreen - var27.width - super.cx);
                                       }

                                       if (var27.cx < var21) {
                                          var27.cx = (short)(var21 - (var27.width + 3));
                                       }

                                       if (var27.cx < -super.cx) {
                                          var27.cx = (short)(-super.cx);
                                       }

                                       if (var27.cy > DataCenter.gI().heightScreen - var27.height - super.cy) {
                                          var27.cy = (short)(DataCenter.gI().heightScreen - var27.height - super.cy);
                                       }

                                       this.a(var27);
                                       this.cL = var27;
                                       var13 = false;
                                       break;
                                    }

                                    var13 = false;
                                 }
                                 break;
                              case 1206:
                                 {
                                    log("[CASE1206] Triggered! j.k=" + var1.j.k + " skills_d=" + (this.y.skills_d != null ? this.y.skills_d.length : "null"));
                                    int selectedIndex = var1.j.k;
                                    if (selectedIndex >= 0 && this.y.skills_d != null && selectedIndex < this.y.skills_d.length) {
                                       this.a = selectedIndex;
                                       this.a_detu = selectedIndex;
                                       this.y_detu(); // Cáº­p nháº­t tráº¡ng thÃ¡i nÃºt Chá»n/Cá»™ng
                                       this.openDiscipleSkillDetail(); // Má»Ÿ popup ngay vá»›i dá»¯ liá»‡u local
                                    } else {
                                       log("[CASE1206] Skipped â€” index invalid or skills_d null");
                                    }
                                    var13 = false;
                                 }
                                 break;

                              case 1040:
                              case 1041:
                              case 1042:
                                 this.a(var1.j, var1.j.k);
                                 this.cL = a(var1, this, (Item)null);
                                 var13 = false;
                                 break;
                              case 1100:
                                 g(0);
                                 var13 = false;
                                 break;
                              case 1101:
                                 g(1);
                                 var13 = false;
                                 break;
                              case 1102:
                                 g(2);
                                 var13 = false;
                                 break;
                              case 1103:
                                 g(3);
                                 var13 = false;
                                 break;
                              case 1200:
                                 DataCenter.gI();
                                 if (this.P[0].b.b == 0) {
                                    if (var1.j.k >= 0) {
                                       LangLa_jz var29 = var1;
                                       String var19;
                                       if (this.t()) {
                                          var19 = Caption.rM[0];
                                       } else {
                                          var19 = Caption.rM[1];
                                       }

                                       this.w();
                                       this.cL = a(var19, this, var29.j.cx + 40, var29.j.cy, 205);
                                       var13 = false;
                                    } else {
                                       var13 = false;
                                    }
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 1201:
                                 if (var1.j.k >= 0) {
                                    if (var1.j.k % 2 == 0) {
                                       (var22 = Message.c((byte)-74)).writeByte(var1.j.k / 2 - 1);
                                       var22.send();
                                       var13 = false;
                                    } else {
                                       var13 = false;
                                    }
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 1401:
                                 this.E = 0;
                                 this.D = null;
                                 if (var1.j.k >= 0 && var1.j.k < this.G.size()) {
                                    this.F = var1.j.k;
                                    this.o();
                                 } else {
                                    this.F = -1;
                                 }
                                 this.w();
                                 var13 = false;
                                 break;
                              case 1403:
                                 this.E = 1;
                                 this.D = null;
                                 if (var1.j.k >= 0 && this.H != null) {
                                    this.F = var1.j.k;
                                    this.o();
                                 } else {
                                    this.F = -1;
                                 }
                                 this.w();
                                 var13 = false;
                                 break;
                              case 2020:
                                     log("EVENT: Click 2020 (Detu Tabs), Index: " + var1.j.k);
                                     if (var1.j.k >= 0 && this.P_detu != null) {
                                        this.P_detu.a(var1.j.k);
                                     }

                                     var13 = false;
                                     break;
                                  case 2000:
                                     log("EVENT: Click 2000 (Main Tabs), Index: " + var1.j.k);
                                     if (var1.j.k >= 0 && this.P[0] != null) {
                                        this.P[0].a(var1.j.k);
                                     }
                                     this.A();
                                     var13 = false;
                                     break;
                              case 5001: // Tiá»m nÄƒng Äá»‡ tá»­: giáº£m stat
                              case 5003:
                              case 5005:
                              case 5007:
                                 int idxMinus = (var1.b - 5001) / 2;
                                 if (this.c_detu != null && this.c_detu[idxMinus].e() - 1 >= this.c_detu[idxMinus].n) {
                                    this.c_detu[idxMinus].a(this.c_detu[idxMinus].e() - 1);
                                    ++this.y.diemTiemNang_d;
                                 }
                                 var13 = false;
                                 break;
                              case 5002: // Tiá»m nÄƒng Äá»‡ tá»­: tÄƒng stat
                              case 5004:
                              case 5006:
                              case 5008:
                                 int idxPlus = (var1.b - 5002) / 2;
                                 if (this.y.diemTiemNang_d > 0 && this.c_detu != null) {
                                    this.c_detu[idxPlus].a(this.c_detu[idxPlus].e() + 1);
                                    --this.y.diemTiemNang_d;
                                 }
                                 var13 = false;
                                 break;
                              case 5012: // Tiá»m nÄƒng Äá»‡ tá»­: +10 stat
                              case 5014:
                              case 5016:
                              case 5018:
                                 int idxPlus10 = (var1.b - 5012) / 2;
                                 if (this.y.diemTiemNang_d >= 10 && this.c_detu != null) {
                                    this.c_detu[idxPlus10].a(this.c_detu[idxPlus10].e() + 10);
                                    this.y.diemTiemNang_d -= 10;
                                 } else if (this.y.diemTiemNang_d > 0 && this.c_detu != null) {
                                    this.c_detu[idxPlus10].a(this.c_detu[idxPlus10].e() + this.y.diemTiemNang_d);
                                    this.y.diemTiemNang_d = 0;
                                 }
                                 var13 = false;
                                 break;
                              case 5009: // Tiá»m nÄƒng Äá»‡ tá»­: reset vá» giÃ¡ trá»‹ gá»‘c
                                 if (this.c_detu != null) {
                                    this.y.diemTiemNang_d += (this.c_detu[0].e() - this.y.arrayTiemNang_d[0])
                                                           + (this.c_detu[1].e() - this.y.arrayTiemNang_d[1])
                                                           + (this.c_detu[2].e() - this.y.arrayTiemNang_d[2])
                                                           + (this.c_detu[3].e() - this.y.arrayTiemNang_d[3]);
                                    this.c_detu[0].a("" + this.y.arrayTiemNang_d[0]);
                                    this.c_detu[1].a("" + this.y.arrayTiemNang_d[1]);
                                    this.c_detu[2].a("" + this.y.arrayTiemNang_d[2]);
                                    this.c_detu[3].a("" + this.y.arrayTiemNang_d[3]);
                                 }
                                 var13 = false;
                                 break;
                              case 5010: // Tiá»m nÄƒng Äá»‡ tá»­: XÃ¡c nháº­n
                                 beatdz.Utlis.writeLog("[5010] Cong button clicked. c_detu=" + (this.c_detu != null ? "ok" : "null"));
                                 if (this.c_detu != null) {
                                    beatdz.Utlis.writeLog("[5010] c_detu values: [" + this.c_detu[0].e() + "," + this.c_detu[1].e() + "," + this.c_detu[2].e() + "," + this.c_detu[3].e() + "]");
                                    beatdz.Utlis.writeLog("[5010] arrayTiemNang_d: [" + this.y.arrayTiemNang_d[0] + "," + this.y.arrayTiemNang_d[1] + "," + this.y.arrayTiemNang_d[2] + "," + this.y.arrayTiemNang_d[3] + "]");
                                    beatdz.Utlis.writeLog("[5010] diemTiemNang_d remaining: " + this.y.diemTiemNang_d);
                                    boolean changed =
                                       this.c_detu[0].e() != this.y.arrayTiemNang_d[0] ||
                                       this.c_detu[1].e() != this.y.arrayTiemNang_d[1] ||
                                       this.c_detu[2].e() != this.y.arrayTiemNang_d[2] ||
                                       this.c_detu[3].e() != this.y.arrayTiemNang_d[3];
                                    beatdz.Utlis.writeLog("[5010] Has changes: " + changed);
                                    if (changed) {
                                       try {
                                          Message var5_d = Message.c((byte)-62);
                                          var5_d.writeInt(this.c_detu[0].e());
                                          var5_d.writeInt(this.c_detu[1].e());
                                          var5_d.writeInt(this.c_detu[2].e());
                                          var5_d.writeInt(this.c_detu[3].e());
                                          var5_d.send();
                                          beatdz.Utlis.writeLog("[5010] Packet -62 SENT OK");
                                          this.y.arrayTiemNang_d[0] = this.c_detu[0].e();
                                          this.y.arrayTiemNang_d[1] = this.c_detu[1].e();
                                          this.y.arrayTiemNang_d[2] = this.c_detu[2].e();
                                          this.y.arrayTiemNang_d[3] = this.c_detu[3].e();
                                          for (int idx = 0; idx < this.c_detu.length; idx++) {
                                             this.c_detu[idx].n = this.y.arrayTiemNang_d[idx];
                                          }
                                       } catch (Exception ex) {
                                          beatdz.Utlis.writeLog("[5010] ERROR: " + ex.getMessage());
                                       }
                                    }
                                 }
                                 var13 = false;
                                 break;
                              case 2001:
                                 if (this.c[0].e() - 1 >= this.c[0].n) {
                                    this.c[0].a(this.c[0].e() - 1);
                                    ++this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2002:
                                 if (this.i > 0) {
                                    this.c[0].a(this.c[0].e() + 1);
                                    --this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2003:
                                 if (this.c[1].e() - 1 >= this.c[1].n) {
                                    this.c[1].a(this.c[1].e() - 1);
                                    ++this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2004:
                                 if (this.i > 0) {
                                    this.c[1].a(this.c[1].e() + 1);
                                    --this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2005:
                                 if (this.c[2].e() - 1 >= this.c[2].n) {
                                    this.c[2].a(this.c[2].e() - 1);
                                    ++this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2006:
                                 if (this.i > 0) {
                                    this.c[2].a(this.c[2].e() + 1);
                                    --this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2007:
                                 if (this.c[3].e() - 1 >= this.c[3].n) {
                                    this.c[3].a(this.c[3].e() - 1);
                                    ++this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2008:
                                 if (this.i > 0) {
                                    this.c[3].a(this.c[3].e() + 1);
                                    --this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2009:
                                 this.i += this.c[0].e() + this.c[1].e() + this.c[2].e() + this.c[3].e() - (this.e + this.f + this.h + this.g);
                                 this.c[0].a("" + this.e);
                                 this.c[1].a("" + this.f);
                                 this.c[2].a("" + this.h);
                                 this.c[3].a("" + this.g);
                                 var13 = false;
                                 break;
                              case 2010:
                                 var4 = this;

                                 try {
                                    (var5 = new Message((byte)62)).writeShort(var4.c[0].e());
                                    var5.writeShort(var4.c[1].e());
                                    var5.writeShort(var4.c[2].e());
                                    var5.writeShort(var4.c[3].e());
                                    var5.send();
                                    var13 = false;
                                 } catch (Exception var14) {
                                    Utlis.println(var14);
                                    var13 = false;
                                 }
                                 break;
                              case 2011:
                                 if (var1.j.k >= 0) {
                                    this.P[1].a(var1.j.k);
                                    this.B();
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2012:
                                 if (this.i > 10) {
                                    this.c[0].a(this.c[0].e() + 10);
                                    this.i -= 10;
                                    var13 = false;
                                 } else if (this.i > 0) {
                                    this.c[0].a(this.c[0].e() + this.i);
                                    this.i = 0;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2014:
                                 if (this.i > 10) {
                                    this.c[1].a(this.c[1].e() + 10);
                                    this.i -= 10;
                                    var13 = false;
                                 } else if (this.i > 0) {
                                    this.c[1].a(this.c[1].e() + this.i);
                                    this.i = 0;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2016:
                                 if (this.i > 10) {
                                    this.c[2].a(this.c[2].e() + 10);
                                    this.i -= 10;
                                    var13 = false;
                                 } else if (this.i > 0) {
                                    this.c[2].a(this.c[2].e() + this.i);
                                    this.i = 0;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2018:
                                 if (this.i > 10) {
                                    this.c[3].a(this.c[3].e() + 10);
                                    this.i -= 10;
                                    var13 = false;
                                 } else if (this.i > 0) {
                                    this.c[3].a(this.c[3].e() + this.i);
                                    this.i = 0;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;


                              case 2050:
                                 var22 = Message.c((byte)-18);
                                 var3 = this.u();
                                 var22.writeByte(var3);
                                 var22.send();
                                 var13 = false;
                                 break;
                              case 3000:
                                 this.r();
                                 var13 = false;
                                 break;
                              case 3001:
                                 this.q();
                                 var13 = false;
                                 break;
                              case 5021: // Cá»™ng chiÃªu thá»©c Ä‘á»‡ tá»­
                                 if (this.a >= 0 && this.y.skills_d != null && this.a < this.y.skills_d.length) {
                                    j_d(this.y.skills_d[this.a].idTemplate);
                                 }
                                 var13 = false;
                                 break;
                              case 5020: // Chá»n chiÃªu thá»©c Ä‘á»‡ tá»­
                                 this.r();
                                 var13 = false;
                                 break;
                              case 4001:
                                 if (this.F >= 0) {
                                    var2 = this.u();
                                    SkillClan var23 = (SkillClan)this.y.aH.elementAt(var2);
                                    this.p.a((LangLa_cx)(new LangLa_aq(this.p, var2, var23)));
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 4002:
                                 if (this.F >= 0) {
                                    var2 = this.u();
                                    if (((SkillClan)this.y.aH.elementAt(var2)).id == 19) {
                                       Message var26;
                                       (var26 = Message.c((byte)-26)).writeByte(var2);
                                       var26.writeBoolean(true);
                                       var26.send();
                                       var13 = false;
                                    } else {
                                       this.p.a((LangLa_cx)(new LangLa_f(this.p, var2)));
                                       var13 = false;
                                    }
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 4003:
                                 if (this.F >= 0) {
                                    DataCenter.gI().currentScreen.a(Caption.qF, 2050, this);
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              default:
                                 if (var1.b == 1426) {
                                     log("[1426] CLICKED - Current k=" + this.k() + " y=" + (this.y == null ? "NULL" : "ok") + " name_d=" + (this.y == null ? "N/A" : String.valueOf(this.y.name_d)));
                                     try {
                                         if (this.y != null && this.y.name_d != null) {
                                             log("[1426] Sending packet -73 for disciple=" + this.y.name_d);
                                             Message var_res = Message.c((byte)-73);
                                             var_res.writeUTF(this.y.name_d);
                                             var_res.send();
                                             log("[1426] Packet -73 sent successfully");
                                             LangLa_dp.a().h();
                                         } else {
                                             log("[1426] ABORTED: y or name_d is null! y=" + (this.y != null) + " name_d=" + (this.y != null ? this.y.name_d : "N/A"));
                                         }
                                     } catch (Exception ex1426) {
                                         log("[1426] EXCEPTION occurred: " + ex1426.toString());
                                         ex1426.printStackTrace();
                                     }
                                     var13 = false;
                                 } else if (this.k() == 0) {
                                    if (var1.b == 1010) {
                                       this.a(var1.j, var1.j.k);
                                       switch(var1.j.k) {
                                       case 0:
                                          this.cL = a(var1, this, this.y.arrItemBody[0]);
                                          var13 = false;
                                          break label852;
                                       case 1:
                                          this.cL = a(var1, this, this.y.arrItemBody[2]);
                                          var13 = false;
                                          break label852;
                                       case 2:
                                          this.cL = a(var1, this, this.y.arrItemBody[4]);
                                          var13 = false;
                                          break label852;
                                       case 3:
                                          this.cL = a(var1, this, this.y.arrItemBody[6]);
                                          var13 = false;
                                          break label852;
                                       case 4:
                                          this.cL = a(var1, this, this.y.arrItemBody[8]);
                                          var13 = false;
                                          break label852;
                                       default:
                                          var13 = false;
                                          break label852;
                                       }
                                    }

                                    if (var1.b == 1011) {
                                       this.a(var1.j, var1.j.k);
                                       switch(var1.j.k) {
                                       case 0:
                                          this.cL = a(var1, this, this.y.arrItemBody[1]);
                                          var13 = false;
                                          break label826;
                                       case 1:
                                          this.cL = a(var1, this, this.y.arrItemBody[3]);
                                          var13 = false;
                                          break label826;
                                       case 2:
                                          this.cL = a(var1, this, this.y.arrItemBody[5]);
                                          var13 = false;
                                          break label826;
                                       case 3:
                                          this.cL = a(var1, this, this.y.arrItemBody[7]);
                                          var13 = false;
                                          break label826;
                                       case 4:
                                          this.cL = a(var1, this, this.y.arrItemBody[9]);
                                          var13 = false;
                                          break label826;
                                       default:
                                          var13 = false;
                                          break label826;
                                       }
                                    }

                                    if (var1.b == 1012) {
                                       this.a(var1.j, var1.j.k);
                                       switch(var1.j.k) {
                                       case 0:
                                          this.cL = a(var1, this, this.y.arrItemBody[10]);
                                          var13 = false;
                                          break label827;
                                       case 1:
                                          this.cL = a(var1, this, this.y.arrItemBody[11]);
                                          var13 = false;
                                          break label827;
                                       case 2:
                                          this.cL = a(var1, this, this.y.arrItemBody[12]);
                                          var13 = false;
                                          break label827;
                                       case 3:
                                          this.cL = a(var1, this, this.y.arrItemBody[13]);
                                          var13 = false;
                                          break label827;
                                       default:
                                          var13 = false;
                                          break label827;
                                       }
                                    } else if (var1.b == 1013) {
                                       this.a(var1.j, var1.j.k);
                                       this.cL = a(var1, this, this.y.arrItemBody[14]);
                                       var13 = false;
                                    } else if (var1.b == 1014) {
                                       this.a(var1.j, var1.j.k);
                                       this.cL = a(var1, this, this.y.arrItemBody[15]);
                                       var13 = false;
                                    } else if (var1.b == 1015) {
                                       this.a(var1.j, var1.j.k);
                                       this.cL = a(var1, this, this.y.arrItemBody[16]);
                                       var13 = false;
                                     } else if (var1.b == 1017) {
                                        this.a(var1.j, var1.j.k);
                                        this.cL = a(var1, this, this.y.arrItemBody[18]);
                                        var13 = false;
                                     } else if (var1.b == 1018) {
                                        this.a(var1.j, var1.j.k);
                                        this.cL = a(var1, this, this.y.arrItemBody[11]);
                                        var13 = false;
                                     } else if (var1.b == 1019) {
                                        this.a(var1.j, var1.j.k);
                                        this.cL = a(var1, this, this.y.arrItemBody[12]);
                                        var13 = false;
                                     } else if (var1.b == 1020) {
                                        this.a(var1.j, var1.j.k);
                                        this.cL = a(var1, this, this.y.arrItemPet[2]);
                                        var13 = false;
                                     } else if (var1.b == 1021) {
                                        this.a(var1.j, var1.j.k);
                                        this.cL = a(var1, this, this.y.arrItemBody[13]);
                                        var13 = false;
                                     } else {
                                        if (var1.b == 1050) {
                                           this.a(var1.j, var1.j.k);
                                           switch(var1.j.k) {
                                           case 0:
                                              this.cL = a(var1, this, this.y.arrItemBody2[0]);
                                              var13 = false;
                                              break label828;
                                           case 1:
                                              this.cL = a(var1, this, this.y.arrItemBody2[2]);
                                              var13 = false;
                                              break label828;
                                           case 2:
                                              this.cL = a(var1, this, this.y.arrItemBody2[4]);
                                              var13 = false;
                                              break label828;
                                           case 3:
                                              this.cL = a(var1, this, this.y.arrItemBody2[6]);
                                              var13 = false;
                                              break label828;
                                           case 4:
                                              this.cL = a(var1, this, this.y.arrItemBody2[8]);
                                              var13 = false;
                                              break label828;
                                           default:
                                              var13 = false;
                                              break label828;
                                           }
                                        }

                                        if (var1.b == 1051) {
                                           this.a(var1.j, var1.j.k);
                                           switch(var1.j.k) {
                                           case 0:
                                              this.cL = a(var1, this, this.y.arrItemBody2[1]);
                                              var13 = false;
                                              break label829;
                                           case 1:
                                              this.cL = a(var1, this, this.y.arrItemBody2[3]);
                                              var13 = false;
                                              break label829;
                                           case 2:
                                              this.cL = a(var1, this, this.y.arrItemBody2[5]);
                                              var13 = false;
                                              break label829;
                                           case 3:
                                              this.cL = a(var1, this, this.y.arrItemBody2[7]);
                                              var13 = false;
                                              break label829;
                                           case 4:
                                              this.cL = a(var1, this, this.y.arrItemBody2[9]);
                                              var13 = false;
                                              break label829;
                                           default:
                                              var13 = false;
                                              break label829;
                                           }
                                        }

                                        if (var1.b == 1052) {
                                           this.a(var1.j, var1.j.k);
                                           switch(var1.j.k) {
                                           case 0:
                                              this.cL = a(var1, this, this.y.arrItemBody2[10]);
                                              var13 = false;
                                              break label851;
                                           case 1:
                                              this.cL = a(var1, this, this.y.arrItemBody2[11]);
                                              var13 = false;
                                              break label851;
                                           case 2:
                                              this.cL = a(var1, this, this.y.arrItemBody2[12]);
                                              var13 = false;
                                              break label851;
                                           case 3:
                                              this.cL = a(var1, this, this.y.arrItemBody2[13]);
                                              var13 = false;
                                              break label851;
                                           default:
                                              var13 = false;
                                              break label851;
                                           }
                                        }

                                        if (var1.b == 1053) {
                                           this.a(var1.j, var1.j.k);
                                           this.cL = a(var1, this, this.y.arrItemBody2[14]);
                                           var13 = false;
                                        } else if (var1.b == 1054) {
                                           this.a(var1.j, var1.j.k);
                                           this.cL = a(var1, this, this.y.arrItemBody2[15]);
                                           var13 = false;
                                        } else if (var1.b == 1055) {
                                           this.a(var1.j, var1.j.k);
                                           this.cL = a(var1, this, this.y.arrItemBody2[16]);
                                           var13 = false;
                                        } else if (var1.b == 1057) {
                                           this.a(var1.j, var1.j.k);
                                           this.cL = a(var1, this, this.y.arrItemBody2[18]);
                                           var13 = false;
                                        } else if (var1.b == 1058) {
                                           this.a(var1.j, var1.j.k);
                                           if (this.b.b.b == 1) {
                                              this.cL = a(var1, this, this.y.arrItemBody2[11]); // Bi Kip (tab du phong)
                                           } else {
                                              this.cL = a(var1, this, this.y.arrItemPet[0]);
                                           }
                                           var13 = false;
                                        } else if (var1.b == 1059) {
                                           this.a(var1.j, var1.j.k);
                                           if (this.b.b.b == 1) {
                                              this.cL = a(var1, this, this.y.arrItemBody2[12]); // Ao Choang (tab du phong)
                                           } else {
                                              this.cL = a(var1, this, this.y.arrItemPet[1]);
                                           }
                                           var13 = false;
                                        } else if (var1.b == 1060) {
                                           this.a(var1.j, var1.j.k);
                                           this.cL = a(var1, this, this.y.arrItemPet[2]);
                                           var13 = false;
                                        } else if (var1.b == 1061) {
                                           this.a(var1.j, var1.j.k);
                                           this.cL = a(var1, this, this.y.arrItemPet[3]);
                                           var13 = false;
                                        } else if (var1.b == 1026) {
                                           try {
                                              String nameToRequest = (this.k() == 2 && this.y != null && this.y.name_d != null) ? this.y.name_d : this.y.name;
                                              Utlis.writeLog("[DEBUG] CLICK 1026: nameToRequest=" + nameToRequest + " k=" + this.k());
                                              (var5 = Message.c((byte)-73)).writeUTF(nameToRequest);
                                              var5.send();
                                              LangLa_dp.a().h();
                                           } catch (Exception e) {
                                              Utlis.println(e);
                                           }
                                           var13 = false;
                                        } else if (var1.b >= 5005 && var1.b <= 5008) {
                                           // Add potential point for disciple
                                           if (Char.gI().diemTiemNang_d > 0) {
                                               Char.gI().arrayTiemNang_d[var1.b - 5005]++;
                                               Char.gI().diemTiemNang_d--;
                                               this.refreshDisciplePotential();
                                           }
                                           var13 = false;
                                        } else if (var1.b >= 5015 && var1.b <= 5018) {
                                           // Remove potential point for disciple (Reset/Minus)
                                           int idx = var1.b - 5015;
                                           if (Char.gI().arrayTiemNang_d[idx] > this.c_detu[idx].n) {
                                               Char.gI().arrayTiemNang_d[idx]--;
                                               Char.gI().diemTiemNang_d++;
                                               this.refreshDisciplePotential();
                                           }
                                           var13 = false;
                                        } else if (var1.b == 5009) {
                                           // Reset disciple potential allocation (before confirm)
                                           for (int i = 0; i < 4; i++) {
                                               int diff = Char.gI().arrayTiemNang_d[i] - this.c_detu[i].n;
                                               Char.gI().diemTiemNang_d += diff;
                                               Char.gI().arrayTiemNang_d[i] = this.c_detu[i].n;
                                           }
                                           this.refreshDisciplePotential();
                                           var13 = false;
                                        } else if (var1.b == 5010) {
                                           // Confirm disciple potential allocation
                                           try {
                                               Message msg = new Message((byte)-62);
                                               for (int i = 0; i < 4; i++) {
                                                   msg.writeInt(Char.gI().arrayTiemNang_d[i]);
                                               }
                                               msg.send();
                                           } catch (Exception e) {
                                               Utlis.println(e);
                                           }
                                           var13 = false;
                                        } else if (var1.b == 1090) {
                                           this.a(var1.j, var1.j.k);
                                           this.af = true;
                                           this.cL = a(var1, this, this.C);
                                           var13 = false;
                                        } else {
                                           var13 = false;
                                        }
                                    }
                                 } else if (this.k() == 2) {
                                    if (var1.b >= 1410 && var1.b <= 1421) {
                                       this.a(var1.j, var1.j.k);
                                       int slotIdx_d = var1.b - 1410;
                                       int itemIdx_d = -1;
                                       switch(slotIdx_d) {
                                          case 0: itemIdx_d = var1.j.k * 2; break;
                                          case 1: itemIdx_d = var1.j.k * 2 + 1; break;
                                          case 2: itemIdx_d = 10; break;
                                          case 8: itemIdx_d = 11; break;
                                          case 9: itemIdx_d = 12; break;
                                          case 11: itemIdx_d = 13; break;
                                          case 3: itemIdx_d = 14; break;
                                          case 4: itemIdx_d = 15; break;
                                          case 5: itemIdx_d = 16; break;
                                          case 7: itemIdx_d = 18; break;
                                          case 10: itemIdx_d = 19; break; // Note: 19 is dummy for book slot
                                       }
                                       log("[DETU_EQ2] b=" + var1.b + " slotIdx=" + slotIdx_d + " itemIdx=" + itemIdx_d + " jk=" + var1.j.k);
                                       
                                       if (slotIdx_d == 10) {
                                           // Special case: Disciple Combat Book
                                           if (this.y.bh_d != null && this.y.bh_d.itemSach != null) {
                                               this.af = true;
                                               this.cL = a(var1, this, this.y.bh_d.itemSach);
                                               log("[DETU_EQ2] Show Book Popup");
                                           }
                                       } else if (itemIdx_d >= 0 && this.y.bh_d != null && this.y.bh_d.arrItemBody != null && itemIdx_d < this.y.bh_d.arrItemBody.length) {
                                          this.cL = a(var1, this, this.y.bh_d.arrItemBody[itemIdx_d]);
                                          log("[DETU_EQ2] cL=" + (this.cL == null ? "null" : this.cL.getClass().getSimpleName()));
                                       }
                                       var13 = false;
                                     } else {
                                        var13 = false;
                                     }
                                  } else {
                                     var13 = false;
                                  }
                               }
                           } catch (Exception var17) {
                              Utlis.println(var17);
                              var13 = false;
                              break label853;
                           } finally {
                              if (var13) {
                                 if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
                                    ((LangLa_mk)this.cL).a();
                                 }

                              }
                           }

                           if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
                              ((LangLa_mk)this.cL).a();
                              return;
                           }

                           return;
                        }

                        if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
                           ((LangLa_mk)this.cL).a();
                           return;
                        }

                        return;
                     }

                     if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
                        ((LangLa_mk)this.cL).a();
                     }

                     return;
                  }

                  if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
                     ((LangLa_mk)this.cL).a();
                  }

                  return;
               }

               if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
                  ((LangLa_mk)this.cL).a();
               }

               return;
            }

            if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
               ((LangLa_mk)this.cL).a();
            }

            return;
         }

         if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
            ((LangLa_mk)this.cL).a();
         }

         return;
      }

      if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
         ((LangLa_mk)this.cL).a();
      }

   }

   private int u() {
      boolean var2 = false;

      for(int var3 = 0; var3 < this.y.aH.size(); ++var3) {
         SkillClan var1 = (SkillClan)this.y.aH.get(var3);
         if (this.E == 0) {
            if (var1.id == 19) {
               var2 = true;
            }

            if (this.F == var3) {
               if (var2) {
                  return var3 + 1;
               }

               return var3;
            }
         } else {
            for(int var4 = 0; var4 < this.y.aH.size(); ++var4) {
               if (((SkillClan)this.y.aH.get(var4)).id == 19) {
                  return var4;
               }
            }
         }
      }

      return this.F;
   }

   public void o() {
      this.D = mFont.c(mFont.d, this.j(this.F), this.width - 20);
   }

   public void q() {
      if (this.k() == 2) {
         if (this.y.skills_d != null && this.a >= 0 && this.a < this.y.skills_d.length) {
            j_d(this.y.skills_d[this.a].idTemplate);
         }
      } else {
         h(this.z[this.a].idTemplate);
      }
   }

   public void r() {
      if (this.k() == 2) {
         if (this.y.skills_d != null && this.a >= 0 && this.a < this.y.skills_d.length) {
            i_d(this.y.skills_d[this.a].idTemplate);
         }
      } else {
         i(this.z[this.a].idTemplate);
      }
   }

   private boolean v() {
      return this.y.name.equals(Char.gI().name);
   }

   private static void a(Vector var0, SkillClan var1) {
      ItemOption[] var5;
      int var2 = (var5 = var1.b()).length;

      for(int var3 = 0; var3 < var2; ++var3) {
         String var4;
         if ((var4 = var5[var3].a(0)) != null && var4.length() > 0) {
            var0.addElement(var4);
         }
      }

   }

   private void a(Vector var1, Skill var2) {
      if (this.y.level() >= var2.levelNeed) {
         var1.addElement("c#white" + Caption.rH[3] + var2.levelNeed);
      } else {
         var1.addElement("c#red" + Caption.rH[3] + var2.levelNeed);
      }

      StringBuilder var10001;
      int var4;
      if (var2.idTemplate >= 15 && var2.idTemplate <= 17) {
         var10001 = (new StringBuilder()).append(Caption.cT);
         var4 = this.y.aU;
         var1.addElement(var10001.append((short)(var2.rangeNgang + var4)).toString());
      }

      if (var2.getSkillTemplate().type < 5) {
         var1.addElement(Caption.rH[7] + var2.mpUse);
         var1.addElement(Caption.rH[8] + (float)var2.coolDown / 1000.0F + Caption.cU);
         if (!var2.d()) {
            var10001 = (new StringBuilder()).append(Caption.rH[9]);
            var4 = this.y.aU;
            var1.addElement(var10001.append((short)(var2.rangeNgang + var4)).toString());
            var1.addElement(Caption.rH[10] + var2.targetLimit(this.y.level()));
         }
      } else if (var2.idTemplate == 29) {
         var1.addElement(Caption.rH[8] + (float)var2.coolDown / 1000.0F + Caption.cU);
      }

      ItemOption[] var6;
      int var3 = (var6 = var2.g()).length;

      for(var4 = 0; var4 < var3; ++var4) {
         String var5;
         ItemOption option = var6[var4];
         var5 = var2.idTemplate == 25 && option.d() == 273
                 ? "Tăng sát thương tấn công: +" + option.a[1] + " (duy trì 10 giây)"
                 : option.a(this.y.idClass);
         if (var5 != null && var5.length() > 0) {
            var1.addElement(var5);
         }
      }

   }

   public String b(int var1) {
      if (this.z == null || var1 < 0 || var1 >= this.z.length) return "";
      this.a = var1;
      Skill var6;
      Skill var2 = b((var6 = this.z[var1]).idTemplate, var6.level + 1);
      Vector var3;
      (var3 = new Vector()).addElement("c#moc" + var6.getSkillTemplate().name);
      if (var6.getSkillTemplate().detail != null && var6.getSkillTemplate().detail.length() > 0) {
         var3.addElement(var6.getSkillTemplate().detail);
      }

      var3.addElement(Caption.rH[4] + var6.getSkillTemplate().levelMax);
      if (var6.getSkillTemplate().type >= 5) {
         var3.addElement("c#green" + Caption.cV);
      } else if (var6.d()) {
         var3.addElement("c#green" + Caption.lk);
      }

      if (var6.level == 0) {
         var3.addElement("c#red" + Caption.cW + var2.level + Caption.cX);
         this.a(var3, var2);
      } else if (var6.level == var6.getSkillTemplate().levelMax) {
         var3.addElement("c#yellow" + Caption.cY);
         this.a(var3, var6);
      } else {
         var3.addElement("c#yellow" + Caption.cZ + var6.level);
         this.a(var3, var6);
         if (var2 != null) {
            var3.addElement("c#red" + Caption.da + var2.level);
            this.a(var3, var2);
         }
      }

      Vector var7 = new Vector();

      int var4;
      String var8;
      for(var4 = 0; var4 < var3.size(); ++var4) {
         var8 = String.valueOf(var3.elementAt(var4));
         int var5;
         Vector var9;
         if (var4 == 0) {
            var9 = mFont.a(mFont.e, var8, 180);

            for(var5 = 0; var5 < var9.size(); ++var5) {
               var7.add(new LangLa_lk(0, (String)var9.elementAt(var5)));
            }
         } else {
            var9 = mFont.a(mFont.d, var8, 180);

            for(var5 = 0; var5 < var9.size(); ++var5) {
               var7.add(new LangLa_lk(1, (String)var9.elementAt(var5)));
            }
         }
      }

      var8 = "";
      this.W = new LangLa_lk[var7.size()];

      for(var4 = 0; var4 < var7.size(); ++var4) {
         this.W[var4] = (LangLa_lk)var7.elementAt(var4);
         var8 = var8 + this.W[var4].b;
         if (var4 < this.W.length - 1) {
            var8 = var8 + "\r\n";
         }
      }

      return var8;
   }

   public String b_d(int var1) {
      if (this.y.skills_d == null || var1 < 0 || var1 >= this.y.skills_d.length) return "";
      this.a = var1;
      Skill var6 = this.y.skills_d[var1];
      Skill tmpSkill = b(var6.idTemplate, var6.level);
      if (tmpSkill != null) var6 = tmpSkill;
      Skill var2 = b(var6.idTemplate, var6.level + 1);
      Vector var3;
      (var3 = new Vector()).addElement("c#moc" + var6.getSkillTemplate().name);
      if (var6.getSkillTemplate().detail != null && var6.getSkillTemplate().detail.length() > 0) {
         var3.addElement(var6.getSkillTemplate().detail);
      }

      var3.addElement(Caption.rH[4] + var6.getSkillTemplate().levelMax);
      if (var6.getSkillTemplate().type >= 5) {
         var3.addElement("c#green" + Caption.cV);
      } else if (var6.d()) {
         var3.addElement("c#green" + Caption.lk);
      }

      if (var6.level == 0) {
         if (var2 != null) {
            var3.addElement("c#red" + Caption.cW + var2.level + Caption.cX);
            this.a(var3, var2);
         }
      } else if (var6.level == var6.getSkillTemplate().levelMax) {
         var3.addElement("c#yellow" + Caption.cY);
         this.a(var3, var6);
      } else {
         var3.addElement("c#yellow" + Caption.cZ + var6.level);
         this.a(var3, var6);
         if (var2 != null) {
            var3.addElement("c#red" + Caption.da + var2.level);
            this.a(var3, var2);
         }
      }

      Vector var7 = new Vector();

      int var4;
      String var8;
      for(var4 = 0; var4 < var3.size(); ++var4) {
         var8 = String.valueOf(var3.elementAt(var4));
         int var5;
         Vector var9;
         if (var4 == 0) {
            var9 = mFont.a(mFont.e, var8, 180);

            for(var5 = 0; var5 < var9.size(); ++var5) {
               var7.add(new LangLa_lk(0, (String)var9.elementAt(var5)));
            }
         } else {
            var9 = mFont.a(mFont.d, var8, 180);

            for(var5 = 0; var5 < var9.size(); ++var5) {
               var7.add(new LangLa_lk(1, (String)var9.elementAt(var5)));
            }
         }
      }

      var8 = "";
      this.W = new LangLa_lk[var7.size()];

      for(var4 = 0; var4 < var7.size(); ++var4) {
         this.W[var4] = (LangLa_lk)var7.elementAt(var4);
         var8 = var8 + this.W[var4].b;
         if (var4 < this.W.length - 1) {
            var8 = var8 + "\r\n";
         }
      }

      return var8;
   }

   private static void g(int var0) {
      try {
         Message var1;
         (var1 = new Message((byte)35)).writeByte(var0);
         var1.send();
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   private static void h(int var0) {
      try {
         Message var1;
         (var1 = new Message((byte)14)).writeShort(var0);
         var1.send();
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   private static void i(int var0) {
      try {
         Message var1;
         (var1 = new Message((byte)126)).writeShort(var0);
         var1.send();
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   private static void i_d(int var0) {
      try {
         Message var1;
         (var1 = new Message((byte)-126)).writeShort(var0);
         var1.send();
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }
   private static void j_d(int var0) {
      try {
         Message var1;
         (var1 = new Message((byte)-14)).writeShort(var0);
         var1.send();
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      try {
         if (this.v()) {
            super.a(var1);
         } else {
            this.a(var1, this.cx, this.cy, this.width, this.height, Caption.db, (byte)2, this.r);
         }

         String var10002;
         int var3;
         int var10003;
         int var4;
         if (this.k() == 0) {
            this.b.a((Graphics)var1, 61);
            this.b.a(var1, this.cx, this.cy);
            mFont var10000;
            Graphics var2;
            LangLa_kl var8;
            Item var9;
            switch(this.b.b.b) {
            case 0:
               var2 = var1;
               var8 = this;

               try {
                  var9 = null;
                  if (var8.C != null) {
                     a(var2, var8.ae.cx, var8.ae.cy, var8.C, var8.af, "");
                  }

                  DataCenter.gI();


                   for(var4 = 0; var4 < var8.K[var8.b.b.b][0].i; ++var4) {
                      switch(var4) {
                      case 0: var9 = var8.y.arrItemBody[0]; break; // Weapon
                      case 1: var9 = var8.y.arrItemBody[2]; break; // Helmet
                      case 2: var9 = var8.y.arrItemBody[4]; break; // Armor
                      case 3: var9 = var8.y.arrItemBody[6]; break; // Glove
                      case 4: var9 = var8.y.arrItemBody[8]; // Boots
                      }
                      a(var2, var8.K[var8.b.b.b][0].cx, var8.K[var8.b.b.b][0].cy + var4 * var8.K[var8.b.b.b][0].h, var9, var4 == var8.K[var8.b.b.b][0].k, Caption.qT[var4]);
                   }

                   for(var4 = 0; var4 < var8.K[var8.b.b.b][1].i; ++var4) {
                      switch(var4) {
                      case 0: var9 = var8.y.arrItemBody[1]; break; // Shield
                      case 1: var9 = var8.y.arrItemBody[3]; break; // Necklace
                      case 2: var9 = var8.y.arrItemBody[5]; break; // Ring
                      case 3: var9 = var8.y.arrItemBody[7]; break; // Pants
                      case 4: var9 = var8.y.arrItemBody[9]; // Charm
                      }
                      a(var2, var8.K[var8.b.b.b][1].cx, var8.K[var8.b.b.b][1].cy + var4 * var8.K[var8.b.b.b][1].h, var9, var4 == var8.K[var8.b.b.b][1].k, Caption.qU[var4]);
                   }

                   // Row 5 (Center 5 slots)
                   a(var2, var8.K[var8.b.b.b][2].cx, var8.K[var8.b.b.b][2].cy, (var8.y.arrItemBody != null && var8.y.arrItemBody.length > 10) ? var8.y.arrItemBody[10] : null, var8.K[var8.b.b.b][2].k == 0, Caption.qV[0]); // Pet
                   a(var2, var8.K[var8.b.b.b][8].cx, var8.K[var8.b.b.b][8].cy, (var8.y.arrItemBody != null && var8.y.arrItemBody.length > 11) ? var8.y.arrItemBody[11] : null, var8.K[var8.b.b.b][8].k == 0, Caption.qV[1]); // Manual
                   a(var2, var8.K[var8.b.b.b][9].cx, var8.K[var8.b.b.b][9].cy, (var8.y.arrItemBody != null && var8.y.arrItemBody.length > 12) ? var8.y.arrItemBody[12] : null, var8.K[var8.b.b.b][9].k == 0, Caption.qV[2]); // Cloak
                   a(var2, var8.K[var8.b.b.b][11].cx, var8.K[var8.b.b.b][11].cy, (var8.y.arrItemBody != null && var8.y.arrItemBody.length > 13) ? var8.y.arrItemBody[13] : null, var8.K[var8.b.b.b][11].k == 0, Caption.qV[3]); // BÃ¹a ná»•

                   // Floating slots (Sá»­ dá»¥ng tá» a Ä‘á»™ cx, cy tá»« e())
                   a(var2, var8.K[var8.b.b.b][3].cx, var8.K[var8.b.b.b][3].cy, (var8.y.arrItemBody != null && var8.y.arrItemBody.length > 14) ? var8.y.arrItemBody[14] : null, var8.K[var8.b.b.b][3].k == 0, Caption.rS[0]); // Cáº£i trang
                   a(var2, var8.K[var8.b.b.b][4].cx, var8.K[var8.b.b.b][4].cy, (var8.y.arrItemBody != null && var8.y.arrItemBody.length > 15) ? var8.y.arrItemBody[15] : null, var8.K[var8.b.b.b][4].k == 0, Caption.rS[1]); // Tanto
                   a(var2, var8.K[var8.b.b.b][5].cx, var8.K[var8.b.b.b][5].cy, (var8.y.arrItemBody != null && var8.y.arrItemBody.length > 16) ? var8.y.arrItemBody[16] : null, var8.K[var8.b.b.b][5].k == 0, Caption.rS[2]); // Fashion
                   a(var2, var8.K[var8.b.b.b][7].cx, var8.K[var8.b.b.b][7].cy, (var8.y.arrItemBody != null && var8.y.arrItemBody.length > 18) ? var8.y.arrItemBody[18] : null, var8.K[var8.b.b.b][7].k == 0, Caption.rS[4]); // Eye
                   


                   


                   DataCenter.gI();
                   var8.y.a(var2, (var8.K[0][0].cx + 96), 123, var8.y.a(var8.y.arrItemBody, false), DataCenter.gI().i / 8 % 2, var8.y.m, false);
                   var8.y.b(var2, (var8.K[0][0].cx + 96), 68);
                  var10000 = mFont.b;
                  var10002 = Caption.cj;
                  DataCenter.gI();
                  mFont.a((mFont)var10000, (Graphics)var2, var10002, (var8.K[0][0].cx + 96), 140, 2, -1, -10275328);
                  var2.f(-1);
                  var2.a(170, 144, 210, 144);
                  break;
               } catch (Exception var6) {
                  Utlis.println(var6);
                  break;
               }
            case 1:
               var2 = var1;
               var8 = this;
               try {
                  var9 = null;

                  for(var4 = 0; var4 < var8.K[var8.b.b.b][0].i; ++var4) {
                     switch(var4) {
                     case 0: var9 = var8.y.arrItemBody2[0]; break;
                     case 1: var9 = var8.y.arrItemBody2[2]; break;
                     case 2: var9 = var8.y.arrItemBody2[4]; break;
                     case 3: var9 = var8.y.arrItemBody2[6]; break;
                     case 4: var9 = var8.y.arrItemBody2[8];
                     }
                     a(var2, var8.K[var8.b.b.b][0].cx, var8.K[var8.b.b.b][0].cy + var4 * var8.K[var8.b.b.b][0].h, var9, var4 == var8.K[var8.b.b.b][0].k, Caption.qT[var4]);
                  }

                  for(var4 = 0; var4 < var8.K[var8.b.b.b][1].i; ++var4) {
                     switch(var4) {
                     case 0: var9 = var8.y.arrItemBody2[1]; break;
                     case 1: var9 = var8.y.arrItemBody2[3]; break;
                     case 2: var9 = var8.y.arrItemBody2[5]; break;
                     case 3: var9 = var8.y.arrItemBody2[7]; break;
                     case 4: var9 = var8.y.arrItemBody2[9];
                     }
                     a(var2, var8.K[var8.b.b.b][1].cx, var8.K[var8.b.b.b][1].cy + var4 * var8.K[var8.b.b.b][1].h, var9, var4 == var8.K[var8.b.b.b][1].k, Caption.qU[var4]);
                  }

                  // Row 5 (Sync with Case 0)
                  a(var2, var8.K[var8.b.b.b][2].cx, var8.K[var8.b.b.b][2].cy, (var8.y.arrItemBody2 != null && var8.y.arrItemBody2.length > 10) ? var8.y.arrItemBody2[10] : null, var8.K[var8.b.b.b][2].k == 0, Caption.qV[0]);
                  a(var2, var8.K[var8.b.b.b][8].cx, var8.K[var8.b.b.b][8].cy, (var8.y.arrItemBody2 != null && var8.y.arrItemBody2.length > 11) ? var8.y.arrItemBody2[11] : null, var8.K[var8.b.b.b][8].k == 0, Caption.qV[1]);
                  a(var2, var8.K[var8.b.b.b][9].cx, var8.K[var8.b.b.b][9].cy, (var8.y.arrItemBody2 != null && var8.y.arrItemBody2.length > 12) ? var8.y.arrItemBody2[12] : null, var8.K[var8.b.b.b][9].k == 0, Caption.qV[2]);
                  a(var2, var8.K[var8.b.b.b][11].cx, var8.K[var8.b.b.b][11].cy, (var8.y.arrItemBody2 != null && var8.y.arrItemBody2.length > 13) ? var8.y.arrItemBody2[13] : null, var8.K[var8.b.b.b][11].k == 0, Caption.qV[3]);

                  // Floating slots (Sá»­ dá»¥ng tá» a Ä‘á»™ cx, cy tá»« e())
                  a(var2, var8.K[var8.b.b.b][3].cx, var8.K[var8.b.b.b][3].cy, (var8.y.arrItemBody2 != null && var8.y.arrItemBody2.length > 14) ? var8.y.arrItemBody2[14] : null, var8.K[var8.b.b.b][3].k == 0, Caption.rS[0]);
                  a(var2, var8.K[var8.b.b.b][4].cx, var8.K[var8.b.b.b][4].cy, (var8.y.arrItemBody2 != null && var8.y.arrItemBody2.length > 15) ? var8.y.arrItemBody2[15] : null, var8.K[var8.b.b.b][4].k == 0, Caption.rS[1]);
                  a(var2, var8.K[var8.b.b.b][5].cx, var8.K[var8.b.b.b][5].cy, (var8.y.arrItemBody2 != null && var8.y.arrItemBody2.length > 16) ? var8.y.arrItemBody2[16] : null, var8.K[var8.b.b.b][5].k == 0, Caption.rS[2]);
                  a(var2, var8.K[var8.b.b.b][7].cx, var8.K[var8.b.b.b][7].cy, (var8.y.arrItemBody2 != null && var8.y.arrItemBody2.length > 18) ? var8.y.arrItemBody2[18] : null, var8.K[var8.b.b.b][7].k == 0, Caption.rS[4]);
                  
                  


                  DataCenter.gI();
                  var8.y.a(var2, (var8.K[1][0].cx + 96), 123, var8.y.a(var8.y.arrItemBody2, false), DataCenter.gI().i / 8 % 2, var8.y.m, false);
                  var8.y.b(var2, (var8.K[1][0].cx + 96), 68);
//                  mFont.a((mFont)mFont.b, (Graphics)var2, Caption.cj, (var8.K[1][0].cx + 96), 140, 2, -1, -10275328);
               } catch (Exception var7) {}
               break;
            case 2:
               var2 = var1;
               var8 = this;
               DataCenter.gI();
               var3 = this.b.c() + 2;
               var4 = this.P[0].cy + this.P[0].height + 10;
               this.P[0].a(var1);
               switch(this.P[0].b.b) {
               case 0:
                  var10002 = Caption.rc[1];
                  var10003 = var3 + 6;
                  var4 += 10;
                  mFont.a((mFont)mFont.d, (Graphics)var1, var10002, var10003, var4, 0, -1, 0);
                  var10002 = Caption.rc[2];
                  var10003 = var3 + 6;
                  var4 += 24;
                  mFont.a((mFont)mFont.d, (Graphics)var1, var10002, var10003, var4, 0, -1, 0);
                  var10002 = Caption.rc[3];
                  var10003 = var3 + 6;
                  var4 += 25;
                  mFont.a((mFont)mFont.d, (Graphics)var1, var10002, var10003, var4, 0, -1, 0);
                  var10002 = Caption.rc[4];
                  var10003 = var3 + 6;
                  var4 += 25;
                  mFont.a((mFont)mFont.d, (Graphics)var1, var10002, var10003, var4, 0, -1, 0);
                  if (this.v() && this.y.idClass > 0) {
                     var10000 = mFont.b;
                     var10002 = Caption.dd;
                     var10003 = var3 + 6;
                     DataCenter.gI();
                     mFont.a((mFont)var10000, (Graphics)var1, var10002, var10003, var4 += 21, 0, -1, -10275328);
                     var1.f(-1);
                     var1.a(var3 + 6, var4 + 4, var3 + 6 + mFont.b(mFont.b, Caption.dd), var4 + 4);
                  }

                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.rc[0] + " " + this.i + Caption.dc, var3 + 6, this.b.cy + 7 + 23 + 135, 0, -1, 0);
                  return;
               case 1:
                  this.a((Graphics)var1, (LangLa_ii)this.L[this.b.b.b][1]);

                  for(var3 = 0; var3 < Caption.rd.length; ++var3) {
                     var4 = var3 * var8.L[var8.b.b.b][1].h;
                     if (var8.L[var8.b.b.b][1].c(var4)) {
                        if (var8.L[var8.b.b.b][1].k == var3) {
                           var2.f(-6488);
                           var2.c(3, var4, var8.L[var8.b.b.b][1].width - 9, var8.L[var8.b.b.b][1].h);
                        }

                        if (var3 == 0) {
                           mFont.a((mFont)mFont.d, (Graphics)var2, Caption.rd[var3] + ": " + var8.w[var3] * 90 / 100 + " - " + var8.w[var3], 10, var4 + var8.L[var8.b.b.b][1].h / 2, 0, -1, 0);
                        } else {
                           mFont.a((mFont)mFont.d, (Graphics)var2, Caption.rd[var3] + ": " + var8.w[var3] + (var3 != 5 && var3 != 16 ? "" : "%"), 10, var4 + var8.L[var8.b.b.b][1].h / 2, 0, -1, 0);
                        }
                     }
                  }

                  var8.b(var2);
                  var8.L[var8.b.b.b][1].b(var2, -17, -13);
                  return;
               case 2:
                  this.a((Graphics)var1, (LangLa_ii)this.L[this.b.b.b][2]);

                  for(var3 = 0; var3 < var8.L[var8.b.b.b][2].i; ++var3) {
                     var4 = var3 * var8.L[var8.b.b.b][2].h;
                     if (var8.L[var8.b.b.b][2].c(var4)) {
                        if (var8.L[var8.b.b.b][2].k == var3) {
                           var2.f(-6488);
                           var2.c(3, var4, var8.L[var8.b.b.b][2].width - 9, var8.L[var8.b.b.b][2].h);
                        }

                        if (var3 == 10) {
                           if (var8.y.idhe > 0) {
                              mFont.a((mFont)mFont.d, (Graphics)var2, Caption.re[var3] + Caption.ro[var8.y.L() - 1] + ": " + var8.x[var3], 10, var4 + var8.L[var8.b.b.b][2].h / 2, 0, -1, 0);
                           } else {
                              mFont.a((mFont)mFont.d, (Graphics)var2, Caption.kl + ": " + var8.x[var3], 10, var4 + var8.L[var8.b.b.b][2].h / 2, 0, -1, 0);
                           }
                        } else if (var3 == 11) {
                           if (var8.y.idhe > 0) {
                              mFont.a((mFont)mFont.d, (Graphics)var2, Caption.re[var3] + Caption.ro[var8.y.M() - 1] + ": " + var8.x[var3], 10, var4 + var8.L[var8.b.b.b][2].h / 2, 0, -1, 0);
                           } else {
                              mFont.a((mFont)mFont.d, (Graphics)var2, Caption.km + ": " + var8.x[var3], 10, var4 + var8.L[var8.b.b.b][2].h / 2, 0, -1, 0);
                           }
                        } else {
                           mFont.a((mFont)mFont.d, (Graphics)var2, Caption.re[var3] + ": " + var8.x[var3] + (var3 != 8 && var3 != 9 ? "" : "%"), 10, var4 + var8.L[var8.b.b.b][2].h / 2, 0, -1, 0);
                        }
                     }
                  }

                  var8.b(var2);
                  var8.L[var8.b.b.b][2].b(var2, -17, -13);
                  return;
               default:
                  return;
               }
            case 3:
               this.h(var1);
               break;
            case 4:
               this.i(var1);
               break;
            case 5:
               this.d(var1);
               return;
            default:
               return;
            }
         } else if (this.k() == 2) {
            this.gx_detu.a((Graphics)var1, 61);
            this.gx_detu.a(var1, this.cx, this.cy);
            Graphics var2 = var1;
             LangLa_kl var8 = this;
             int offset_d = var8.gx_detu.c();
             switch(this.gx_detu.b.b) {
             case 0:
                  try {
                      // [DEBUG] Log arrItemPet khi render tab Ä‘á»‡ tá»­
                      if (DataCenter.gI().i % 300 == 0) {
                          StringBuilder dbgSb = new StringBuilder("[LangLa_kl] render detu tab - y=" + (var8.y != null ? var8.y.name_d : "NULL") + " arrItemPet=");
                          if (var8.y != null && var8.y.arrItemPet != null) {
                              dbgSb.append("len=").append(var8.y.arrItemPet.length).append(" [");
                              for (int di = 0; di < var8.y.arrItemPet.length; di++) {
                                  dbgSb.append(var8.y.arrItemPet[di] != null ? "id"+var8.y.arrItemPet[di].id : "null").append(",");
                              }
                              dbgSb.append("]");
                          } else { dbgSb.append("NULL"); }
                          Utlis.writeLog(dbgSb.toString());
                      }

                     Item var12_d = null;

                     // Left column (5 slots: 0, 2, 4, 6, 8)
                     for(var4 = 0; var4 < var8.K[5][0].i; ++var4) {
                        if (var8.y.bh_d != null && var8.y.bh_d.arrItemBody != null && (var4 * 2) < var8.y.bh_d.arrItemBody.length) {
                           var12_d = var8.y.bh_d.arrItemBody[var4 * 2];
                        } else { var12_d = null; }
                        a(var2, var8.K[5][0].cx, var8.K[5][0].cy + var4 * var8.K[5][0].h, var12_d, var4 == var8.K[5][0].k, Caption.qT[var4]);
                     }

                     // Right column (5 slots: 1, 3, 5, 7, 9)
                     for(var4 = 0; var4 < var8.K[5][1].i; ++var4) {
                        if (var8.y.bh_d != null && var8.y.bh_d.arrItemBody != null && (var4 * 2 + 1) < var8.y.bh_d.arrItemBody.length) {
                           var12_d = var8.y.bh_d.arrItemBody[var4 * 2 + 1];
                        } else { var12_d = null; }
                        a(var2, var8.K[5][1].cx, var8.K[5][1].cy + var4 * var8.K[5][1].h, var12_d, var4 == var8.K[5][1].k, Caption.qU[var4]);
                     }

                     // Row 5 (Center/Bottom 5 slots: 10, 11, 12, 17, 13)
                     a(var2, var8.K[5][2].cx, var8.K[5][2].cy, (var8.y.bh_d != null && var8.y.bh_d.arrItemBody != null && var8.y.bh_d.arrItemBody.length > 10) ? var8.y.bh_d.arrItemBody[10] : null, var8.K[5][2].k == 0, Caption.qV[0]); // Pet
                     a(var2, var8.K[5][8].cx, var8.K[5][8].cy, (var8.y.bh_d != null && var8.y.bh_d.arrItemBody != null && var8.y.bh_d.arrItemBody.length > 11) ? var8.y.bh_d.arrItemBody[11] : null, var8.K[5][8].k == 0, Caption.qV[1]); // Manual
                     a(var2, var8.K[5][9].cx, var8.K[5][9].cy, (var8.y.bh_d != null && var8.y.bh_d.arrItemBody != null && var8.y.bh_d.arrItemBody.length > 12) ? var8.y.bh_d.arrItemBody[12] : null, var8.K[5][9].k == 0, Caption.qV[2]); // Cloak
                     a(var2, var8.K[5][11].cx, var8.K[5][11].cy, (var8.y.bh_d != null && var8.y.bh_d.arrItemBody != null && var8.y.bh_d.arrItemBody.length > 13) ? var8.y.bh_d.arrItemBody[13] : null, var8.K[5][11].k == 0, Caption.qV[3]); // BÃ¹a ná»•

                     // Floating Top Slots (5 slots: 14, 15, 16, 18, 19)
                     a(var2, var8.K[5][3].cx, var8.K[5][3].cy, (var8.y.bh_d != null && var8.y.bh_d.arrItemBody != null && var8.y.bh_d.arrItemBody.length > 14) ? var8.y.bh_d.arrItemBody[14] : null, var8.K[5][3].k == 0, Caption.rS[0]); // Cáº£i trang
                     a(var2, var8.K[5][4].cx, var8.K[5][4].cy, (var8.y.bh_d != null && var8.y.bh_d.arrItemBody != null && var8.y.bh_d.arrItemBody.length > 15) ? var8.y.bh_d.arrItemBody[15] : null, var8.K[5][4].k == 0, Caption.rS[1]); // Tanto
                     a(var2, var8.K[5][5].cx, var8.K[5][5].cy, (var8.y.bh_d != null && var8.y.bh_d.arrItemBody != null && var8.y.bh_d.arrItemBody.length > 16) ? var8.y.bh_d.arrItemBody[16] : null, var8.K[5][5].k == 0, Caption.rS[2]); // Fashion
                     a(var2, var8.K[5][7].cx, var8.K[5][7].cy, (var8.y.bh_d != null && var8.y.bh_d.arrItemBody != null && var8.y.bh_d.arrItemBody.length > 18) ? var8.y.bh_d.arrItemBody[18] : null, var8.K[5][7].k == 0, Caption.rS[4]); // Eye
                    
                    // Combat Book slot (Disciple)
                    if (this.k() == 2 && var8.y.bh_d != null && var8.y.bh_d.itemSach != null && var8.K[5] != null && var8.K[5].length > 10 && var8.K[5][10] != null) {
                       a(var2, var8.K[5][10].cx, var8.K[5][10].cy, var8.y.bh_d.itemSach, var8.K[5][10].k == 0, "Sách");
                    }
                     

                     // Character Preview
                     DataCenter.gI();
                     if (var8.y.bh_d != null) {
                        var8.y.bh_d.a(var2, (var8.K[5][0].cx + 96), 123, var8.y.bh_d.a(var8.y.bh_d.arrItemBody, false), DataCenter.gI().i / 8 % 2, var8.y.bh_d.m, false);
                        var8.y.bh_d.b(var2, (var8.K[5][0].cx + 96), 68);
                     } else {
                        var8.y.a(var2, (var8.K[5][0].cx + 96), 123, var8.y.a(var8.y.arrItemBody, false), DataCenter.gI().i / 8 % 2, var8.y.m, false);
                        var8.y.b(var2, (var8.K[5][0].cx + 96), 68);
                     }

                     // Info Label (Underlined)
                     mFont.a(mFont.b, var2, Caption.db, (var8.K[5][0].cx + 96), 140, 2, -1, -10275328);
                     var2.f(-1);
                     var2.a((var8.K[5][0].cx + 96) - mFont.b(mFont.b, Caption.db) / 2, 144, (var8.K[5][0].cx + 96) + mFont.b(mFont.b, Caption.db) / 2, 144);
                  } catch (Exception var6) {
                     Utlis.println(var6);
                  }
                  break;
              case 1:
                int sub_tab = this.P_detu.b.b; 
                log("RENDER: Detu Potential, SubTab: " + sub_tab);
                
                var3 = this.b.c() + 2; // Exact MC horizontal anchor
                var4 = this.P_detu.cy + this.P_detu.height + 10;
                
                // Draw tabs relative to parent origin
                var2.a(-this.cx, -this.cy); 
                this.P_detu.a(var2);
                var2.a(this.cx, this.cy); 
                
                switch(sub_tab) {
                case 0:
                   // Points Tab - Fixed Labels and Layout
                   String[] rc_l = Caption.rc; 
                   int y_o = var4 + 10;
                   mFont.a(mFont.d, var2, rc_l[1], var3 + 6, y_o, 0, -1, 0); 
                   y_o += 25;
                   mFont.a(mFont.d, var2, rc_l[2], var3 + 6, y_o, 0, -1, 0);
                   y_o += 25;
                   mFont.a(mFont.d, var2, rc_l[3], var3 + 6, y_o, 0, -1, 0);
                   y_o += 25;
                   mFont.a(mFont.d, var2, rc_l[4], var3 + 6, y_o, 0, -1, 0);
                   mFont.a(mFont.d, var2, Caption.rc[0] + " " + this.y.diemTiemNang_d + Caption.dc, var3 + 6, this.b.cy + 7 + 23 + 135, 0, -1, 0);
                   // Draw "Hướng dẫn" (Guide) link for disciples
                   int guideX = var3 + 6;
                   int guideY = y_o + 21;
                   if (DataCenter.gI().i % 100 == 0) Utlis.writeLog("[DEBUG] Render Guide: x=" + guideX + " y=" + guideY + " sub_tab=" + sub_tab);
                   mFont.a(mFont.b, var2, Caption.dd, guideX, guideY, 0, -1, -6488);
                   var2.f(-1);
                   var2.a(guideX, guideY + 4, guideX + mFont.b(mFont.b, Caption.dd), guideY + 4);
                   break;
                case 1: // ThÃ´ng sá»‘
                case 2: // CÃ´ng
                case 3: // PhÃ²ng
                   int list_idx = sub_tab;
                   this.a(var2, (LangLa_ii)this.L[6][list_idx]);
                   
                   if (sub_tab == 1) { // ThÃ´ng sá»‘
                      for(int var10 = 0; var10 < Caption.rd.length; ++var10) {
                         int var11 = var10 * this.L[6][list_idx].h;
                         if (this.L[6][list_idx].c(var11)) {
                            if (this.L[6][list_idx].k == var10) {
                               var2.f(-6488);
                               var2.c(3, var11, this.L[6][list_idx].width - 9, this.L[6][list_idx].h);
                            }
                            if (var10 == 0) {
                               mFont.a(mFont.d, var2, Caption.rd[var10] + ": " + var8.y.w_d[var10] * 90 / 100 + " - " + var8.y.w_d[var10], 10, var11 + this.L[6][list_idx].h / 2, 0, -1, 0);
                            } else {
                               mFont.a(mFont.d, var2, Caption.rd[var10] + ": " + var8.y.w_d[var10] + (var10 != 5 && var10 != 16 ? "" : "%"), 10, var11 + this.L[6][list_idx].h / 2, 0, -1, 0);
                            }
                         }
                      }
                   } else if (sub_tab == 2) { // CÃ´ng
                      for(int var10 = 0; var10 < Caption.re.length; ++var10) {
                         int var11 = var10 * this.L[6][list_idx].h;
                         if (this.L[6][list_idx].c(var11)) {
                            if (this.L[6][list_idx].k == var10) {
                               var2.f(-6488);
                               var2.c(3, var11, this.L[6][list_idx].width - 9, this.L[6][list_idx].h);
                            }
                            if (var10 == 10) {
                               if (var8.y.idhe > 0) {
                                  mFont.a(mFont.d, var2, Caption.re[var10] + Caption.ro[var8.y.L() - 1] + ": " + var8.y.x_d[var10], 10, var11 + this.L[6][list_idx].h / 2, 0, -1, 0);
                               } else {
                                  mFont.a(mFont.d, var2, Caption.kl + ": " + var8.y.x_d[var10], 10, var11 + this.L[6][list_idx].h / 2, 0, -1, 0);
                               }
                            } else if (var10 == 11) {
                               if (var8.y.idhe > 0) {
                                  mFont.a(mFont.d, var2, Caption.re[var10] + Caption.ro[var8.y.M() - 1] + ": " + var8.y.x_d[var10], 10, var11 + this.L[6][list_idx].h / 2, 0, -1, 0);
                               } else {
                                  mFont.a(mFont.d, var2, Caption.km + ": " + var8.y.x_d[var10], 10, var11 + this.L[6][list_idx].h / 2, 0, -1, 0);
                               }
                            } else {
                               mFont.a(mFont.d, var2, Caption.re[var10] + ": " + var8.y.x_d[var10] + (var10 != 8 && var10 != 9 ? "" : "%"), 10, var11 + this.L[6][list_idx].h / 2, 0, -1, 0);
                            }
                         }
                      }
                   } else if (sub_tab == 3) { // PhÃ²ng
                      for(int var10 = 0; var10 < Caption.rf.length; ++var10) {
                         int var11 = var10 * this.L[6][list_idx].h;
                         if (this.L[6][list_idx].c(var11)) {
                            if (this.L[6][list_idx].k == var10) {
                               var2.f(-6488);
                               var2.c(3, var11, this.L[6][list_idx].width - 9, this.L[6][list_idx].h);
                            }
                            mFont.a(mFont.d, var2, Caption.rf[var10] + ": 0", 10, var11 + this.L[6][list_idx].h / 2, 0, -1, 0);
                         }
                      }
                   }
                   this.b(var2);
                   this.L[6][list_idx].b(var2, -17, -13);
                   break;
                }
                break;
             case 2:
                int var_x_d = this.gx_detu.c() + 8;
                int var_y_d = this.gx_detu.cy + 155;
                mFont.c(mFont.d, var1, Caption.rc[0] + " " + this.y.diemKyNang_d + Caption.dc, var_x_d, var_y_d, 0, -6488, 0);

                if (this.y.skills_d == null || this.y.skills_d.length == 0) {
                   mFont.a(mFont.d, var1, Caption.dg, 170, 100, 2, -1, 0);
                } else {
                   this.a((Graphics)var1, (LangLa_ii)this.L[7][0]);
                   for(int var3_idx = 0; var3_idx < this.y.skills_d.length; ++var3_idx) {
                      int var2_y = var3_idx * this.L[7][0].h;
                      if (this.L[7][0].c(var2_y)) {
                         if (this.L[7][0].k == var3_idx) {
                            this.a(var1, 0, var2_y + 1, this.L[7][0].width, 25, -15, 84, 5, 1, 1);
                         } else {
                            this.a(var1, 0, var2_y + 1, this.L[7][0].width, 25, -14, 84, 5, 1, 1);
                         }

                         mFont.a((mFont)mFont.e, (Graphics)var1, this.y.skills_d[var3_idx].getSkillTemplate().name, 35, var2_y + 8, 0, -7812062, 0);
                         if (this.y.skills_d[var3_idx].level == this.y.skills_d[var3_idx].getSkillTemplate().levelMax) {
                            mFont.a((mFont)mFont.d, (Graphics)var1, Caption.cY, 35, var2_y + 18, 0, -2560, 0);
                         } else {
                            mFont.a((mFont)mFont.d, (Graphics)var1, Caption.cZ + this.y.skills_d[var3_idx].level, 35, var2_y + 18, 0, -1, 0);
                         }

                         LangLa_fq.a(var1, this.y.skills_d[var3_idx].getSkillTemplate().idIcon, 0, 1, var2_y + 1, 20);
                      }
                   }
                   this.b(var1);
                   this.L[7][0].b(var1, -7, -6);
                }
                break;
             }
         } else if (this.k() == 3) { // Legacy check if any
            this.e(var1);
         }

      } catch (Exception var7) {
         Utlis.println(var7);
      }
   }

   private void e(Graphics var1) {
      int var2 = this.b.c() + 15;
      int var3 = this.b.cy + 7 + 18;
      if (!this.y.isMe() && this.B.a) {
         mFont.a((mFont)mFont.d, (Graphics)var1, Caption.dg, var2, var3, 0, -6488, 0);
      } else {
         mFont.c(mFont.d, var1, Caption.rc[0] + " " + this.v + Caption.dc, var2, this.a_() + this.G() - 16, 0, -1, 0);
         this.a((Graphics)var1, (LangLa_ii)this.N[0]);

         for(var3 = 0; var3 < this.z.length; ++var3) {
            var2 = var3 * this.N[0].h;
            if (this.N[0].c(var2)) {
               if (this.a == var3) {
                  this.a(var1, 28, var2 + 1, this.N[0].width - 29, 25, -15, 84, 5, 1, 1);
               } else {
                  this.a(var1, 28, var2 + 1, this.N[0].width - 29, 25, -14, 84, 5, 1, 1);
               }

               mFont.a((mFont)mFont.e, (Graphics)var1, this.z[var3].getSkillTemplate().name, 35, var2 + 8, 0, -7812062, 0);
               if (this.z[var3].level == this.z[var3].getSkillTemplate().levelMax) {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.cY, 35, var2 + 18, 0, -2560, 0);
               } else {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.cZ + this.z[var3].level, 35, var2 + 18, 0, -1, 0);
               }

               LangLa_fq.a(var1, this.z[var3].getSkillTemplate().idIcon, 0, 1, var2 + 1, 20);
            }
         }

         if (this.cL != null && this.cL instanceof LangLa_ie) {
            var2 = this.a * this.N[0].h;
            var1.f(-1);
            var1.b(0, var2, 26, 26);
         }

         this.b(var1);
         this.N[0].b(var1, -7, -6);
      }
   }

   private void f(Graphics var1) {
      this.gx_detu.c();
      int var10000 = this.gx_detu.cy + 7;
      this.a((Graphics)var1, (LangLa_ii)this.M[2]);

      for(int var3 = 0; var3 < this.M[2].i; ++var3) {
         int var2 = var3 * this.M[2].h;
         if (this.M[2].c(var2)) {
            if (this.M[2].k == var3) {
               var1.f(-6488);
               var1.c(3, var2, this.M[2].width - 9, this.M[2].h);
            }

            if (var3 == 10) {
               if (this.y.idhe > 0) {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.re[var3] + Caption.ro[this.y.L() - 1] + ": " + this.x[var3], 10, var2 + this.M[2].h / 2, 0, -1, 0);
               } else {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.kl + ": " + this.x[var3], 10, var2 + this.M[2].h / 2, 0, -1, 0);
               }
            } else if (var3 == 11) {
               if (this.y.idhe > 0) {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.re[var3] + Caption.ro[this.y.M() - 1] + ": " + this.x[var3], 10, var2 + this.M[2].h / 2, 0, -1, 0);
               } else {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.km + ": " + this.x[var3], 10, var2 + this.M[2].h / 2, 0, -1, 0);
               }
            } else {
               mFont.a((mFont)mFont.d, (Graphics)var1, Caption.re[var3] + ": " + this.x[var3] + (var3 != 8 && var3 != 9 ? "" : "%"), 10, var2 + this.M[2].h / 2, 0, -1, 0);
            }
         }
      }

      this.b(var1);
      this.M[2].b(var1, -17, -13);
   }

   private void g(Graphics var1) {
      this.a((Graphics)var1, (LangLa_ii)this.M[1]);

      for(int var3 = 0; var3 < Caption.rd.length; ++var3) {
         int var2 = var3 * this.M[1].h;
         if (this.M[1].c(var2)) {
            if (this.M[1].k == var3) {
               var1.f(-6488);
               var1.c(3, var2, this.M[1].width - 9, this.M[1].h);
            }

            if (var3 == 0) {
               mFont.a((mFont)mFont.d, (Graphics)var1, Caption.rd[var3] + ": " + this.w[var3] * 90 / 100 + " - " + this.w[var3], 10, var2 + this.M[1].h / 2, 0, -1, 0);
            } else {
               mFont.a((mFont)mFont.d, (Graphics)var1, Caption.rd[var3] + ": " + this.w[var3] + (var3 != 5 && var3 != 16 ? "" : "%"), 10, var2 + this.M[1].h / 2, 0, -1, 0);
            }
         }
      }

      this.b(var1);
      this.M[1].b(var1, -17, -13);
   }

   private void h(Graphics var1) {
      DataCenter.gI();
      int var2 = this.b.c() + 15;
      int var3 = this.b.cy + 7 + 18;
      if (!this.y.isMe() && this.B.a) {
         mFont.a((mFont)mFont.d, (Graphics)var1, Caption.dg, var2, var3, 0, -6488, 0);
      } else {
         mFont.c(mFont.d, var1, Caption.rc[0] + " " + this.v + Caption.dc, var2 - 7, var3 + 5 + 135, 0, -6488, 0);
         this.a((Graphics)var1, (LangLa_ii)this.L[3][0]);

         for(var3 = 0; var3 < this.z.length; ++var3) {
            var2 = var3 * this.L[3][0].h;
            if (this.L[3][0].c(var2)) {
               if (this.a == var3) {
                  this.a(var1, 28, var2 + 1, this.L[3][0].width - 29, 25, -15, 84, 5, 1, 1);
               } else {
                  this.a(var1, 28, var2 + 1, this.L[3][0].width - 29, 25, -14, 84, 5, 1, 1);
               }

               mFont.a((mFont)mFont.e, (Graphics)var1, this.z[var3].getSkillTemplate().name, 35, var2 + 8, 0, -7812062, 0);
               if (this.z[var3].level == this.z[var3].getSkillTemplate().levelMax) {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.cY, 35, var2 + 18, 0, -2560, 0);
               } else {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.cZ + this.z[var3].level, 35, var2 + 18, 0, -1, 0);
               }

               LangLa_fq.a(var1, this.z[var3].getSkillTemplate().idIcon, 0, 1, var2 + 1, 20);
            }
         }

         if (this.cL != null && this.cL instanceof LangLa_ie) {
            var2 = this.a * this.L[3][0].h;
            var1.f(-1);
            var1.b(0, var2, 26, 26);
         }

         this.b(var1);
      }
   }

   private void i(Graphics var1) {
      DataCenter.gI();
      this.P[1].a(var1);
      int var2;
      switch(this.P[1].b.b) {
      case 0:
         this.a((Graphics)var1, (LangLa_ii)this.L[this.b.b.b][this.P[1].b.b]);

         for(int var5 = 0; var5 < this.L[this.b.b.b][this.P[1].b.b].i; var5 += 2) {
            if (this.L[this.b.b.b][this.P[1].b.b].b(var5)) {
               var2 = var5 * this.L[this.b.b.b][this.P[1].b.b].h + this.L[this.b.b.b][this.P[1].b.b].h / 2;
               LangLa_fq.a(var1, 10, 0, 15, var2, 3);
               if (var5 / 2 == this.y.selectDanhHieu) {
                  LangLa_fq.a(var1, 11, 0, 15, var2, 3);
               }

               mFont.a((mFont)mFont.d, (Graphics)var1, this.y.aG[var5 / 2].a, 28, var2, 0, -6488, 0);
               mFont.a((mFont)mFont.d, (Graphics)var1, Caption.fw + (this.y.aG[var5 / 2].b == -1 ? Caption.ln : Utlis.f((long)this.y.aG[var5 / 2].b * 1000L)), 28, var2 + this.L[this.b.b.b][this.P[1].b.b].h, 0, -1, 0);
            }
         }

         this.b(var1);
         return;
      case 1:
         int var10003;
         Item var3;
         if ((var3 = this.y.arrItemBody[10]) == null || !var3.aa()) {
            this.S.b(true);
            this.T.b(true);
            this.U.b(true);
            mFont var10000 = mFont.e;
            String var10002 = Caption.qd;
            var10003 = 49 + (super.width - 8) / 2;
            DataCenter.gI();
            mFont.a(var10000, var1, var10002, var10003 - 0, this.a_() + this.G() / 2, 2, -2560, 2, 1, 3);
            return;
         }

         if (this.F == -1 || this.F >= this.y.aH.size()) {
            this.F = -1;
            this.S.b(true);
            this.T.b(true);
            this.U.b(true);
         }

         if (this.D != null) {
            this.a((Graphics)var1, (LangLa_ii)this.L[4][1]);

            for(var2 = 0; var2 < this.D.length; ++var2) {
               mFont.c(mFont.d, var1, this.D[var2], 8, var2 * this.L[4][1].h + 5, 0, -1, -16777216);
            }

            this.b(var1);
         }

         for(var2 = 0; var2 < 6; ++var2) {
            a(var1, this.K[this.b.b.b][0].cx + var2 * this.I, this.K[this.b.b.b][0].cy, this.y.arrItemSkillViThu[var2], var2 == this.K[this.b.b.b][0].k && this.E == 0, Caption.tl[var2]);
            if (var2 < this.G.size()) {
               var10003 = this.K[this.b.b.b][0].cx + var2 * this.I + 2;
               LangLa_fq.a(var1, ((SkillClan)this.G.elementAt(var2)).idIcon, 0, var10003, this.K[this.b.b.b][0].cy + 2, 20);
            }
         }

         if (this.H != null) {
            for(var2 = 0; var2 < this.K[this.b.b.b][1].r; ++var2) {
               a(var1, this.K[this.b.b.b][1].cx + var2 * this.I, this.K[this.b.b.b][1].cy, this.y.arrItemSkillViThu[var2], var2 == this.K[this.b.b.b][1].k && this.E == 1, Caption.tl[var2]);
               LangLa_fq.a(var1, this.H.idIcon, 0, this.K[this.b.b.b][1].cx + var2 * this.I + 2, this.K[this.b.b.b][1].cy + 2, 20);
            }
         }
      }

   }

   public void b() {
      super.b();
      if (this.y.sachChienDau > 0) {
         if (this.C == null) {
            this.C = new Item(435);
            this.C.strOptions = "207,0,-1;208,0,-1";
            this.C.a(this.y.sachChienDau);
            StringBuilder var10000;
            Item var10002;
            if (this.y.sachChienDau == 19) {
               this.C.strOptions = "207,2700,-1;208,1800,-1;311,500,-1;306,200,-1;68,30,-1;69,30,-1;70,30,-1;71,30,-1;72,30,-1";
            } else if (this.y.sachChienDau > 17) {
               var10000 = new StringBuilder();
               var10002 = this.C;
               var10002.strOptions = var10000.append(var10002.strOptions).append(";311,300,-1").toString();
               var10000 = new StringBuilder();
               var10002 = this.C;
               var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
               var10000 = new StringBuilder();
               var10002 = this.C;
               var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
            } else if (this.y.sachChienDau > 16) {
               var10000 = new StringBuilder();
               var10002 = this.C;
               var10002.strOptions = var10000.append(var10002.strOptions).append(";311,150,-1").toString();
            }

            int var10004 = this.b.c();
            DataCenter.gI();
            var10004 = var10004 + 10 + this.I;
            int var10005 = this.a_();
            DataCenter.gI();
            this.ae = new LangLa_ij((byte)1, var10004, var10005 + 11 + this.I * 2, this.I, this.I, this.I, 5, 1);
         }
      } else {
         this.C = null;
         this.ae = null;
      }
      
      if (this.b != null && this.K != null && this.K.length > 5) {
          // Master check: k() <= 1, slot K[0][10], item y.itemSach
          if (this.k() <= 1 && this.y != null && this.y.itemSach != null) {
             if (this.K[0] != null && this.K[0].length > 10 && this.K[0][10] == null) {
                int var2 = this.a_() + 11;
                // Align vertically with the costume slot.
                this.K[0][10] = new LangLa_ij((byte)1, this.K[0][3].cx, var2 + this.I * 2, this.I, this.I, this.I, 1, 1);
                if (this.K[1] != null && this.K[1].length > 10) this.K[1][10] = this.K[0][10];
             }
          } else if (this.K[0] != null && this.K[0].length > 10) {
             this.K[0][10] = null;
             if (this.K[1] != null && this.K[1].length > 10) this.K[1][10] = null;
          }

          // Disciple check: K[5][10], item y.bh_d.itemSach
          if (this.k() == 2 && this.y != null && this.y.bh_d != null && this.y.bh_d.itemSach != null) {
             if (this.K[5] != null && this.K[5].length > 10 && this.K[5][10] == null) {
                int var2 = this.a_() + 11;
                int offset_d = (this.gx_detu != null) ? this.gx_detu.c() : this.b.c();
                // Align vertically with the costume slot.
                this.K[5][10] = new LangLa_ij((byte)1, this.K[5][3].cx, var2 + this.I * 2, this.I, this.I, this.I, 1, 1);
             }
          } else if (this.K[5] != null && this.K[5].length > 10) {
             this.K[5][10] = null;
          }
       }

      boolean var1;
      if (this.v() && this.k() != 2) {
         var1 = false;
         this.B.v = var1;
      } else {
         var1 = true;
         this.B.v = var1;
      }

      if (this.v() && !this.t()) {
         this.Z.v = this.aa.v = this.ab.v = true;
         this.c[0].u = true;
      }

      int var3;
      if (this.k() == 0) {
         this.b.a();

         int var2;
         for(var3 = 0; var3 < this.K.length; ++var3) {
            if (this.K[var3] != null) {
               for(var2 = 0; var2 < this.K[var3].length; ++var2) {
                  if (this.K[var3][var2] != null) {
                     this.K[var3][var2].a();
                  }
               }
            }
         }

         if (this.G == null || (this.y != null && this.y.aH != null && this.G.size() + (this.H != null ? 1 : 0) != this.y.aH.size())) {
            this.g();
         }

         for(var3 = 0; var3 < this.L.length; ++var3) {
            if (this.L[var3] != null) {
               for(var2 = 0; var2 < this.L[var3].length; ++var2) {
                  if (this.L[var3][var2] != null) {
                     this.L[var3][var2].a();
                  }
               }
            }
         }
      } else if (this.k() == 1 && this.M != null) {
         for(var3 = 0; var3 < this.M.length; ++var3) {
            if (this.M[var3] != null) {
               this.M[var3].a();
            }
         }
      } else if (this.k() == 2) {
         if (this.gx_detu != null) {
            this.gx_detu.a();
         }

         if (this.L[6] != null) {
            for(var3 = 0; var3 < this.L[6].length; ++var3) {
               if (this.L[6][var3] != null) {
                  this.L[6][var3].a();
               }
            }
         }

         if (this.L[7] != null) {
            if (this.L[7][0] != null && this.y.skills_d != null) {
               this.L[7][0].i = this.y.skills_d.length;
            }
            for(var3 = 0; var3 < this.L[7].length; ++var3) {
               if (this.L[7][var3] != null) {
                  this.L[7][var3].a();
               }
            }
         }

         if (this.N != null) {
            for(var3 = 0; var3 < this.N.length; ++var3) {
               if (this.N[var3] != null) {
                  this.N[var3].a();
               }
            }
         }
      }

      this.w();
      int var10001;
      Step var4;
      int[] var5;
      switch(GameSrc.gI().Task) {
      case 0:
         if (GameSrc.gI().idStep == 0) {
            if (this.k() != this.j()) {
               DataCenter.gI();
               var10001 = this.cx + 135;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            } else if (this.cL == null) {
               if ((var5 = this.y.c(28)) == null) {
                  var5 = this.y.c(188);
               }

               if (this.cL == null && this.y.arrItemBody[1] == null) {
                  var10001 = this.cx + var5[0] + 15;
                  DataCenter.gI().aO.a(var10001, this.cy + 25 + var5[1] + 15);
                  DataCenter.gI().aO.a = true;
               }
            }
         }
      case 1:
      case 2:
      case 4:
      case 5:
      case 7:
      case 9:
      case 10:
      case 12:
      case 13:
      case 14:
      default:
         break;
      case 3:
         if (GameSrc.gI().idStep == 1) {
            var4 = GameSrc.gI().B();
            if (this.k() != this.j()) {
               DataCenter.gI();
               var10001 = this.cx + 135;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            } else if (this.cL == null && var4 != null) {
               var5 = this.y.c(var4.b());
               var10001 = this.cx + var5[0] + 15;
               DataCenter.gI().aO.a(var10001, this.cy + 25 + var5[1] + 15);
               DataCenter.gI().aO.a = true;
            }
         } else if (GameSrc.gI().idStep == 2) {
            DataCenter.gI().aO.a(this.cx + this.width - 5, this.cy + 5);
            DataCenter.gI().aO.a = true;
         }
         break;
      case 6:
         var4 = GameSrc.gI().B();
         if (GameSrc.gI().idStep >= 0 && var4 != null && Char.gI().cx == var4.x && Char.gI().cy == var4.y) {
            if (this.k() != this.j()) {
               DataCenter.gI();
               var10001 = this.cx + 135;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            } else if (this.cL == null && var4 != null) {
               var5 = this.y.c(var4.b());
               var10001 = this.cx + var5[0] + 15;
               DataCenter.gI().aO.a(var10001, this.cy + 25 + var5[1] + 15);
               DataCenter.gI().aO.a = true;
            }
         }
         break;
      case 8:
         if (GameSrc.gI().idStep == 9) {
            if (this.k() != this.j()) {
               DataCenter.gI();
               var10001 = this.cx + 135;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            } else if (this.cL == null) {
               var5 = this.y.u();
               var10001 = this.cx + var5[0] + 20;
               DataCenter.gI().aO.a(var10001, this.cy + 30 + var5[1] + 15);
               DataCenter.gI().aO.a = true;
            }
         } else if (GameSrc.gI().idStep == 10) {
            DataCenter.gI();
            if (this.k() == 0) {
               if (this.b.b.b != 2) {
                  var10001 = this.cx + 70;
                  DataCenter.gI().aO.a(var10001, this.cy + 120);
                  DataCenter.gI().aO.a = true;
               } else if (this.Q.u) {
                  var10001 = this.cx + 255;
                  DataCenter.gI().aO.a(var10001, this.cy + 100);
                  DataCenter.gI().aO.a = true;
               } else {
                  var10001 = this.cx + 255;
                  DataCenter.gI().aO.a(var10001, this.cy + 190);
                  DataCenter.gI().aO.a = true;
               }
            } else {
               var10001 = this.cx + 60;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            }

            if (this.cL != null) {
               DataCenter.gI().aO.a = false;
            }
         } else if (GameSrc.gI().idStep == 11) {
            DataCenter.gI();
            if (this.k() == 0) {
               if (this.b.b.b != 3) {
                  var10001 = this.cx + 70;
                  DataCenter.gI().aO.a(var10001, this.cy + 150);
                  DataCenter.gI().aO.a = true;
               } else if (this.Y.u) {
                  var10001 = this.cx + 280;
                  DataCenter.gI().aO.a(var10001, this.cy + 80);
                  DataCenter.gI().aO.a = true;
               } else {
                  var10001 = this.cx + 280;
                  DataCenter.gI().aO.a(var10001, this.cy + 190);
                  DataCenter.gI().aO.a = true;
               }

               if (this.cL != null) {
                  DataCenter.gI().aO.a = false;
               }
            } else {
               var10001 = this.cx + 60;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            }
         }
         break;
      case 11:
         var4 = GameSrc.gI().B();
         if (GameSrc.gI().idStep >= 0 && GameSrc.gI().idStep <= 3 && var4 != null && Char.gI().cx == var4.x && Char.gI().cy == var4.y) {
            if (this.k() != this.j()) {
               DataCenter.gI();
               var10001 = this.cx + 135;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            } else if (this.cL == null) {
               var5 = this.y.c(383);
               if (this.cL == null && this.y.arrItemBody[1] == null) {
                  var10001 = this.cx + var5[0] + 15;
                  DataCenter.gI().aO.a(var10001, this.cy + 25 + var5[1] + 15);
                  DataCenter.gI().aO.a = true;
               }
            }
         }
         break;
      case 15:
         var4 = GameSrc.gI().B();
         if (GameSrc.gI().idStep >= 0 && GameSrc.gI().idStep <= 3 && var4 != null && Char.gI().cx == var4.x && Char.gI().cy == var4.y) {
            if (this.k() != this.j()) {
               DataCenter.gI();
               var10001 = this.cx + 135;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            } else if (this.cL == null) {
               var5 = this.y.c(205);
               if (this.cL == null && this.y.arrItemBody[1] == null) {
                  var10001 = this.cx + var5[0] + 15;
                  DataCenter.gI().aO.a(var10001, this.cy + 25 + var5[1] + 15);
                  DataCenter.gI().aO.a = true;
               }
            }
         }
      }

      if (this.v()) {
         DataCenter.gI();
         if (this.y.idClass != 0 && this.i > 0) {
            this.b.c[2] = true;
         } else {
            this.b.c[2] = false;
         }

         if (this.y.idClass != 0 && this.v > 0) {
            this.b.c[3] = true;
         } else {
            this.b.c[3] = false;
         }
      }

      for(var3 = 0; var3 < this.c.length; ++var3) {
         this.c[var3].a(true);
      }

   }

   private void w() {
      this.S.b(true);
      this.T.b(true);
      this.U.b(true);
      if (this.k() == 0) {
         switch(this.b.b.b) {
         case 2:
            DataCenter.gI();
            this.z();
            break;
         case 3:
            this.y();
            break;
         case 4:
            this.x();
         default:
            return;
         }
      } else {
         if (this.k() == 2) {
            switch(this.gx_detu.b.b) {
            case 0:
               this.z();
               break;
            case 2:
               this.y_detu();
               break;
            default:
               return;
            }
         }

         if (this.k() == 3) {
            this.y();
         }
      }

   }

   private void x() {
      if (this.P != null && this.P[1] != null) {
         this.P[1].b();
      }

      if (this.y.isMe()) {
         DataCenter.gI();
         if (this.P != null && this.P[1] != null && this.P[1].b.b == 1 && this.F >= 0) {
            this.S.b(false);
            this.T.b(false);
            this.U.b(false);
            return;
         }
      } else {
         this.S.b(true);
         this.T.b(true);
         this.U.b(true);
      }

   }

   private void y() {
      this.J = 15;
      if (this.y.idClass != 0 && this.v()) {
         this.X.b(false);
         this.Y.b(false);
         if (this.a >= 0 && this.a < GameSrc.gI().p.length) {
            Skill var1;
            if ((var1 = GameSrc.gI().p[this.a]) == null) {
               return;
            }

            if (var1.level != 0 && var1.c()) {
               this.X.a(false);
               if (this.y.ay.idTemplate == var1.idTemplate) {
                  this.X.a(true);
               } else {
                  this.X.a(false);
               }
            } else {
               this.X.a(true);
            }

            if (this.v <= 0 || var1.level >= var1.getSkillTemplate().levelMax || b(var1.idTemplate, var1.level + 1).levelNeed > this.y.level()) {
               this.Y.a(true);
               return;
            }

            this.Y.a(false);
         } else {
            this.X.a(true);
            this.Y.a(true);
         }

      } else {
         this.X.b(true);
         this.Y.b(true);
      }
   }

   private void z() {
      if (this.P != null && this.P[0] != null) {
         this.P[0].b();
      }

      this.Q.u = true;
      this.R.u = true;
      if (this.d && (this.c[0].e() != this.e || this.c[1].e() != this.f || this.c[2].e() != this.h || this.c[3].e() != this.g)) {
         this.Q.u = false;
         this.R.u = false;
      }

   }

   public void a(int var1) {
      super.a(var1);
      if (this.b != null) {
         this.b.d();
      }

      if (this.gx_detu != null) {
         this.gx_detu.d();
      }

      // Always clean up P_detu interactives when switching panels
      if (this.P_detu != null) {
         this.P_detu.a();
      }
      if (this.P != null) {
         if (this.P[0] != null) this.P[0].a();
         if (this.P[1] != null) this.P[1].a();
      }

      if (var1 == 0 && this.b != null) {
         this.b.a(this.b.b.b);
         switch(this.b.b.b) {
         case 0:
            this.A.b(!this.y.isMe());
         case 1:
            this.e(this.b.b.b);
            break;
         case 2:
            this.P[0].a();
            this.A();
            break;
         case 4:
            this.P[1].a();
            this.B();
         case 3:
         default:
            return;
         }
      } else if (var1 == 2 && this.gx_detu != null) {
         this.gx_detu.a(this.gx_detu.b.b);
         this.gx_detu.a(false);
         if (this.P_detu != null) {
            this.P_detu.a(); // Always clear elements added blindly by gx_detu.a()
            if (this.gx_detu.b.b == 1) {
               this.P_detu.a(this.P_detu.b.b); // Restore only the ones active for the current inner tab
            }
         }
      }

   }

   public void e(int var1) {
      int var2;
      Item var3;
      if (var1 == 0) {
         for(var2 = 0; var2 < this.y.arrItemBody.length; ++var2) {
            if ((var3 = this.y.arrItemBody[var2]) != null && (var3.isTypeTrangBi() && var3.a(var1, this.y) > 0 || var3.getItemTemplate().type == 15)) {
               var3.c();
            }
         }

      } else {
         for(var2 = 0; var2 < this.y.arrItemBody2.length; ++var2) {
            if ((var3 = this.y.arrItemBody2[var2]) != null && (var3.isTypeTrangBi() && var3.a(var1, this.y) > 0 || var3.getItemTemplate().type == 15)) {
               var3.c();
            }
         }

      }
   }

   private void A() {
      this.P[0].a(this.P[0].b.b);
      switch(this.P[0].b.b) {
      case 0:
         return;
      case 1:
         this.L[this.b.b.b][0].d();
         return;
      case 2:
         this.L[this.b.b.b][1].d();
         return;
      case 3:
         this.L[this.b.b.b][2].d();
      default:
      }
   }

   private void B() {
      this.P[1].a(this.P[1].b.b);
   }

   private String j(int var1) {
      SkillClan var5;
      if (this.E == 0) {
         var5 = (SkillClan)this.G.elementAt(var1);
      } else {
         var5 = this.H;
      }

      Vector var2;
      (var2 = new Vector()).addElement("c#moc" + var5.name);
      if (var5.detail != null && var5.detail.length() > 0) {
         var2.addElement(var5.detail);
      }

      var2.addElement("c#green" + Caption.cV);
      var2.addElement("c#yellow" + Caption.cW + (var5.levelNeed + 1));
      a(var2, var5);
      Vector var6 = new Vector();

      String var3;
      for(int var4 = 0; var4 < var2.size(); ++var4) {
         var3 = String.valueOf(var2.elementAt(var4));
         if (var4 == 0) {
            var6.add(new LangLa_lk(0, var3));
         } else {
            var6.add(new LangLa_lk(1, var3));
         }
      }

      var3 = "";
      LangLa_lk[] var8 = new LangLa_lk[var6.size()];

      for(int var7 = 0; var7 < var6.size(); ++var7) {
         var8[var7] = (LangLa_lk)var6.elementAt(var7);
         var3 = var3 + var8[var7].b;
         if (var7 < var8.length - 1) {
            var3 = var3 + "\r\n";
         }
      }

      return var3;
   }

   public Vector c() {
      Vector var1 = super.c();
      if (!this.v()) {
         var1.removeElementAt(0);
      }

      DataCenter.gI();
      if (this.k() == 0) {
         var1.addElement(this.b.b());
         int var4;
         switch(this.b.b.b) {
         case 0:
            if (this.ae != null) {
               var1.addElement(this.ae.a(1090, this));
            }

            for(var4 = 0; var4 < this.K[this.b.b.b].length; ++var4) {
               if (this.K[this.b.b.b][var4] != null) {
                  var1.addElement(this.K[this.b.b.b][var4].a(1010 + var4, this));
               }
            }

            DataCenter.gI();
            DataCenter.gI();
            var1.addElement(new LangLa_jz(1026, 170, 135, 210, 145, (LangLa_ii)null, this));
            break;
         case 1:
             for(var4 = 0; var4 < this.K[this.b.b.b].length; ++var4) {
                if (this.K[this.b.b.b][var4] != null) {
                   var1.addElement(this.K[this.b.b.b][var4].a(1050 + var4, this));
                }
             }

            return var1;
         case 2:
            var1.addElement(this.P[0].c());
            var1.addElement(this.L[this.b.b.b][this.P[0].b.b].a(1200, this));
            break;
         case 3:
            if (this.y.isMe() || !this.y.isMe() && !this.B.a) {
               var1.addElement(this.L[3][0].a(1030, this));
            }
            break;
         case 4:
            var1.addElement(this.P[1].c());
            if (this.P[1].b.b == 0) {
               var1.addElement(this.L[this.b.b.b][this.P[1].b.b].a(1201, this));
            } else if (this.P[1].b.b == 1) {
               Item var2;
               if ((var2 = this.y.arrItemBody[10]) != null && var2.aa()) {
                  var1.addElement(this.K[this.b.b.b][0].a(1401, this));
                  if (this.H != null) {
                     var1.addElement(this.K[this.b.b.b][1].a(1403, this));
                  }
               }

               if (this.L[4][1] != null) {
                  var1.addElement(this.L[4][1].a(1402, this));
               }
            }
         }
      } else if (this.k() == 2) {
         int offset_d = this.gx_detu.c();
         var1.addElement(this.gx_detu.b());
          int var4_d;
          switch(this.gx_detu.b.b) {
          case 0:
             for(var4_d = 0; var4_d < this.K[5].length; ++var4_d) {
                if (this.K[5][var4_d] != null) {
                   var1.addElement(this.K[5][var4_d].a(1410 + var4_d, this));
                }
             }
             var1.addElement(new LangLa_jz(1426, 170, 135, 210, 145, (LangLa_ii)null, this));
             break;
          case 1:
             var1.addElement(this.P_detu.c());
             if (this.P_detu.b.b >= 0 && this.P_detu.b.b < this.L[6].length) {
                var1.addElement(this.L[6][this.P_detu.b.b].a(1500, this));
                if (this.P_detu.b.b == 0) {
                   // Add interactive area for "Hướng dẫn" link in Potential Points tab (ID 1026)
                   Utlis.writeLog("[DEBUG] C() Add Guide Link Area: (170, 135, 210, 145)");
                   var1.addElement(new LangLa_jz(1026, 170, 135, 210, 145, (LangLa_ii)null, this));
                }
             }
             break;
          case 2:
             if (this.L != null && this.L.length > 7 && this.L[7] != null && this.L[7][0] != null) {
                 var1.addElement(this.L[7][0].a(1206, this));
             }
             break;
          }
      }

      return var1;
   }

   public void a(mTextBox var1) {
      mTextBox var10000;
      int var2;
      
      // Handle main character potential points
      if (var1.equals(this.c[0])) {
         var10000 = this.c[0];
         var2 = this.c[0].e() + this.i;
         var10000.o = var2;
      } else if (var1.equals(this.c[1])) {
         var10000 = this.c[1];
         var2 = this.c[1].e() + this.i;
         var10000.o = var2;
      } else if (var1.equals(this.c[2])) {
         var10000 = this.c[2];
         var2 = this.c[2].e() + this.i;
         var10000.o = var2;
      } else if (var1.equals(this.c[3])) {
         var10000 = this.c[3];
         var2 = this.c[3].e() + this.i;
         var10000.o = var2;
      } 
      // Handle disciple potential points
      else if (this.c_detu != null) {
         for (int i = 0; i < 4; i++) {
            if (var1.equals(this.c_detu[i])) {
               int diff = Char.gI().diemTiemNang_d;
               this.c_detu[i].o = this.c_detu[i].e() + diff;
               break;
            }
         }
      }
   }

   public void refreshDisciplePotential() {
      if (this.c_detu == null) return;
      int[] spent = new int[4];
      int totalSpent = 0;
      for (int i = 0; i < 4; i++) {
         if (this.c_detu[i] != null) {
            spent[i] = this.c_detu[i].e() - this.c_detu[i].n;
            if (spent[i] < 0) spent[i] = 0;
            totalSpent += spent[i];
         }
      }
      for (int i = 0; i < 4; i++) {
         if (this.c_detu[i] != null) {
            this.c_detu[i].n = this.y.arrayTiemNang_d[i];
            this.c_detu[i].a("" + (this.y.arrayTiemNang_d[i] + spent[i]));
            this.c_detu[i].o = this.y.arrayTiemNang_d[i] + this.y.diemTiemNang_d + spent[i];
         }
      }
      if (totalSpent <= this.y.diemTiemNang_d) {
         this.y.diemTiemNang_d = this.y.diemTiemNang_d - totalSpent;
      }
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      super.a(var1, var2, var3);

      try {
         Message var5;
         switch(var1) {
         case 1234:
            (var5 = Message.c((byte)-109)).writeBoolean(this.B.a);
            var5.send();
            break;
         case 1235:
            (var5 = Message.c((byte)-58)).writeByte(this.A.b.b);
            var5.send();
         default:
            return;
         }
      } catch (Exception var4) {
      }

   }

   public void b(mTextBox var1) {
      int var2;
      if ((var2 = var1.e()) > var1.o) {
         var1.a("" + var1.o);
      }

      if (var2 < var1.n) {
         var1.a("" + var1.n);
      }

      this.i = this.u - (this.c[0].e() - this.e + (this.c[1].e() - this.f) + (this.c[2].e() - this.h) + (this.c[3].e() - this.g));
   }

   private static Skill b(int var0, int var1) {
      for(int var2 = 0; var2 < DataCenter.gI().Skill.length; ++var2) {
         if (DataCenter.gI().Skill[var2].idTemplate == var0 && DataCenter.gI().Skill[var2].level == var1) {
            return DataCenter.gI().Skill[var2];
         }
      }

      return null;
   }

   public boolean f(int var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < this.y.arrItemBody.length; ++var3) {
         if (this.y.arrItemBody[var3] != null && this.y.arrItemBody[var3].v() && this.y.arrItemBody[var3].level >= var1) {
            ++var2;
         }
      }

      if (var2 >= 10) {
         return true;
      } else {
         return false;
      }
   }

   private void y_detu() {
      if (this.v()) {
         this.X_detu.b(false);
         this.Y_detu.b(false);
         if (this.a >= 0 && this.y.skills_d != null && this.a < this.y.skills_d.length) {
            Skill var1;
            if ((var1 = this.y.skills_d[this.a]) == null) {
               return;
            }

            if (var1.level != 0 && var1.c()) {
               this.X_detu.a(false);
               if (this.y.ay_d != null && this.y.ay_d.idTemplate == var1.idTemplate) {
                  this.X_detu.a(true);
               } else {
                  this.X_detu.a(false);
               }
            } else {
               this.X_detu.a(true);
            }

            if (this.y.diemKyNang_d <= 0 || var1.level >= var1.getSkillTemplate().levelMax || b(var1.idTemplate, var1.level + 1).levelNeed > this.y.level_d()) {
               this.Y_detu.a(true);
               return;
            }

            this.Y_detu.a(false);
         } else {
            this.X_detu.a(true);
            this.Y_detu.a(true);
         }

      } else {
         this.X_detu.b(true);
         this.Y_detu.b(true);
      }
   }

   public void refreshDiscipleSkills() {
      if (this.L != null && this.L.length > 7 && this.L[7] != null && this.L[7][0] != null) {
         this.L[7][0].a(1, 26, this.y.skills_d != null ? this.y.skills_d.length : 0);
      }
   }

   public void openDiscipleSkillDetail() {
      log("[openDiscipleSkillDetail] Called, a_detu=" + this.a_detu + " skills_d=" + (this.y.skills_d != null ? this.y.skills_d.length : "null"));
      if (this.a_detu >= 0 && this.y.skills_d != null && this.a_detu < this.y.skills_d.length) {
         String detail = this.b_d(this.a_detu);
         log("[openDiscipleSkillDetail] detail length=" + (detail != null ? detail.length() : 0));
         if (detail != null && detail.length() > 0) {
            int x = this.b.c() + 27;
            int y = 50; 
            boolean isMe = this.y.isMe();
            boolean isAddEnabled = !this.X_detu.u;
            boolean isSelectEnabled = !this.Y_detu.u;
            
            LangLa_ie popup = new LangLa_ie(x, y, 220, this, detail, isAddEnabled, isSelectEnabled, isMe);
            if (popup.cx > DataCenter.gI().widthScreen - popup.width - super.cx) {
               popup.cx = (short)(DataCenter.gI().widthScreen - popup.width - super.cx);
            }
            if (popup.cy > DataCenter.gI().heightScreen - popup.height - super.cy) {
               popup.cy = (short)(DataCenter.gI().heightScreen - popup.height - super.cy);
            }
            this.a(popup);
            this.cL = popup;
            log("[openDiscipleSkillDetail] Popup opened!");
         }
         this.a_detu = -1; 
      }
   }
}
