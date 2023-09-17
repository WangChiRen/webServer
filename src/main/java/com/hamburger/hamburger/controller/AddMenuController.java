package com.hamburger.hamburger.controller;


import com.hamburger.hamburger.pojo.dto.HamburgerAddMenuDTO;
import com.hamburger.hamburger.service.IAddMenuService;
import com.hamburger.hamburger.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/hamburgers")
public class AddMenuController {


    @Autowired
    private IAddMenuService addMenuService;


    /**
     * 添加訂單數據
     *
     * @param hamburgerAddMenuDTO 添加目錄數據
     */
    @PostMapping("/add-menu")
    public JsonResult addMenu(@RequestBody HamburgerAddMenuDTO hamburgerAddMenuDTO) throws IOException {

        log.debug("開始處理:AddMenuController.addMenu()");
        addMenuService.addMenu(hamburgerAddMenuDTO);
        return JsonResult.ok();
    }


    /**
     * 添加圖片
     *
     * @param picFile 添加圖片
     */
    @PostMapping("/upload")
    public JsonResult upload(@RequestParam("picFile") MultipartFile picFile) {

        log.debug("開始處理:AddMenuController.upload()");
        addMenuService.upload(picFile);
        return JsonResult.ok();
    }
}
