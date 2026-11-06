package beatdz;

/** Item currency is explicit shop metadata, independent of the price's wire field. */
public final class ShopCurrency {
    public static final int LUC_DAO_CARD=548;
    public static final byte FISHING_SHOP = 106;
    public static final byte FISHING_BALANCE_UPDATE = 120;
    public static final int ANGLER_CARD = 615;
    private ShopCurrency() {}
    public static boolean isExchange(Item item) { return item.exchangeItemId >= 0; }
    public static long count(Item[] inventory,int itemId) {
        long total=0;
        if(inventory!=null) for(Item item:inventory)
            if(item!=null && item.id==itemId && item.getAmount()>0) total+=item.getAmount();
        return total;
    }
    public static int icon(Item item) {
        return DataCenter.gI().ItemTemplate[item.exchangeItemId].idIcon;
    }
    public static String name(Item item) { return item.exchangeItemId == ANGLER_CARD ? "Thẻ Cần Thủ" : "Thẻ Lục Đạo"; }
    public static long balance(Item item) { return count(Char.gI().arrItemBag,item.exchangeItemId); }
}

