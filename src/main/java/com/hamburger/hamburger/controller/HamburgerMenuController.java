package com.hamburger.hamburger.controller;

import com.hamburger.hamburger.pojo.dto.HamburgerAddNewDTO;
import com.hamburger.hamburger.pojo.vo.HamburgerListMenuVO;
import com.hamburger.hamburger.service.IHamburgerMenuService;
import com.hamburger.hamburger.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hamburgers")
public class HamburgerMenuController {

    @Autowired
    private IHamburgerMenuService hamburgerMenuService;


    /**
     * 添加訂單數據
     *
     * @param hamburgerAddNewDTO 訂單數據
     */
    @PostMapping("/add-new")
    public JsonResult addNew(@RequestBody HamburgerAddNewDTO hamburgerAddNewDTO) {

        log.debug("開始處理:HamburgerMenuController.addNew()");
        hamburgerMenuService.addNew(hamburgerAddNewDTO);
        return JsonResult.ok();
    }


    /**
     * 查詢所有addMenu數據
     */
    @GetMapping("/list-menu")
    public JsonResult listMenu() {
        log.debug("開始處理:HamburgerMenuController.listMenu()");
        List<HamburgerListMenuVO> list = hamburgerMenuService.listMenu();
        return JsonResult.ok(list);
    }
}
