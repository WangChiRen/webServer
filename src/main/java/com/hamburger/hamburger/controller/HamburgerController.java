package com.hamburger.hamburger.controller;

import com.hamburger.hamburger.pojo.dto.HamburgerAddNewDTO;

import com.hamburger.hamburger.pojo.dto.HamburgerUpdateByIdDTO;
import com.hamburger.hamburger.pojo.dto.HamburgerUpdateOrderNumberDTO;
import com.hamburger.hamburger.pojo.vo.HamburgerListItemVO;
import com.hamburger.hamburger.pojo.vo.HamburgerListOrderVO;
import com.hamburger.hamburger.service.IHamburgerService;
import com.hamburger.hamburger.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/hamburgers")
public class HamburgerController {

    @Autowired
    private IHamburgerService hamburgerService;

    /**
     * 添加訂單數據
     *
     * @param hamburgerAddNewDTO 訂單數據
     */
    @PostMapping("/add-new")
    public JsonResult addNew(@RequestBody HamburgerAddNewDTO hamburgerAddNewDTO) {

        log.debug("開始處理:HamburgerController.addNew()");
        hamburgerService.addNew(hamburgerAddNewDTO);
        return JsonResult.ok();
    }

    /**
     * 將所有訂單數據添加到order表中
     */
    @PostMapping("/add-order")
    public JsonResult addOrder() {

        log.debug("開始處理:HamburgerController.addOrder()");
        hamburgerService.addOrder();
        return JsonResult.ok();
    }

    /**
     * 根據id刪除訂單
     *
     * @param id 訂單的id
     */
    @PostMapping("/{id}/delete")
    public JsonResult delete(@PathVariable Integer id) {

        log.debug("開始處理:HamburgerController.delete()");
        log.debug("根據id=" + id + "刪除商品");
        hamburgerService.deleteById(id);
        return JsonResult.ok();
    }

    /**
     * 刪除全部訂單
     */
    @PostMapping("/deleteByData")
    public JsonResult deleteByData() {
        log.debug("開始處理:HamburgerController.deleteByData()");
        hamburgerService.deleteByData();
        return JsonResult.ok();
    }

    /**
     * 根據id修改訂單數據
     *
     * @param hamburgerUpdateByIdDTO 訂單數據
     * @param id                     訂單id
     */
    @PostMapping("/{id}/update")
    public JsonResult update(@RequestBody HamburgerUpdateByIdDTO hamburgerUpdateByIdDTO, @PathVariable Integer id) {

        log.debug("開始處理:HamburgerController.update()");
        log.debug("根據id=" + id + "修改訂單");
        // hamburgerService.updateById(修改的數據,修改的id編號);
        hamburgerService.updateById(hamburgerUpdateByIdDTO, id);
        return JsonResult.ok();

    }

    /**
     * 根據id修改訂單數據
     *
     * @param hamburgerUpdateOrderNumberDTO 訂單OrderNumber數據
     */
    @PostMapping("/update-order")
    public JsonResult updateOrderNumber(@RequestBody HamburgerUpdateOrderNumberDTO hamburgerUpdateOrderNumberDTO) {

        log.debug("開始處理:HamburgerController.updateOrderNumber()");
        hamburgerService.updateOrderNumber(hamburgerUpdateOrderNumberDTO);
        return JsonResult.ok();

    }

    /**
     * 查詢所有menu數據
     */
    @GetMapping
    public JsonResult list() {
        log.debug("開始處理:HamburgerController.list()");
        List<HamburgerListItemVO> list = hamburgerService.list();

        return JsonResult.ok(list);
    }


    /**
     * 查詢所有order數據
     */
    @GetMapping("/list-order")
    public JsonResult listOrder() {
        log.debug("開始處理:HamburgerController.listOrder()");
        List<HamburgerListOrderVO> list = hamburgerService.listOrder();
        return JsonResult.ok(list);
    }


}
