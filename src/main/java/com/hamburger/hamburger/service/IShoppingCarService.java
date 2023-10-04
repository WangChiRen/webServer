package com.hamburger.hamburger.service;


import com.hamburger.hamburger.pojo.dto.ShoppingCarUpdateByIdDTO;
import com.hamburger.hamburger.pojo.dto.ShoppingCarUpdateOrderNumberDTO;
import com.hamburger.hamburger.pojo.vo.HamburgerListItemVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ShoppingCarServiceImpl業務層接口
 */
public interface IShoppingCarService {


    /**
     * 添加訂單至order表中
     */
    @Transactional(rollbackFor = {Exception.class})
    void addOrder();


    /**
     * 根據id刪除購物車內的商品
     */
    @Transactional(rollbackFor = {Exception.class})
    void deleteById(Integer id);


    /**
     * 刪除全部商品
     */
    @Transactional(rollbackFor = {Exception.class})
    void deleteByData();


    /**
     *  關閉或刷新瀏覽器時刪除全部訂單
     */
    @Transactional(rollbackFor = {Exception.class})
    void deleteShoppingCartData();


    /**
     * 根據id 修改訂單數據
     */
    @Transactional(rollbackFor = {Exception.class})
    void updateById(ShoppingCarUpdateByIdDTO shoppingCarUpdateByIdDTO, Integer id);


    /**
     * 修改orderNumber數據
     */
    @Transactional(rollbackFor = {Exception.class})
    void updateOrderNumber(ShoppingCarUpdateOrderNumberDTO shoppingCarUpdateOrderNumberDTO);


    /**
     * 查詢所有訂單
     */
    @Transactional(rollbackFor = {Exception.class})
    List<HamburgerListItemVO> list();
}
