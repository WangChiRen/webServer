package com.hamburger.hamburger.pojo.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class HamburgerUpdateOrderNumberDTO implements Serializable {

    /**
     *訂單編號
     */
    private Integer ordernumber;

}
