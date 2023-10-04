package com.hamburger.hamburger.repo;


import com.hamburger.hamburger.pojo.vo.AdminListVO;
import com.hamburger.hamburger.pojo.vo.HamburgerListMenuVO;

import java.util.List;

public interface IHamburgerMenuRepository {

    String KEY_HAMBURGER_MENU = "hamburger:menu";

    //存列表數據
    void putHamburgerMenu(List<HamburgerListMenuVO> list);

    //取列表數據
    List<HamburgerListMenuVO> hamburgerMenu();

    //刪列表
    void deleteHamburgerMenu();


}
