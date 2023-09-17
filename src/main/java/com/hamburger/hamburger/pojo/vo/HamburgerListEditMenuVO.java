package com.hamburger.hamburger.pojo.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class HamburgerListEditMenuVO implements Serializable {

    /**
     * 數據id
     */
    private Integer id;


    /**
     * 圖片名稱
     */
    private String commodity;


    /**
     * 餐點名稱
     */
    private String meals;


    /**
     * 餐點單價
     */
    private Integer unitprice;


    /**
     * 餐點推薦指數
     */
    private Double recommend;


    /**
     * 餐點描述
     */
    private String descride;

}