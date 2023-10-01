package com.hamburger.hamburger.validation;



public class ForgetPasswordValidationConst {

    /**
     * 帳號:輸入""," ",不提交時提示的訊息
     */
    public static final String NOT_BLANK_MESSAGE_ACCOUNT = "請填寫有效的帳號";

    /**
     * 判斷帳號不可超過的字符數
     */
    public static final String PATTERN_REGEXP_ACCOUNT = "^(.{4,16})$";

    /**
     * 帳號錯誤訊息
     */
    public static final String PATTERN_MESSAGE_ACCOUNT = "帳號最少4位,最多16位";



    /**
     * 密碼:輸入""," ",不提交時提示的訊息
     */
    public static final String NOT_BLANK_MESSAGE_PASSWORD = "請填寫有效的密碼";

    /**
     * 判斷密碼不可超過的字符數
     */
    public static final String PATTERN_REGEXP_PASSWORD = "^(.{5,16})$";

    /**
     * 密碼錯誤訊息
     */
    public static final String PATTERN_MESSAGE_PASSWORD = "密碼最少5位,最多16位";


}
