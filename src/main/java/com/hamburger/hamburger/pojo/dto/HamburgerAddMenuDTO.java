package com.hamburger.hamburger.pojo.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
public class HamburgerAddMenuDTO implements Serializable {

    /**
     * 存圖片路徑
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