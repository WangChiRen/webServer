package com.hamburger.hamburger.pojo.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class HamburgerPictureDTO implements Serializable {

    /**
     * 圖片名稱
     */
    private String pictureName;

}
