package com.hamburger.hamburger.controller;


import com.hamburger.hamburger.pojo.dto.AdminListUpdateDTO;
import com.hamburger.hamburger.pojo.dto.MenuListUpdateMenuDTO;
import com.hamburger.hamburger.pojo.vo.AdminListVO;
import com.hamburger.hamburger.pojo.vo.HamburgerListMenuVO;
import com.hamburger.hamburger.security.LoginPrincipal;
import com.hamburger.hamburger.service.IAdminListService;
import com.hamburger.hamburger.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 控制器層:負責接收前端 AdminListView 的請求與響應
 */
@Slf4j
@RestController
@RequestMapping("/hamburgers")
public class AdminListController {

    @Autowired
    private IAdminListService adminListService;

    /**
     * 根據id編輯 ams_admin 表內的數據
     *
     * @param id 訂單的id
     */
    @PostMapping("/{id}/update-admin")
    @PreAuthorize("hasAuthority('ams/admin/update')")
    public JsonResult updateByIdAdmin(@RequestBody @Validated AdminListUpdateDTO adminListUpdateDTO, @PathVariable Integer id) {

        log.debug("開始處理:AdminListController.updateByIdAdmin()");
        log.debug("根據id=" + id + "編輯 ams 表內的數據");
        adminListService.updateByIdAdmin(adminListUpdateDTO,id);
        return JsonResult.ok();
    }

    /**
     * 根據id刪除 ams_admin 表內的數據
     *
     * @param id 訂單的id
     */
    @PostMapping("/{id}/delete-admin")
    @PreAuthorize("hasAuthority('ams/admin/delete')")
    public JsonResult deleteAdmin(@PathVariable Integer id) {

        log.debug("開始處理:AdminListController.deleteAdmin()");
        log.debug("根據id=" + id + "刪除 ams 表內的數據");
        adminListService.deleteAdminById(id);
        return JsonResult.ok();
    }

    /**
     * 查詢所有 ams_admin 數據
     */
    @GetMapping("/list-ams")
    @PreAuthorize("hasAuthority('ams/admin/read')")
    public JsonResult adminList(@AuthenticationPrincipal LoginPrincipal loginPrincipal) {
        log.debug("開始處理:AdminListController.adminList(),當前認證訊息:{}",loginPrincipal);

        Integer id = loginPrincipal.getId();
        String account = loginPrincipal.getAccount();
        log.debug("從認證訊息中獲取當前登入的員工id:{},與帳號:{}",id,account);

        List<AdminListVO> list = adminListService.adminList();
        return JsonResult.ok(list);
    }

}
