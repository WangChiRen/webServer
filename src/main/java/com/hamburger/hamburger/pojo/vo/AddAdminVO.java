package com.hamburger.hamburger.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddAdminVO implements Serializable {

    /**
     * 數據id
     */
    private Integer id;

    /**
     * 權限名稱
     */
    private String name;
}
