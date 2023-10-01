package com.hamburger.hamburger.pojo.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import static com.hamburger.hamburger.validation.HamburgerMenuValidationConst.NOT_BLANK_MESSAGE_COMMODITY;

@Data
public class HamburgerPictureDTO implements Serializable {

    /**
     * 圖片名稱
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_COMMODITY)
    private String pictureName;

}
