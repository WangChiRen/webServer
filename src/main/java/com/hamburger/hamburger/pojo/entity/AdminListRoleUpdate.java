package com.hamburger.hamburger.pojo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminListRoleUpdate implements Serializable {


    /**
     * ams_admin_role 表中的 role_id
     */
    private Integer role_id;


    /**
     * 描述
     */
    private String description;


    /**
     * ams_admin_role 表中的 admin_id
     */
    private Integer admin_id;
}
