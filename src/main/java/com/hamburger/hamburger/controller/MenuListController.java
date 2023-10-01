package com.hamburger.hamburger.controller;


import com.hamburger.hamburger.pojo.dto.MenuListUpdateMenuDTO;
import com.hamburger.hamburger.pojo.vo.HamburgerListEditMenuVO;
import com.hamburger.hamburger.service.IMenuListService;
import com.hamburger.hamburger.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

/**
 * 控制器層:負責接收前端 MenuListView 的請求與響應
 */
@Slf4j
@RestController
@RequestMapping("/hamburgers")
public class MenuListController {


    @Autowired
    private IMenuListService menuListService;


    /**
     * 根據id刪除菜單列表中的數據
     *
     * @param id 訂單的id
     */
    @PostMapping("/{id}/delete-menu")
    @PreAuthorize("hasAuthority('add/menu/delete')")
    public JsonResult deleteMenu(@PathVariable Integer id) {

        log.debug("開始處理:MenuListController.deleteMenu()");
        log.debug("根據id=" + id + "刪除管理頁面內的數據");
        menuListService.deleteMenuById(id);
        return JsonResult.ok();
    }


    /**
     * 根據id修改菜單列表中的數據
     *
     * @param menuListUpdateMenuDTO 修改添加目錄商品品的數據
     * @param id                     訂單id
     */
    @PostMapping("/{id}/edit-sent")
    @PreAuthorize("hasAuthority('add/menu/update')")
    public JsonResult updateByIdMenu(@RequestBody @Validated MenuListUpdateMenuDTO menuListUpdateMenuDTO, @PathVariable Integer id) {
        log.debug("開始處理:MenuListController.updateByIdMenu()");
        log.debug("根據id=" + id + "修改的目錄數據");
        // hamburgerService.updateByIdMenu(修改的數據,修改的id編號);
        menuListService.updateByIdMenu(menuListUpdateMenuDTO, id);
        return JsonResult.ok();
    }


    /**
     * 編輯圖片
     *
     * @param picFile 編輯圖片
     */
    @PostMapping("/edit-upload")
    @PreAuthorize("hasAuthority('add/menu/update')")
    public JsonResult EditUpload(@RequestParam("picFile") MultipartFile picFile) {

        log.debug("開始處理:MenuListController.EditUpload()");
        menuListService.editUpload(picFile);
        return JsonResult.ok();
    }


    /**
     * 查詢所有菜單列表中的數據
     */
    @GetMapping("/list-edit-menu")
    @PreAuthorize("hasAuthority('add/menu/read')")
    public JsonResult listEditMenu() {
        log.debug("開始處理:MenuListController.listEditMenu()");
        List<HamburgerListEditMenuVO> list = menuListService.listEditMenu();
        return JsonResult.ok(list);
    }





}
