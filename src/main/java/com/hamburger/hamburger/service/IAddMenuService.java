package com.hamburger.hamburger.service;

import com.hamburger.hamburger.pojo.dto.HamburgerAddMenuDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * AddMenuServiceImpl業務層接口
 */
public  interface  IAddMenuService  {


    /**
     * 添加目錄數據
     */
    void addMenu(HamburgerAddMenuDTO hamburgerAddMenuDTO) throws IOException;


    /**
     * 添加圖片
     */
    String upload(MultipartFile picFile) ;



}
