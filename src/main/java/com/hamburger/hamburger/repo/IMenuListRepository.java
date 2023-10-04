package com.hamburger.hamburger.repo;

import com.hamburger.hamburger.pojo.vo.AdminListVO;
import com.hamburger.hamburger.pojo.vo.HamburgerListEditMenuVO;

import java.util.List;

public interface IMenuListRepository {

    String KEY_MENU_LIST = "menu:list";

    //存列表數據
    void putMenuList(List<HamburgerListEditMenuVO> list);

    //取列表數據
    List<HamburgerListEditMenuVO> menuList();

    //刪列表
    void deleteMenuList();

}
