package beatdz;

/** Compatibility entry point; every purchase uses the same price/total/balance dialog. */
public final class LucDaoExchangeDialog extends LangLa_lv {
    public LucDaoExchangeDialog(MainScreen parent, Item item) { super(parent,item,(byte)105); }
    public static long cardCount() { return ShopCurrency.count(Char.gI().arrItemBag,ShopCurrency.LUC_DAO_CARD); }
}
