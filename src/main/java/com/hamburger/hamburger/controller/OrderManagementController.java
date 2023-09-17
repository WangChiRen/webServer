package com.hamburger.hamburger.controller;

import com.hamburger.hamburger.pojo.vo.HamburgerListOrderVO;

import com.hamburger.hamburger.service.IOrderManagementService;
import com.hamburger.hamburger.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public JsonResult listOrder() {
        log.debug("開始處理:OrderManagementController.listOrder()");
        List<HamburgerListOrderVO> list = orderManagementService.listOrder();
        return JsonResult.ok(list);
    }


}
