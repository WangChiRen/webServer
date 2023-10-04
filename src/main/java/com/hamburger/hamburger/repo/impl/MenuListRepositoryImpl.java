package com.hamburger.hamburger.repo.impl;


import com.hamburger.hamburger.pojo.vo.HamburgerListEditMenuVO;
import com.hamburger.hamburger.repo.IMenuListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class MenuListRepositoryImpl extends SuperRepository<HamburgerListEditMenuVO> implements IMenuListRepository {

    public MenuListRepositoryImpl() {
        log.debug("MenuList數據訪問層對象.MenuListRepositoryImpl()");
    }

    @Override
    protected String getRedisKey() {
        return KEY_MENU_LIST;
    }

    @Override
    public void putMenuList(List<HamburgerListEditMenuVO> list) {

        log.debug("向Redis中寫入MenuList列表數據....{}", list);
        putData(list);
        log.debug("已經寫入List型資料到Redis");
    }

    @Override
    public List<HamburgerListEditMenuVO> menuList() {

        log.debug("向Redis中讀取MenuList列表數據....");
        List<HamburgerListEditMenuVO> hamburgerListEditMenuVO = getData();
        log.debug("從Redis中讀取MenuList列表數據:{}", hamburgerListEditMenuVO);
        return hamburgerListEditMenuVO;
    }

    @Override
    public void deleteMenuList() {

       deleteData();
    }


}
