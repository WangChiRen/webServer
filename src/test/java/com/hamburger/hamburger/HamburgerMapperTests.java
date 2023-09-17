package com.hamburger.hamburger;


import com.hamburger.hamburger.mapper.*;
import com.hamburger.hamburger.pojo.entity.*;
import com.hamburger.hamburger.pojo.vo.HamburgerListItemVO;
import com.hamburger.hamburger.pojo.vo.HamburgerListMenuVO;
import com.hamburger.hamburger.pojo.vo.HamburgerRemoveVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@SpringBootTest
public class HamburgerMapperTests {

    @Autowired
    AddMenuMapper addMenuMapper;

    @Autowired
    HamburgerMenuMapper hamburgerMenuMapper;

    @Autowired
    MenuListMapper menuListMapper;

    @Autowired
    OrderManagementMapper orderManagementMapper;

    @Autowired
    ShoppingCarMapper shoppingCarMapper;


    @Test
    public void testAddNew() {

        Hamburger hamburger = new Hamburger();
        hamburger.setTotal(2000);
        int rows = hamburgerMenuMapper.insert(hamburger);
        log.debug("rows 受引響行數:{}", rows);
        log.debug("hamburger 是:{}", hamburger.getTotal());

    }

    @Test
    public void testDeleteById() {

        Integer id = 206;
        int rows = shoppingCarMapper.deleteById(id);
        log.debug("rows 受引響行數:{}", rows);
    }

    @Test
    public void testDeleteAddMenuId() {

        Integer id = 160;
        int rows = menuListMapper.deleteMenuById(id);
        log.debug("rows 受引響行數:{}", rows);
    }

    @Test
    public void testUpdateMenu() {
        Integer id = 162;
        HamburgerUpdateMenu hamburgerUpdateMenu = new HamburgerUpdateMenu();
        hamburgerUpdateMenu.setId(id);
        hamburgerUpdateMenu.setUnitprice(300);

        int rows = menuListMapper.updateByIdMenu(hamburgerUpdateMenu);
        log.debug("rows 受引響行數:{}", rows);

    }

    @Test
    public void testCount() {
        int count = hamburgerMenuMapper.count();
        log.debug("count:{}", count);
    }

    @Test
    public void testList() {
        List<HamburgerListItemVO> list = shoppingCarMapper.list();
        for (HamburgerListItemVO item : list) {
            log.debug("item:{}", item);
        }
    }

    @Test
    public void testInsertOrder() {
        int rows = shoppingCarMapper.insertOrder();
        log.debug("rows 受引響行數:{}", rows);
    }

    @Test
    public void testDeleteByData() {
        int rows = shoppingCarMapper.deleteByData();
        log.debug("rows 受引響行數:{}", rows);
    }

    @Test
    public void testGetCommodityName() {
        Integer id = 213;
        HamburgerRemoveVO hamburgerRemoveVO = menuListMapper.getCommodityName(id);

        log.debug("rows 數據:{}", hamburgerRemoveVO);
    }


    @Test
    public void testUpdateOrderNumber() {

        HamburgerNumber hamburgerNumber = new HamburgerNumber();
        hamburgerNumber.setOrdernumber(1);
        int rows = shoppingCarMapper.updateOrderNumber(hamburgerNumber);
        log.debug("rows 受引響行數:{}", rows);

    }

    @Test
    public void testAddMenu() {

        HamburgerAddMenu hamburgerAddMenu = new HamburgerAddMenu();

        hamburgerAddMenu.setDescride("444");
        hamburgerAddMenu.setRecommend(1.5);
        hamburgerAddMenu.setUnitprice(300);
        int rows = addMenuMapper.insertAddMenu(hamburgerAddMenu);
        log.debug("rows 受引響行數:{}", rows);

    }


    @Test
    public void testListMenu() {
        List<HamburgerListMenuVO> list = hamburgerMenuMapper.listMenu();
        for (HamburgerListMenuVO item : list) {
            log.debug("item:{}", item);
        }
    }


    @Test
    public void testcountByName() {
        String name = "file8.png";
        int rows = menuListMapper.countByName(name);
        log.debug("受影響的行數:{}", rows);

    }
}
