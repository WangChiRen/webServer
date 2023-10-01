package com.hamburger.hamburger.service;


import com.hamburger.hamburger.pojo.dto.HamburgerMenuAddNewDTO;
import com.hamburger.hamburger.pojo.vo.HamburgerListMenuVO;

import java.util.List;

/**
 * HamburgerMenuServiceImpl業務層接口
 */
public interface IHamburgerMenuService {


    /**
     * 添加訂單數據
     */
    void addNew(HamburgerMenuAddNewDTO hamburgerMenuAddNewDTO);


    /**
     * 查詢所有addMenu訂單
     */
    List<HamburgerListMenuVO> listMenu();
}
