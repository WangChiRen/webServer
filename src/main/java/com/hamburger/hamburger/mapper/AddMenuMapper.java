package com.hamburger.hamburger.mapper;


import com.hamburger.hamburger.pojo.entity.HamburgerAddMenu;
import org.springframework.stereotype.Repository;

/**
 * AddMenuMapper 接口
 */
@Repository
public interface AddMenuMapper {


    /**
     * 添加目錄數據
     *
     * @param hamburgerAddMenu 前端給的數據
     * @return 受引響行數
     */
    int insertAddMenu(HamburgerAddMenu hamburgerAddMenu);


    /**
     * 根據圖片名稱統計圖片名稱數據的數量
     *
     * @param commodity 圖片名稱
     * @return 圖片名稱數據數量
     */
    int countByName(String commodity);
}
