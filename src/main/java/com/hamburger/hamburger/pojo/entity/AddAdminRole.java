package com.hamburger.hamburger.pojo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddAdminRole implements Serializable {

    /**
     * 數據id
     */
    private Integer id;

    /**
     * ams_admin 表中的數據id
     */
    private Integer admin_id;

    /**
     * ams_role 表中的數據id
     */
    private Integer role_id;
}
