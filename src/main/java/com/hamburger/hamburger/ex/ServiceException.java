package com.hamburger.hamburger.ex;

/**
 * 業務異常
 */
public class ServiceException extends RuntimeException {

    public Integer serviceCode;

    /**
     * 創建一個新的 ServiceException 實例
     * @param serviceCode 業務錯誤碼
     * @param message 異常消息
     */
    public ServiceException(Integer serviceCode, String message) {

        super(message);
        this.serviceCode = serviceCode;
    }

    /**
     * 獲取業務錯誤碼
     * @return 業務錯誤碼
     */
    public Integer getServiceCode() {
        return serviceCode;
    }

}
