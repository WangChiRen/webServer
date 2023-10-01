package com.hamburger.hamburger.service;


import com.hamburger.hamburger.pojo.dto.AddAdminDTO;
import com.hamburger.hamburger.pojo.vo.AddAdminVO;
import com.hamburger.hamburger.pojo.vo.AdminListVO;

import java.util.List;

/**
 * AddAdminServiceImpl業務層接口
 */
public  interface IAddAdminService {

    /**
     * 添加員工數據
     */
    void insertAddAdmin(AddAdminDTO addAdminDTO);

    /**
     * 查詢所有 ams_role 表數據
     */
    List<AddAdminVO> addAdminList();


}
