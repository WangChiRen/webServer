package com.hamburger.hamburger.mapper;

import com.hamburger.hamburger.pojo.entity.Hamburger;
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
     * @param hamburger 前端給的數據
     * @return 受引響行數
     */
    int insert(Hamburger hamburger);


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
