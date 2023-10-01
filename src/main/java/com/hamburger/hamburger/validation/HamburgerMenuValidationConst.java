package com.hamburger.hamburger.validation;

public class HamburgerMenuValidationConst {

    /**
     * 圖片名稱:輸入""," ",不提交時提示的訊息
     */
    public static final String NOT_BLANK_MESSAGE_COMMODITY = "請上傳有效的圖片名稱";



    /**
     * 餐點單價正則判斷失敗時提示的錯誤訊息
     */
    public static final String POSITVE_MESSAGE_UNITPRICE = "餐點單價只可以輸入正整數";



    /**
     *數量錯誤訊息
     */
    public static final String MAX_MESSAGE_VALUE_QUANTITY = "數量格式錯誤,請稍後再試";

    /**
     *數量錯誤訊息
     */
    public static final String MIN_MESSAGE_VALUE_QUANTITY = "數量格式錯誤,請稍後再試";



    /**
     * 總價錯誤訊息
     */
    public static final String POSITVE_MESSAGE_TOTAL = "餐點總價只可以輸入正整數";



    /**
     * 訂單編號錯誤訊息
     */
    public static final String POSITVE_MESSAGE_ORDERNUMBER = "訂單編號只可以輸入正整數";



    /**
     * 訂單時間:輸入""," ",不提交時提示的訊息
     */
    public static final String NOT_BLANK_MESSAGE_SCHEDULE = "訂單時間格式錯誤,請重新填寫";



    /**
     * 訂單日期:輸入""," ",不提交時提示的訊息
     */
    public static final String NOT_BLANK_MESSAGE_TODAY = "訂單日期格式錯誤,請重新填寫";

}
