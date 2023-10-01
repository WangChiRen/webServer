package com.hamburger.hamburger.security;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginPrincipal implements Serializable {

    /**
     * 當前登入的用戶id
     */
    private Integer id;
    /**
     * 當前登入的用戶帳號
     */
    private String account;


}
