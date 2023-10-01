package com.hamburger.hamburger.service;


import com.hamburger.hamburger.pojo.dto.AdminListUpdateDTO;
import com.hamburger.hamburger.pojo.dto.MenuListUpdateMenuDTO;
import com.hamburger.hamburger.pojo.vo.AdminListVO;


import java.util.List;

/**
 * AdminListServiceImpl 業務層接口
 */
public  interface IAdminListService {

    /**
     * 根據id 修改目錄的商品數據
     */
    void updateByIdAdmin(AdminListUpdateDTO adminListUpdateDTO, Integer id);

    /**
     * 根據id刪除 ams 表內的數據
     */
    void deleteAdminById(Integer id);

    /**
     * 查詢所有 ams_admin 表數據
     */
    List<AdminListVO> adminList();


}
