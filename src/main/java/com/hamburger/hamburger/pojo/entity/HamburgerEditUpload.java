package com.hamburger.hamburger.pojo.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class HamburgerEditUpload implements Serializable {

    /**
     * 數據id
     */
    private Integer id;


    /**
     * 存圖片
     */
    private String commodity;

}