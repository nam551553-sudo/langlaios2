package beatdz;

import java.util.Vector;

/** Noel recipes and exchanges use the existing NPC commands; rewards stay server-authoritative. */
public final class SeasonalEventDialog extends LangLa_fo {
    private static final String[] TABS={"Chế tạo","Đổi quà","N.vụ","H.dẫn","BXH"};
    static final int[] REWARDS={435,437,530,1225,1226,947};
    static final int[] PRICES={800,1000,2000,5000,7000,8000};
    private final short npc;
    private final Vector contentButtons=new Vector();
    private int tab,quantity,top,scroll,pressY,pressScroll;
    private boolean listPress,dragged;
    private boolean pressedAction;
    private int pressedReward = -1;
    private int flashedReward = -1;
    private long flashUntil;
    private String points="—";
    private long spendPoints=-1;
    private String[] ranking={"Đang tải bảng xếp hạng…"};
    private final int[] amounts={1,10,100};

    public static boolean matches(String[] menu) {
        // Only replace the audited seven-entry Noel menu. Other events retain their own menu.
        return menu!=null && menu.length==7 && menu[0].startsWith("Làm vớ,")
                && menu[1].startsWith("Làm găng tay,") && menu[2].startsWith("Nhận nhiệm vụ,")
                && menu[3].startsWith("BXH Top Làm Vớ") && menu[4].startsWith("Kiểm tra điểm")
                && menu[5].startsWith("Đổi điểm,") && menu[6].trim().equals("sách");
    }

    public SeasonalEventDialog(MainScreen parent,short npc,String[] menu) {
        this.p=parent;this.npc=npc;
        this.a(dialogWidth(DataCenter.gI().widthScreen),dialogHeight(DataCenter.gI().heightScreen));
        int columns=TABS.length;
        int tw=(width-16)/columns;
        for(int i=0;i<TABS.length;i++) {
            LangLa_dz button=this.a(8+i%columns*tw,30+i/columns*20,TABS[i],this,100+i,7);
            button.setSize(tw-2,19);
        }
        top=51;
        rebuild();
    }

    static int dialogWidth(int screen) { return Math.min(screen-12,Math.max(220,screen*68/100)); }
    static int dialogHeight(int screen) { return Math.min(screen-12,Math.max(190,screen*82/100)); }
    private void button(int x,int y,int w,String label,int action) {
        LangLa_dz button=this.a(x,y,label,this,action,7);
        button.setSize(w,20);contentButtons.addElement(button);
    }
    private int count() {return tab==0?2:tab==1?REWARDS.length:tab==2?4:tab==3?3:ranking.length;}
    private int rowHeight(int row) {
        if(tab==4)return 22;
        return tab==0 ? 52 : 43;
    }
    private int listBottom() { return height-29; }
    private int maxScroll() {
        int size=0;
        for(int i=0;i<count();i++)size+=rowHeight(i);
        return Math.max(0,size-(listBottom()-top));
    }
    private void scrollTo(int position) { scroll=Math.max(0,Math.min(maxScroll(),position)); }
    private void rebuild() {
        for(Object button:contentButtons)cG.removeElement(button);
        contentButtons.removeAllElements();
        if(tab==0)button(10,height-25,68,"Số: x"+amounts[quantity],260);
        else if(tab==1 || tab==4)button(10,height-25,68,"Xem điểm",251);
    }
    private void text(Graphics g,String s,int x,int y) {
        mFont.c(mFont.d,g,s,x,y,0,-1,-16777216);
    }
    private void center(Graphics g,String s,int x,int y) {
        mFont.c(mFont.d,g,s,x,y,2,-1,-16777216);
    }
    static String exact(long number) {
        return String.format(java.util.Locale.US,"%,d",number).replace(',','.');
    }
    private String name(int id) {
        ItemTemplate[] items=DataCenter.gI().ItemTemplate;
        return items!=null && id<items.length && items[id]!=null?items[id].name:"Vật phẩm "+id;
    }
    private String fit(String s,int limit) {
        if(mFont.c(mFont.d,s)<=limit)return s;
        while(s.length()>0 && mFont.c(mFont.d,s+"...")>limit)s=s.substring(0,s.length()-1);
        return s+"...";
    }
    private void icon(Graphics g,int id,int x,int y) {
        ItemTemplate[] items=DataCenter.gI().ItemTemplate;
        g.f(0x65431e);g.c(x-10,y-10,20,20);
        g.f(0xc6a069);g.b(x-10,y-10,20,20);
        int icon=id==1225?32132:id==1226?1071:
                items!=null && id<items.length && items[id]!=null?items[id].idIcon:-1;
        if(icon>=0) ItemIcons.draw(g,icon,x,y,18);
    }
    private void recipe(Graphics g,int y,int result) {
        int n=amounts[quantity],step=Math.max(27,Math.min(45,(width-72)/4));
        int start=24;
        for(int i=0;i<3;i++) {
            int x=start+i*step;
            icon(g,792+i,x,y+28);
            text(g,exact(5L*n),x+9,y+26);
            center(g,"("+exact(ShopCurrency.count(Char.gI().arrItemBag,792+i))+")",x,y+40);
            center(g,i==2?"=":"+",x+step/2,y+21);
        }
        icon(g,result,start+step*3,y+28);
    }
    public void a(Graphics g) {
        this.a(g,cx,cy,width,height,"Sự kiện Noel - "+TABS[tab],(byte)2,false);
        if (tab == 1) {
            drawExchange(g);
            this.b(g);
            return;
        }
        g.setClip(8,top,width-16,listBottom()-top);
        int nextY=top-scroll;
        for(int i=0;i<count();i++) {
            int y=nextY;
            nextY+=rowHeight(i);
            if(nextY<=top || y>=listBottom())continue;
            g.f(0x995523);g.c(8,y,width-19,rowHeight(i)-3);
            g.f(0xc9975c);g.b(8,y,width-19,rowHeight(i)-3);
            if(tab==0) {
                int amount=amounts[quantity];
                String cost=i==0?exact(30L*amount)+" vàng":exact(80000L*amount)+" bạc";
                text(g,fit(name(795+i)+" - "+cost,width-24),14,y+3);
                recipe(g,y,795+i);
            } else if(tab==2) {
                String[] labels={"Giết cương thi - 1.000 vàng","Phong ấn: 70 vớ khóa + 100 điểm","Hủy nhiệm vụ đang nhận","Hướng dẫn nhiệm vụ"};
                center(g,fit(labels[i],width-105),(width-72)/2,y+21);
            } else if(tab==3) {
                String[] labels={"Làm vớ: 5 + 5 + 5 nguyên liệu, 30 vàng","Làm găng: 5 + 5 + 5, 80.000 bạc","Nhiệm vụ và phong ấn cương thi"};
                center(g,fit(labels[i],width-105),(width-72)/2,y+21);
            } else {
                mFont.b(mFont.d,g,fit(ranking[i],width-30),width/2,y+10,2,-1,-16777216);
            }
            if(tab!=4) {
                boolean down=pressedAction && !dragged && pressY-cy>=y+16 && pressY-cy<y+35;
                Binary2.a(g,down?370:7,0,width-58,y+16,42,19);
                mFont.b(mFont.d,g,tab==0?"Làm x"+amounts[quantity]:tab==1?"Đổi":tab==2?"Chọn":"Xem",
                        width-37,y+25,2,down?-3089954:-1,0);
            }
        }
        g.setClip(-cx,-cy,DataCenter.gI().widthScreen,DataCenter.gI().heightScreen);
        if(tab==1 || tab==4)text(g,fit(points,width-87),81,height-20);
        this.b(g);
    }
    private int exchangeCellWidth() { return (width - 18) / 3; }

    private void drawExchange(Graphics g) {
        int cell = exchangeCellWidth();
        for (int i = 0; i < REWARDS.length; i++) {
            int x = 9 + (i % 3) * cell, y = top + (i / 3) * 51;
            g.f(0x995523);
            g.c(x, y, cell - 3, 48);
            g.f(0xc9975c);
            g.b(x, y, cell - 3, 48);
            icon(g, REWARDS[i], x + 15, y + 15);
            int buttonX = x + 29, buttonWidth = exchangeButtonWidth();
            text(g, fit("Giá: " + exact(PRICES[i]) + " điểm", cell - 34), buttonX, y + 7);
            boolean down = pressedReward == i && !dragged
                    || flashedReward == i && System.currentTimeMillis() < flashUntil;
            Binary2.a(g, down ? 370 : 7, 0, buttonX, y + 15, buttonWidth, 19);
            center(g, "Đổi", buttonX + buttonWidth / 2, y + (down ? 25 : 24));
            text(g, fit(name(REWARDS[i]), cell - 8), x + 4, y + 40);
        }
        text(g, fit(points, width - 87), 81, height - 20);
    }

    private int exchangeButtonWidth() {
        return Math.max(25, (exchangeCellWidth() - 36) / 2);
    }

    private int exchangeRewardAt(int x, int y) {
        int columnX = x - cx - 9, rowY = y - cy - top;
        int cell = exchangeCellWidth();
        if (columnX < 0 || columnX >= 3 * cell || rowY < 0 || rowY >= 102
                || columnX % cell >= cell - 3 || rowY % 51 >= 48) return -1;
        return rowY / 51 * 3 + columnX / cell;
    }

    private boolean exchangeButtonAt(int x, int y) {
        if (exchangeRewardAt(x, y) < 0) return false;
        int columnX = (x - cx - 9) % exchangeCellWidth();
        int rowY = (y - cy - top) % 51;
        return columnX >= 29 && columnX < 29 + exchangeButtonWidth() && rowY >= 15 && rowY < 34;
    }

    private void showOptions(int reward) {
        String[] options={
                "172,10;173,400;174,8;209,94",
                "69,30;71,30;332,15;0,2000;2,200;4,200;5,200;209,150;306,20;173,500",
                "71,30;72,30;70,30;332,40;0,5000;2,200;4,300;5,300;209,200;306,20;122,15"};
        StringBuilder details = new StringBuilder(name(REWARDS[reward]));
        ItemOptionTemplate[] templates = DataCenter.gI().ItemOptionTemplate;
        for (String encoded : options[reward - 2].split(";")) {
            ItemOption option = new ItemOption(encoded);
            if (templates != null && option.d() < templates.length && templates[option.d()] != null) {
                details.append('\n').append(option.a(0));
            }
        }
        GameSrc.gI().l(details.toString());
    }
    public void f(int x,int y) {
        listPress=x>=cx+8 && x<cx+width-8 && y>=cy+top && y<cy+listBottom();
        dragged=false;
        pressedAction=listPress && x-cx>=width-58 && x-cx<width-16;
        pressedReward = tab == 1 && listPress && exchangeButtonAt(x, y) ? exchangeRewardAt(x, y) : -1;
        pressY=y;
        pressScroll=scroll;
        if(!listPress)super.f(x,y);
    }
    public void h(int x,int y) {
        if(!listPress){super.h(x,y);return;}
        if(Math.abs(y-pressY)>4)dragged=true;
        if(dragged && tab != 1)scrollTo(pressScroll+pressY-y);
    }
    public void g(int x,int y) {
        if(!listPress){super.g(x,y);return;}
        listPress=false;
        int rewardPressed = pressedReward;
        pressedReward = -1;
        boolean actionPress=pressedAction;
        pressedAction=false;
        int localY=y-cy;
        if(dragged || x<cx+8 || x>=cx+width-8 || localY<top || localY>=listBottom())return;
        if (tab == 1) {
            int reward = exchangeRewardAt(x, y);
            if (reward >= 0 && reward == rewardPressed && exchangeButtonAt(x, y)) {
                flashedReward = reward;
                flashUntil = System.currentTimeMillis() + 130;
                action(210 + reward);
            } else if (rewardPressed < 0 && reward >= 2 && reward <= 4 && !exchangeButtonAt(x, y)) {
                showOptions(reward);
            }
            return;
        }
        int start=top-scroll;
        for(int i=0;i<count();i++){
            if(actionPress && x-cx>=width-58 && x-cx<width-16 && localY>=start+16 && localY<start+35){
                if(tab==0)action(200+i);
                if(tab==1)action(210+i);
                if(tab==2)action(230+i);
                if(tab==3)action(240+i);
                return;
            }
            start+=rowHeight(i);
        }
    }
    static Message command(short npc,int choice,int sub) throws java.io.IOException {
        Message message=new Message((byte)53);message.writeShort(npc);message.writeByte(choice);
        if(sub>=0)message.writeByte(sub);
        return message;
    }
    private void send(int choice,int sub) {
        try {command(npc,choice,sub).send();}catch(Exception ex){GameSrc.gI().l("Không gửi được yêu cầu, vui lòng thử lại.");}
    }
    private void action(int id) {
        if(id>=100 && id<100+TABS.length){
            tab=id-100;scroll=0;rebuild();
            if(tab==4)send(3,-1);
            if(tab==1 || tab==4)send(4,-1);
        }
        else if(id==260){quantity=(quantity+1)%3;rebuild();}
        else if(id>=200 && id<202)send(id-200,quantity);
        else if(id>=210 && id<216){send(5,id-210);send(4,-1);}
        else if(id>=230 && id<234)send(2,id-230);
        else if(id>=240 && id<243)send(id-240,3);
        else if(id==250)send(3,-1);
        else if(id==251)send(4,-1);
    }
    boolean receive(String title,String[] lines) {
        if(title.trim().equals("Bảng xếp hạng SK")) {
            java.util.ArrayList<String> entries=new java.util.ArrayList<>();
            for(String line:lines)if(!line.trim().isEmpty())entries.add(line.trim());
            ranking=entries.isEmpty()?new String[]{"Chưa có người chơi."}:entries.toArray(new String[0]);
            if(tab==4)scrollTo(scroll);
            return true;
        }
        if(title.trim().equals("Bảng điểm SK của bạn:")) {
            StringBuilder label=new StringBuilder();
            for(String line:lines) {
                java.util.regex.Matcher number=java.util.regex.Pattern.compile("-?\\d+").matcher(line);
                if(!number.find())continue;
                if(line.contains("tiêu xài"))spendPoints=Long.parseLong(number.group());
                if(label.length()>0)label.append("  ·  ");
                label.append(line.substring(0,number.start()).trim()).append(' ').append(exact(Long.parseLong(number.group())));
            }
            points=label.length()==0?"—":label.toString();
            return true;
        }
        return false;
    }
    public void a(LangLa_jz event,int x,int y){action(event.b);}
    public void a(int id,Object value,LangLa_cy source){action(id);}
    public void a(int id,Object value){action(id);}
    public void b(){}
}
