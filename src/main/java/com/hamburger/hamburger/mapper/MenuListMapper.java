package com.hamburger.hamburger.mapper;


import com.hamburger.hamburger.pojo.entity.HamburgerEditUpload;
import com.hamburger.hamburger.pojo.entity.HamburgerUpdateMenu;
import com.hamburger.hamburger.pojo.vo.HamburgerDetailMenuVO;
import com.hamburger.hamburger.pojo.vo.HamburgerListEditMenuVO;
import com.hamburger.hamburger.pojo.vo.HamburgerRemoveVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MenuListMapper 接口
 */
@Repository
public interface MenuListMapper {


    /**
     * 根據id刪除管理員頁內的數據
     *
     * @param id 購物車內的id
     * @return 受引響行數
     */
    int deleteMenuById(Integer id);


    /**
     * 根據id修改目錄詳情數據
     *
     * @param hamburgerUpdateMenu 修改MenuList的數據
     * @return 受引響行數
     */
    int updateByIdMenu(HamburgerUpdateMenu hamburgerUpdateMenu);


    /**
     * 根據id修改目錄詳情數據
     *
     * @param hamburgerEditUpload 修改圖片的數據的數據
     * @return 受引響行數
     */
    int updateByIdEditUpload(HamburgerEditUpload hamburgerEditUpload);


    /**
     * 根據圖片名稱統計圖片名稱數據的數量
     *
     * @param commodity 圖片名稱
     * @return 圖片名稱數據數量
     */
    int countByName(String commodity);


    /**
     * 根據圖片名稱查詢AddMenu內的圖片詳情
     *
     * @param id 菜單頁的id
     * @return 圖片詳情
     */
    HamburgerRemoveVO getCommodityName(Integer id);


    /**
     * 根據id查詢管理頁內的數據詳情
     *
     * @param id 定單id
     * @return 訂單詳情
     */
    HamburgerDetailMenuVO getAddMenuId(Integer id);


    /**
     * 查詢addMenu列表數據
     *
     * @return 列表數據
     */
    List<HamburgerListEditMenuVO> listEditMenu();
}
