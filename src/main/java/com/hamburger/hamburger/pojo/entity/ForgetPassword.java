package com.hamburger.hamburger.pojo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ForgetPassword implements Serializable {

    /**
     * 帳號
     */
    private String account;

    /**
     * 密碼
     */
    private String password;


}
