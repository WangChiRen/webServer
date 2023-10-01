package com.hamburger.hamburger;


import com.hamburger.hamburger.mapper.*;
import com.hamburger.hamburger.pojo.entity.*;
import com.hamburger.hamburger.pojo.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class HamburgerMapperTests {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private AddMenuMapper addMenuMapper;

    @Autowired
    private HamburgerMenuMapper hamburgerMenuMapper;

    @Autowired
    private MenuListMapper menuListMapper;

    @Autowired
    private OrderManagementMapper orderManagementMapper;

    @Autowired
    private ShoppingCarMapper shoppingCarMapper;

    @Autowired
    private AddAdminMapper addAdminMapper;

    @Autowired
    private AdminListMapper adminListMapper;

    @Test
    public void testAddNew() {

        HamburgerMenu hamburger = new HamburgerMenu();
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
        MenuListUpdateMenu hamburgerUpdateMenu = new MenuListUpdateMenu();
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

        ShoppingCarNumber hamburgerNumber = new ShoppingCarNumber();
        hamburgerNumber.setOrdernumber(1);
        int rows = shoppingCarMapper.updateOrderNumber(hamburgerNumber);
        log.debug("rows 受引響行數:{}", rows);

    }

    @Test
    public void testAddMenu() {

        AddMenu hamburgerAddMenu = new AddMenu();

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

    @Test
    void testGetByAccount() {
        String account = "B001";
        LoginVO loginVO = loginMapper.getByAccount(account);
        log.debug("{}", loginVO);
    }

    @Test
    public void testAddAdminList() {
        List<AddAdminVO> list = addAdminMapper.addAdminList();
        for (AddAdminVO item : list) {
            log.debug("item:{}", item);
        }
    }

    @Test
    public void testAdminList() {
        List<AdminListVO> list = adminListMapper.adminList();
        for (AdminListVO item : list) {
            log.debug("item:{}", item);
        }
    }

    @Test
    public void testAddAdminRole() {
        String description = "經理";
        AddAdminDescriptionVO byDescriptionId = addAdminMapper.getByDescriptionId(description);
        log.debug("byDescriptionId:{}", byDescriptionId);
    }


}
