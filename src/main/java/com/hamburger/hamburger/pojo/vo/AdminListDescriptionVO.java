package com.hamburger.hamburger.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminListDescriptionVO implements Serializable {

    /**
     * 數據id
     */
    private Integer id;

    /**
     * 描述
     */
    private String name;

}
