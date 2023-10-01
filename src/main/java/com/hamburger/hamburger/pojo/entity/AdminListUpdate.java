package com.hamburger.hamburger.pojo.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class AdminListUpdate implements Serializable {

    /**
     * 數據id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String username;


    /**
     * 帳號
     */
    private String account;


    /**
     * 手機號碼
     */
    private String phone;


    /**
     * 電子郵箱
     */
    private String mail;


    /**
     * 生日
     */
    private String birthday;


    /**
     * 帳號是否啟用:1 = 啟用,0 = 不啟用
     */
    private Integer enable;

    /**
     * 描述
     */
    private String description;

}
