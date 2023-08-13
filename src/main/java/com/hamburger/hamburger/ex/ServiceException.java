package com.hamburger.hamburger.ex;

/**
 * 業務異常
 */
public class ServiceException extends RuntimeException {

    public Integer serviceCode;

    public ServiceException(Integer serviceCode, String message) {

        super(message);
        this.serviceCode = serviceCode;
    }

    public Integer getServiceCode() {
        return serviceCode;
    }

}
