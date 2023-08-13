package com.hamburger.hamburger.web;

/**
 * 業務狀態碼
 */
public final class ServiceCode {

    /**
     * 成功
     */
    public static final Integer OK = 20000;

    /**
     * 錯誤：請求格式有誤
     */
    public static final Integer ERR_BAD_REQUEST = 40000;

    /**
     * 錯誤：不存在(不存在數據)
     */
    public static final Integer ERR_NOT_FOUND = 40400;

    /**
     * 錯誤：超過數據數量
     */
    public static final Integer ERR_EXCEED = 40900;

    /**
     * 錯誤：插入失敗
     */
    public static final Integer ERR_INSERT = 50000;
    /**
     * 錯誤：刪除失敗
     */
    public static final Integer ERR_DELETE = 50001;
    /**
     * 錯誤：更新失敗
     */
    public static final Integer ERR_UPDATE = 50002;
    /**
     * 錯誤：插入全部數據至hamburgerorder失敗
     */
    public static final Integer ERR_INSERT_ORDER = 50003;
    /**
     * 錯誤：刪除全部數據失敗
     */
    public static final Integer ERR_DELETE_ALLDATA = 50004;
    /**
     * 錯誤：修改OrderNumber數據失敗,不存在任何訂單數據
     */
    public static final Integer ERR_UPDATE_NUMBER = 50005;

    /**
     * 錯誤：未處理的異常
     */
    public static final Integer ERR_UNKNOWN = 59999;

}
