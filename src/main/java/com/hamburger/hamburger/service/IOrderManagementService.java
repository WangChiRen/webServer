package com.hamburger.hamburger.service;


import com.hamburger.hamburger.pojo.vo.HamburgerListOrderVO;

import java.util.List;

/**
 * OrderManagementServiceImpl業務層接口
 */
public interface IOrderManagementService {


    /**
     * 查詢所有order訂單
     */
    List<HamburgerListOrderVO> listOrder();



}
