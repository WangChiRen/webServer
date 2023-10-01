package com.hamburger.hamburger.service;

import com.hamburger.hamburger.pojo.dto.AddMenuDTO;
import org.springframework.web.multipart.MultipartFile;


/**
 * AddMenuServiceImpl業務層接口
 */
public  interface  IAddMenuService  {


    /**
     * 添加目錄數據
     */
    void addMenu(AddMenuDTO addMenuDTO) ;


    /**
     * 添加圖片
     */
    String upload(MultipartFile picFile) ;



}
