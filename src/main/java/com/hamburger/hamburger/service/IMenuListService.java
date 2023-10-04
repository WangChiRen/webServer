package com.hamburger.hamburger.service;


import com.hamburger.hamburger.pojo.dto.MenuListUpdateMenuDTO;
import com.hamburger.hamburger.pojo.vo.HamburgerListEditMenuVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * MenuListServiceImpl業務層接口
 */
public interface IMenuListService {


    /**
     * 根據id刪除管理員頁內的商品
     */
    @Transactional(rollbackFor = {Exception.class})
    void deleteMenuById(Integer id);


    /**
     * 根據id 修改目錄的商品數據
     */
    @Transactional(rollbackFor = {Exception.class})
    void updateByIdMenu(MenuListUpdateMenuDTO menuListUpdateMenuDTO, Integer id);


    /**
     * 編輯圖片
     */
    @Transactional(rollbackFor = {Exception.class})
    String editUpload(MultipartFile picFile) ;


    /**
     * 刪除圖片
     */
    @Transactional(rollbackFor = {Exception.class})
    void remove(String pictureName);


    /**
     * 查詢所有Edit-menu數據
     */
    @Transactional(rollbackFor = {Exception.class})
    List<HamburgerListEditMenuVO> listEditMenu();


}
