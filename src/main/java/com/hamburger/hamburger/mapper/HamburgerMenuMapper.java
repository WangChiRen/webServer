package com.hamburger.hamburger.mapper;

import com.hamburger.hamburger.pojo.entity.HamburgerMenu;
import com.hamburger.hamburger.pojo.vo.HamburgerListMenuVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * HamburgerMenuMapper 接口
 */
@Repository
public interface HamburgerMenuMapper {


    /**
     * 插入數據給到購物車
     *
     * @param hamburgerMenu 前端給的數據
     * @return 受引響行數
     */
    int insert(HamburgerMenu hamburgerMenu);


    /**
     * 統計所有數據量
     *
     * @return 數據數量
     */
    int count();


    /**
     * 查詢addMenu列表數據
     *
     * @return 列表數據
     */
    List<HamburgerListMenuVO> listMenu();
}
