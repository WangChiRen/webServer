package com.hamburger.hamburger.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class HamburgerUpdateByIdDTO implements Serializable {

    /**
     * 數據id
     */
    private Integer id;

    /**
     *數量
     */
    private Integer quantity;

    /**
     *總價
     */
    private Integer total;

}
