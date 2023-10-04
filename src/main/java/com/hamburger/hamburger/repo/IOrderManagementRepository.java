package com.hamburger.hamburger.repo;

import com.hamburger.hamburger.pojo.vo.HamburgerListOrderVO;

import java.util.List;

public interface IOrderManagementRepository {

    String KEY_ORDER_MANAGEMENT = "order:management";

    //存列表數據
    void putOrderManagement(List<HamburgerListOrderVO> list);

    //取列表數據
    List<HamburgerListOrderVO> orderManagement();

    //刪列表
    void deleteOrderManagement();


}
