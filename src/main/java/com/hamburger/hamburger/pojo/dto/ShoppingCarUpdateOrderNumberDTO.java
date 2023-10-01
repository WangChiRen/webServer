package com.hamburger.hamburger.pojo.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import static com.hamburger.hamburger.validation.ShoppingCarValidationConst.*;

@Data
public class ShoppingCarUpdateOrderNumberDTO implements Serializable {

    /**
     *訂單編號
     */
    @Positive(message = POSITVE_MESSAGE_ORDERNUMBER)
    private Integer ordernumber;

}
