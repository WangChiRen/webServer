package com.hamburger.hamburger.pojo.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class HamburgerNumber implements Serializable {
    /**
     * 數據id
     */
    private Integer id;


    /**
     * 圖片名稱
     */
    private String commodity;


    /**
     * 單價
     */
    private Integer unitprice;


    /**
     * 數量
     */
    private Integer quantity;

    /**
     * 總價
     */
    private Integer total;

    /**
     *訂單編號
     */
    private Integer ordernumber;

}