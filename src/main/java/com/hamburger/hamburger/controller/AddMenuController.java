package com.hamburger.hamburger.controller;


import com.hamburger.hamburger.pojo.dto.AddMenuDTO;
import com.hamburger.hamburger.service.IAddMenuService;
import com.hamburger.hamburger.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * 控制器層:負責接收前端 AddMenuView 的請求與響應
 */
@Slf4j
@RestController
@RequestMapping("/hamburgers")
public class AddMenuController {


    @Autowired
    private IAddMenuService addMenuService;


    /**
     * 添加菜單目錄數據
     *
     * @param addMenuDTO 添加目錄數據
     */
    @PostMapping("/add-menu")
    @PreAuthorize("hasAuthority('add/menu/add')")
    public JsonResult addMenu(@RequestBody @Validated AddMenuDTO addMenuDTO)  {

        log.debug("開始處理:AddMenuController.addMenu()");
        addMenuService.addMenu(addMenuDTO);
        return JsonResult.ok();
    }


    /**
     * 添加圖片
     *
     * @param picFile 添加圖片
     */
    @PostMapping("/upload")
    @PreAuthorize("hasAuthority('add/menu/add')")
    public JsonResult upload(@RequestParam("picFile") MultipartFile picFile) {

        log.debug("開始處理:AddMenuController.upload()");
        addMenuService.upload(picFile);
        return JsonResult.ok();
    }
}
