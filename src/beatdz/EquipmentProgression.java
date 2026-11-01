package beatdz;

/** Equipment tiers retain earlier bonuses, so the highest marker determines the cap. */
public final class EquipmentProgression {
    public static final int LUC_DAO=361, VO_CUC=380, THIEN_DAO=379;
    private EquipmentProgression() {}
    public static boolean has(String options,int marker) {
        if(options==null) return false;
        for(String part:options.split(";")) if(part.split(",",2)[0].trim().equals(String.valueOf(marker))) return true;
        return false;
    }
    public static int cap(String options) {
        return has(options,VO_CUC)?35:has(options,THIEN_DAO)?25:has(options,LUC_DAO)?19:-1;
    }
    public static boolean canPromote(String options,int level,int target) {
        if(target==THIEN_DAO) return cap(options)==19 && level==19;
        if(target==VO_CUC) return cap(options)==25 && level==25;
        return target==LUC_DAO && level>=0 && level<=19 && cap(options)<0 &&
            (has(options,159)||has(options,163)||has(options,164)||has(options,165));
    }
    public static String requirement(int target) {
        return target==THIEN_DAO?"Cần trang bị Lục Đạo +19":target==VO_CUC?"Cần trang bị Thiên Đạo +25":"Cần trang bị Hiền Nhân";
    }
    public static int extraGems(int target) { return target==VO_CUC?4000:target==THIEN_DAO?2000:0; }
    public static int extraSilver(int target) { return target==VO_CUC?200000000:target==THIEN_DAO?100000000:0; }
    public static int gemId(int type) { return type==0||type==4||type==3?567:type==8||type==2||type==7?565:type==6||type==5||type==9?563:353; }
    public static int kyLanEvent(int choice) { return choice==1?117:choice==2?118:-1; }
}
