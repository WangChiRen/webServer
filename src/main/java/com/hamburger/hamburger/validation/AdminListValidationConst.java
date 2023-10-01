package com.hamburger.hamburger.validation;

public class AdminListValidationConst {

    /**
     * 姓名:輸入""," ",不提交時提示的訊息
     */
    public static final String NOT_BLANK_MESSAGE_USERNAME = "請填寫有效的姓名";

    /**
     * 判斷姓名若為英文時最少2個字符,最多10個字符,若為中文時則最少1個中文字最多6個中文字
     */
    public static final String PATTERN_REGEXP_USERNAME = "^(?:[a-zA-Z]{2,10}|[\\u4e00-\\u9fa5]{1,6})$";

    /**
     * 姓名錯誤訊息
     */
    public static final String PATTERN_MESSAGE_USERNAME = "英文姓名最少2個字,最多10個字,中文姓名最少1個字最多6個字";



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
     * 手機號碼:輸入""," ",不提交時提示的訊息
     */
    public static final String NOT_BLANK_MESSAGE_PHONE = "請填寫有效的手機號碼";

    /**
     * 判斷手機號碼是否為台灣格式
     */
    public static final String PATTERN_REGEXP_PHONE = "^(09)\\d{8}$";

    /**
     * 手機號碼錯誤訊息
     */
    public static final String PATTERN_MESSAGE_PHONE = "手機號碼格式錯誤,請重新填寫";



    /**
     * 電子郵箱:輸入""," ",不提交時提示的訊息
     */
    public static final String NOT_BLANK_MESSAGE_MAIL = "請填寫有效的電子郵箱";

    /**
     * 電子郵箱錯誤訊息
     */
    public static final String EMAIL_MESSAGE_MAIL = "電子郵箱格式錯誤,請重新填寫";





    /**
     * 生日:輸入""," ",不提交時提示的訊息
     */
    public static final String NOT_BLANK_MESSAGE_BIRTHDAY = "電子郵箱格式錯誤,請重新填寫";

    /**
     * 判斷生日的格式
     */
    public static final String PATTERN_REGEXP_BIRTHDAY = "^.{8,32}$";

    /**
     * 生日錯誤訊息
     */
    public static final String PATTERN_MESSAGE_BIRTHDAY = "生日格式錯誤,請重新填寫";



    /**
     * 帳號是否啟用:1 = 啟用,0 = 不啟用 (錯誤訊息)
     */
    public static final String MAX_MESSAGE_VALUE_ENABLE = "帳號是否啟用格式錯誤,請稍後再試";

    /**
     * 帳號是否啟用:1 = 啟用,0 = 不啟用 (錯誤訊息)
     */
    public static final String MIN_MESSAGE_VALUE_ENABLE = "帳號是否啟用格式錯誤,請稍後再試";



    /**
     * 描述:輸入""," ",不提交時提示的訊息
     */
    public static final String NOT_BLANK_MESSAGE_DESCRIPTION = "請填寫有效的描述訊息";

    /**
     * 判斷描述的格式
     */
    public static final String PATTERN_REGEXP_DESCRIPTION = "^(超級管理員|經理|組長|員工)$";

    /**
     * 描述錯誤訊息
     */
    public static final String PATTERN_MESSAGE_DESCRIPTION = "描述訊息格式錯誤,請重新填寫";

}
