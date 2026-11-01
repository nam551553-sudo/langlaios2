package beatdz;import beatdz.*;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;

public class Reader {
   public DataInputStream dis = null;

   public Reader(DataInputStream var1) {
      this.dis = var1;
   }

   public Reader(InputStream var1) {
      this.dis = new DataInputStream(var1);
   }

   public Reader(byte[] var1) {
      this.dis = new DataInputStream(new ByteArrayInputStream(var1));
   }

   public short readUnsignedByte() throws java.io.IOException {
      return (short)this.dis.readUnsignedByte();
   }

   public byte[] read() throws java.io.IOException {
      byte[] var1 = new byte[this.dis.readInt()];
      this.dis.readFully(var1);
      return var1;
   }

   public byte[] read(byte[] var1, int var2, int var3)  throws java.io.IOException{
      this.dis.readFully(var1, var2, var3);
      return var1;
   }

   public byte[] readFully()  throws java.io.IOException{
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      byte[] buffer = new byte[4096];
      int count;
      while ((count = this.dis.read(buffer)) != -1) output.write(buffer, 0, count);
      return output.toByteArray();
   }

   public String readUTF() throws java.io.IOException {
      short var1;
      if ((var1 = (short)this.dis.readUnsignedByte()) == 0) {
         return this.dis.readUTF();
      } else {
         String var2 = "";

         try {
            for(int var3 = 0; var3 < var1; ++var3) {
               int charIndex = this.dis.readUnsignedByte();
               if (charIndex >= 0 && charIndex < mFont.k.length()) {
                  var2 = var2 + mFont.k.charAt(charIndex);
               }
            }
         } catch (Exception e) {
         }

         return var2;
      }
   }

   public void close() {
      try {
         if (this.dis != null) {
            this.dis.close();
         }

      } catch (Exception var1) {
      }
   }
}
