package com.hamburger.hamburger.pojo.dto;


import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;

import static com.hamburger.hamburger.validation.HamburgerMenuValidationConst.*;

@Data
public class HamburgerMenuAddNewDTO implements Serializable {


    /**
     * 圖片名稱
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_COMMODITY)
    private String commodity;


    /**
     * 單價
     */
    @Positive(message = POSITVE_MESSAGE_UNITPRICE)
    private Integer unitprice;


    /**
     * 數量
     */
    @Max(value = 99, message = MAX_MESSAGE_VALUE_QUANTITY)
    @Min(value = 1, message = MIN_MESSAGE_VALUE_QUANTITY)
    private Integer quantity;


    /**
     * 總價
     */
    @Positive(message = POSITVE_MESSAGE_TOTAL)
    private Integer total;


    /**
     * 訂單編號
     */
    @Positive(message = POSITVE_MESSAGE_ORDERNUMBER)
    private Integer ordernumber;


    /**
     * 訂單時間
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_SCHEDULE)
    private String schedule;


    /**
     * 訂單日期
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_TODAY)
    private String today;

}
