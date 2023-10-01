package com.hamburger.hamburger.controller;

import com.hamburger.hamburger.pojo.dto.HamburgerMenuAddNewDTO;
import com.hamburger.hamburger.pojo.vo.HamburgerListMenuVO;
import com.hamburger.hamburger.service.IHamburgerMenuService;
import com.hamburger.hamburger.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * 控制器層:負責接收前端 HamburgerMenuView 的請求與響應
 */
@Slf4j
@RestController
@RequestMapping("/hamburgers")
public class HamburgerMenuController {

    @Autowired
    private IHamburgerMenuService hamburgerMenuService;


    /**
     * 添加訂單數據
     *
     * @param hamburgerMenuAddNewDTO 訂單數據
     */
    @PostMapping("/add-new")
    public JsonResult addNew(@RequestBody @Validated HamburgerMenuAddNewDTO hamburgerMenuAddNewDTO) {

        log.debug("開始處理:HamburgerMenuController.addNew()");
        hamburgerMenuService.addNew(hamburgerMenuAddNewDTO);
        return JsonResult.ok();
    }


    /**
     * 查詢所有 addMenu 數據
     */
    @GetMapping("/list-menu")
    public JsonResult listMenu() {
        log.debug("開始處理:HamburgerMenuController.listMenu()");
        List<HamburgerListMenuVO> list = hamburgerMenuService.listMenu();
        return JsonResult.ok(list);
    }
}
