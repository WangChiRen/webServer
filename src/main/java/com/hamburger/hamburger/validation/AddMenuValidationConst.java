package com.hamburger.hamburger.validation;

public class AddMenuValidationConst {

    /**
     * 圖片名稱:輸入""," ",不提交時提示的訊息
     */
    public static final String NOT_BLANK_MESSAGE_COMMODITY = "請上傳有效的圖片名稱";

    /**
     * 餐點名稱:輸入""," ",不提交時提示的訊息
     */
    public static final String NOT_BLANK_MESSAGE_MEALS = "請填寫有效的餐點名稱";

    /**
     * 判斷餐點名稱不可超過的字符數
     */
    public static final String PATTERN_REGEXP_MEALS = "^.{1,20}$";

    /**
     * 餐點名稱超過字符數時提示的錯誤訊息
     */
    public static final String PATTERN_MESSAGE_MEALS = "餐點描述最多不可超過20個字符";



    /**
     * 餐點單價正則判斷失敗時提示的錯誤訊息
     */
    public static final String POSITVE_MESSAGE_UNITPRICE = "餐點單價只可以輸入正整數";



    /**
     * 餐點推薦指數的數值判斷(最大值)
     */
    public static final String DECIMAL_MAX_VALUE_RECOMMEND = "5.0";

    /**
     * 餐點推薦指數的數值判斷(最小值)
     */
    public static final String DECIMAL_MIN_VALUE_RECOMMEND = "0.0";

    /**
     * 餐點推薦指數判斷失敗時提示的錯誤訊息
     */
    public static final String DECIMAL_MAX_AND_DECIMAL_MIN_MESSAGE_RECOMMEND = "請檢查數值是否有誤，數值必須是5.0以下";

    /**
     * 餐點推薦指數判斷失敗時提示的錯誤訊息
     */
    public static final String DECIMAL_MIN_AND_DECIMAL_MIN_MESSAGE_RECOMMEND = "請檢查數值是否有誤，數值必須是0.0以上";

    /**
     * 餐點推薦指數:輸入""," ",不提交時提示的訊息
     */
    public static final String NOT_BLANK_MESSAGE_RECOMMEND = "請填寫有效的餐點推薦指數";



    /**
     * 餐點描述:輸入""," ",不提交時提示的訊息
     */
    public static final String NOT_BLANK_MESSAGE_DESCRIDE = "請填寫有效的餐點描述";

    /**
     * 判斷餐點描述不可超過的字符數
     */
    public static final String PATTERN_REGEXP_DESCRIDE = "^.{1,255}$";

    /**
     * 餐點描述超過字符數時提示的錯誤訊息
     */
    public static final String PATTERN_MESSAGE_DESCRIDE = "餐點描述最多不可超過255個字符";



}
