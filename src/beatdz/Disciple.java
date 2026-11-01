package beatdz;

import java.io.IOException;

public class Disciple {
    public String name;
    public byte idChar;
    public byte idhe;
    public byte gioiTinh;
    public byte idClass;
    public int hp;
    public int hpFull;
    public int mp;
    public int mpFull;
    public long exp;
    public Item[] arrItemBody;
    public int diemTiemNang;
    public int diemKyNang;
    public int[] arrayTiemNang = new int[4];
    public Skill[] arraySkill;

    public void read(Message msg) throws IOException {
        this.name = msg.readUTF();
        this.idhe = msg.readByte();
        this.gioiTinh = msg.readByte();
        this.idClass = msg.readByte();
        this.hp = msg.readInt();
        this.hpFull = msg.readInt();
        this.mp = msg.readInt();
        this.mpFull = msg.readInt();
        this.exp = msg.readLong();

        byte bodyLen = msg.readByte();
        this.arrItemBody = new Item[bodyLen];
        for (int i = 0; i < bodyLen; i++) {
            if (msg.readBoolean()) {
                Item item = new Item();
                item.read(msg);
                item.index = (byte) i;
                this.arrItemBody[i] = item;
            }
        }

        this.diemTiemNang = msg.readInt();
        this.diemKyNang = msg.readInt();
        for (int i = 0; i < this.arrayTiemNang.length; i++) {
            this.arrayTiemNang[i] = msg.readInt();
        }

        byte skillLen = msg.readByte();
        this.arraySkill = new Skill[skillLen];
        for (int i = 0; i < skillLen; i++) {
            if (msg.readBoolean()) {
                short idTemplate = msg.readShort();
                byte level = msg.readByte();
                // Create Skill object if needed, or just store IDs
                if (DataCenter.gI().Skill != null && idTemplate < DataCenter.gI().Skill.length) {
                    this.arraySkill[i] = DataCenter.gI().getSkillWithIdAndLevel(idTemplate, level);
                }
            }
        }
    }
}
