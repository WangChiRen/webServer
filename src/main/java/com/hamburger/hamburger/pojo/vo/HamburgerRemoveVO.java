package com.hamburger.hamburger.pojo.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class HamburgerRemoveVO implements Serializable {

    /**
     * 數據id
     */
    private Integer id;


    /**
     * 圖片名稱
     */
    private String commodity;


}