package com.hamburger.hamburger.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class HamburgerUpdateDetailVO implements Serializable {


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

}
