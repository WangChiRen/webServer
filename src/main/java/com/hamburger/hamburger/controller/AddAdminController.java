package com.hamburger.hamburger.controller;


import com.hamburger.hamburger.pojo.dto.AddAdminDTO;
import com.hamburger.hamburger.pojo.vo.AddAdminVO;
import com.hamburger.hamburger.pojo.vo.HamburgerListMenuVO;
import com.hamburger.hamburger.service.IAddAdminService;
import com.hamburger.hamburger.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 控制器層:負責接收前端 AddAdminView 的請求與響應
 */
@Slf4j
@RestController
@RequestMapping("/hamburgers")
public class AddAdminController {

    @Autowired
    private IAddAdminService addAdminService;

    /**
     * 添加員工數據
     *
     * @param addAdminDTO 添加員工數據
     */
    @PostMapping("/add-ams")
    @PreAuthorize("hasAuthority('ams/admin/add')")
    public JsonResult insertAddAdmin(@RequestBody @Validated AddAdminDTO addAdminDTO) {

        log.debug("開始處理:AddAdminController.insertAddAdmin()");
        addAdminService.insertAddAdmin(addAdminDTO);
        return JsonResult.ok();
    }

    /**
     * 查詢所有 ams_role 數據
     */
    @GetMapping("/list-addAdmin")
    public JsonResult addAdminList() {
        log.debug("開始處理:AddAdminController.addAdminList()");
        List<AddAdminVO> list = addAdminService.addAdminList();
        return JsonResult.ok(list);
    }


}
