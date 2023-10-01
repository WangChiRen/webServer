package com.hamburger.hamburger.pojo.dto;


import static com.hamburger.hamburger.validation.AddMenuValidationConst.*;
import static com.hamburger.hamburger.validation.AddMenuValidationConst.NOT_BLANK_MESSAGE_RECOMMEND;

import lombok.Data;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
public class AddMenuDTO implements Serializable {

    /**
     * 圖片名稱
     */

    private String commodity;


    /**
     * 餐點名稱
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_MEALS)
    @Pattern(regexp = PATTERN_REGEXP_MEALS,message = PATTERN_MESSAGE_MEALS)
    private String meals;


    /**
     * 餐點單價
     */
    @Positive(message = POSITVE_MESSAGE_UNITPRICE)
    private Integer unitprice;


    /**
     * 餐點推薦指數
     */
    @DecimalMin(value = DECIMAL_MIN_VALUE_RECOMMEND, message = DECIMAL_MIN_AND_DECIMAL_MIN_MESSAGE_RECOMMEND)
    @DecimalMax(value = DECIMAL_MAX_VALUE_RECOMMEND, message = DECIMAL_MAX_AND_DECIMAL_MIN_MESSAGE_RECOMMEND)
    private Double recommend;


    /**
     * 餐點描述
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_DESCRIDE)
    @Pattern(regexp = PATTERN_REGEXP_DESCRIDE,message = PATTERN_MESSAGE_DESCRIDE)
    private String descride;



}
