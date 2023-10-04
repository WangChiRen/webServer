package com.hamburger.hamburger.service;


import com.hamburger.hamburger.pojo.dto.HamburgerMenuAddNewDTO;
import com.hamburger.hamburger.pojo.vo.HamburgerListMenuVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * HamburgerMenuServiceImpl業務層接口
 */
public interface IHamburgerMenuService {


    /**
     * 添加訂單數據
     */
    @Transactional(rollbackFor = {Exception.class})
    void addNew(HamburgerMenuAddNewDTO hamburgerMenuAddNewDTO);


    /**
     * 查詢所有addMenu訂單
     */
    @Transactional(rollbackFor = {Exception.class})
    List<HamburgerListMenuVO> listMenu();
}
