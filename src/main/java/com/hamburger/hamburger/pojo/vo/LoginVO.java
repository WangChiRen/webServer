package com.hamburger.hamburger.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LoginVO implements Serializable {

    /**
     * 員工列表 id
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
     * 密碼
     */
    private String password;

    /**
     * 帳號禁用/啟用 0-進用/1-啟用
     */
    private Integer enable;

    /**
     * 權限列表
     */
    private List<String> permissions;

}
