package com.hamburger.hamburger.service;


import com.hamburger.hamburger.pojo.dto.HamburgerAddNewDTO;
import com.hamburger.hamburger.pojo.dto.HamburgerUpdateByIdDTO;
import com.hamburger.hamburger.pojo.dto.HamburgerUpdateOrderNumberDTO;
import com.hamburger.hamburger.pojo.entity.Hamburger;
import com.hamburger.hamburger.pojo.entity.HamburgerUpdate;
import com.hamburger.hamburger.pojo.vo.HamburgerListItemVO;
import com.hamburger.hamburger.pojo.vo.HamburgerListOrderVO;

import java.util.List;

/**
 * 業務層接口
 */
public interface IHamburgerService {

    /**
     * 添加訂單數據
     */
    void addNew(HamburgerAddNewDTO hamburgerAddNewDTO);


    /**
     * 添加訂單至order表中
     */
    void addOrder();


    /**
     * 根據id刪除商品
     */
    void deleteById(Integer id);

    /**
     * 刪除全部商品
     */
    void deleteByData();


    /**
     * 查詢所有訂單
     */
    List<HamburgerListItemVO> list();


    /**
     * 查詢所有order訂單
     */
    List<HamburgerListOrderVO> listOrder();


    /**
     * 根據id 修改訂單數據
     */
    void updateById(HamburgerUpdateByIdDTO hamburgerUpdateByIdDTO, Integer id);


    /**
     * 修改orderNumber數據
     */
    void updateOrderNumber(HamburgerUpdateOrderNumberDTO hamburgerUpdateOrderNumberDTO);

}
