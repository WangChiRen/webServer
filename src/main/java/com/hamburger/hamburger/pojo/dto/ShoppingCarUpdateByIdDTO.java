package com.hamburger.hamburger.pojo.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import static com.hamburger.hamburger.validation.ShoppingCarValidationConst.*;

@Data
public class ShoppingCarUpdateByIdDTO implements Serializable {

    /**
     * 數據id
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_ID)
    @Positive(message = POSITVE_MESSAGE_ID)
    private Integer id;

    /**
     *數量
     */
    @NotBlank(message = NOT_BLANK_MESSAGE_QUANTITY)
    @Max(value = 99, message = MAX_MESSAGE_VALUE_QUANTITY)
    @Min(value = 1, message = MIN_MESSAGE_VALUE_QUANTITY)
    private Integer quantity;

    /**
     *總價
     */
    @Positive(message = POSITVE_MESSAGE_TOTAL)
    private Integer total;

}
