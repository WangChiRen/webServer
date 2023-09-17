package com.hamburger.hamburger.controller;


import com.hamburger.hamburger.pojo.dto.HamburgerUpdateMenuDTO;
import com.hamburger.hamburger.pojo.vo.HamburgerListEditMenuVO;
import com.hamburger.hamburger.service.IMenuListService;
import com.hamburger.hamburger.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hamburgers")
public class MenuListController {


    @Autowired
    private IMenuListService menuListService;


    /**
     * 根據id刪除管理頁內的數據
     *
     * @param id 訂單的id
     */
    @PostMapping("/{id}/delete-menu")
    public JsonResult deleteMenu(@PathVariable Integer id) {

        log.debug("開始處理:MenuListController.deleteMenu()");
        log.debug("根據id=" + id + "刪除管理頁面內的數據");
        menuListService.deleteMenuById(id);
        return JsonResult.ok();
    }


    /**
     * 根據id修改目錄的數據
     *
     * @param hamburgerUpdateMenuDTO 修改添加目錄商品品的數據
     * @param id                     訂單id
     */
    @PostMapping("/{id}/edit-sent")
    public JsonResult updateByIdMenu(@RequestBody HamburgerUpdateMenuDTO hamburgerUpdateMenuDTO, @PathVariable Integer id) {
        log.debug("開始處理:MenuListController.updateByIdMenu()");
        log.debug("根據id=" + id + "修改的目錄訂單");
        // hamburgerService.updateByIdMenu(修改的數據,修改的id編號);
        menuListService.updateByIdMenu(hamburgerUpdateMenuDTO, id);
        return JsonResult.ok();
    }


    /**
     * 編輯圖片
     *
     * @param picFile 編輯圖片
     */
    @PostMapping("/edit-upload")
    public JsonResult EditUpload(@RequestParam("picFile") MultipartFile picFile) {

        log.debug("開始處理:MenuListController.EditUpload()");
        menuListService.editUpload(picFile);
        return JsonResult.ok();
    }


    /**
     * 查詢所有Edit-menu數據
     */
    @GetMapping("/list-edit-menu")
    public JsonResult listEditMenu() {
        log.debug("開始處理:MenuListController.listEditMenu()");
        List<HamburgerListEditMenuVO> list = menuListService.listEditMenu();
        return JsonResult.ok(list);
    }





}
