package com.hamburger.hamburger.controller;

import com.hamburger.hamburger.pojo.dto.ShoppingCarUpdateByIdDTO;
import com.hamburger.hamburger.pojo.dto.ShoppingCarUpdateOrderNumberDTO;
import com.hamburger.hamburger.pojo.vo.HamburgerListItemVO;
import com.hamburger.hamburger.service.IShoppingCarService;
import com.hamburger.hamburger.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 控制器層:負責接收前端 ShoppingCarView 的請求與響應
 */
@Slf4j
@RestController
@RequestMapping("/hamburgers")
public class ShoppingCarController {

    @Autowired
    private IShoppingCarService shoppingCarService;


    /**
     * 將所有訂單數據添加到order表中
     */
    @PostMapping("/add-order")
    public JsonResult addOrder() {

        log.debug("開始處理:ShoppingCarController.addOrder()");
        shoppingCarService.addOrder();
        return JsonResult.ok();
    }


    /**
     * 根據id刪除購物車內的訂單
     *
     * @param id 訂單的id
     */
    @PostMapping("/{id}/delete")
    public JsonResult delete(@PathVariable Integer id) {

        log.debug("開始處理:ShoppingCarController.delete()");
        log.debug("根據id=" + id + "刪除商品");
        shoppingCarService.deleteById(id);
        return JsonResult.ok();
    }


    /**
     * 刪除全部訂單
     */
    @PostMapping("/deleteByData")
    public JsonResult deleteByData() {
        log.debug("開始處理:ShoppingCarController.deleteByData()");
        shoppingCarService.deleteByData();
        return JsonResult.ok();
    }


    /**
     * 關閉或刷新瀏覽器時刪除全部訂單
     */
    @PostMapping("/deleteShoppingCartData")
    public JsonResult deleteShoppingCartData() {
        log.debug("開始處理:ShoppingCarController.deleteShoppingCartData()");
        shoppingCarService.deleteShoppingCartData();
        return JsonResult.ok();
    }


    /**
     * 根據id修改訂單數據
     *
     * @param shoppingCarUpdateByIdDTO 訂單數據
     * @param id                     訂單id
     */
    @PostMapping("/{id}/update")
    public JsonResult update(@RequestBody @Validated ShoppingCarUpdateByIdDTO shoppingCarUpdateByIdDTO, @PathVariable Integer id) {

        log.debug("開始處理:ShoppingCarController.update()");
        log.debug("根據id=" + id + "修改訂單");
        // hamburgerService.updateById(修改的數據,修改的id編號);
        shoppingCarService.updateById(shoppingCarUpdateByIdDTO, id);
        return JsonResult.ok();

    }


    /**
     * 根據id修改訂單編號
     *
     * @param shoppingCarUpdateOrderNumberDTO 訂單OrderNumber數據
     */
    @PostMapping("/update-order")
    public JsonResult updateOrderNumber(@RequestBody @Validated ShoppingCarUpdateOrderNumberDTO shoppingCarUpdateOrderNumberDTO) {

        log.debug("開始處理:ShoppingCarController.updateOrderNumber()");
        shoppingCarService.updateOrderNumber(shoppingCarUpdateOrderNumberDTO);
        return JsonResult.ok();

    }


    /**
     * 查詢所有購物車內的數據
     */
    @GetMapping("list-shopping-car")
    public JsonResult list() {
        log.debug("開始處理:ShoppingCarController.list()");
        List<HamburgerListItemVO> list = shoppingCarService.list();

        return JsonResult.ok(list);
    }

}
