package com.hamburger.hamburger.pojo.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class ShoppingCarUpdate implements Serializable {

    /**
     * 數據id
     */
    private Integer id;

    /**
     * 數量
     */
    private Integer quantity;

    /**
     * 總價
     */
    private Integer total;
}