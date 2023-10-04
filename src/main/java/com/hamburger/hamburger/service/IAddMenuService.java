package com.hamburger.hamburger.service;

import com.hamburger.hamburger.pojo.dto.AddMenuDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


/**
 * AddMenuServiceImpl業務層接口
 */
public  interface  IAddMenuService  {


    /**
     * 添加目錄數據
     */
    @Transactional(rollbackFor = {Exception.class})
    void addMenu(AddMenuDTO addMenuDTO) ;


    /**
     * 添加圖片
     */
    @Transactional(rollbackFor = {Exception.class})
    String upload(MultipartFile picFile) ;



}
