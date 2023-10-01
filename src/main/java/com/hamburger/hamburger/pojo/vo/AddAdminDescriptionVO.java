package com.hamburger.hamburger.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddAdminDescriptionVO implements Serializable {

    /**
     * 數據id
     */
    private Integer id;

    /**
     * 描述
     */
    private String name;
}
