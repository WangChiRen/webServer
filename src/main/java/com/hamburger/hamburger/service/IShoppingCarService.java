package com.hamburger.hamburger.service;


import com.hamburger.hamburger.pojo.dto.ShoppingCarUpdateByIdDTO;
import com.hamburger.hamburger.pojo.dto.ShoppingCarUpdateOrderNumberDTO;
import com.hamburger.hamburger.pojo.vo.HamburgerListItemVO;

import java.util.List;

/**
 * ShoppingCarServiceImpl業務層接口
 */
public interface IShoppingCarService {


    /**
     * 添加訂單至order表中
     */
    void addOrder();


    /**
     * 根據id刪除購物車內的商品
     */
    void deleteById(Integer id);


    /**
     * 刪除全部商品
     */
    void deleteByData();


    /**
     *  關閉或刷新瀏覽器時刪除全部訂單
     */
    void deleteShoppingCartData();


    /**
     * 根據id 修改訂單數據
     */
    void updateById(ShoppingCarUpdateByIdDTO shoppingCarUpdateByIdDTO, Integer id);


    /**
     * 修改orderNumber數據
     */
    void updateOrderNumber(ShoppingCarUpdateOrderNumberDTO shoppingCarUpdateOrderNumberDTO);


    /**
     * 查詢所有訂單
     */
    List<HamburgerListItemVO> list();
}
