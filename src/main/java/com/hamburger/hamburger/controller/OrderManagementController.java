package com.hamburger.hamburger.controller;

import com.hamburger.hamburger.pojo.vo.HamburgerListOrderVO;
import com.hamburger.hamburger.service.IOrderManagementService;
import com.hamburger.hamburger.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 控制器層:負責接收前端 OrderManagementView 的請求與響應
 */
@Slf4j
@RestController
@RequestMapping("/hamburgers")
public class OrderManagementController {

    @Autowired
    private IOrderManagementService orderManagementService;


    /**
     * 查詢所有order數據
     */
    @GetMapping("/list-order")
    @PreAuthorize("hasAuthority('hamburger/order/read')")
    public JsonResult listOrder() {
        log.debug("開始處理:OrderManagementController.listOrder()");
        List<HamburgerListOrderVO> list = orderManagementService.listOrder();
        return JsonResult.ok(list);
    }


}
