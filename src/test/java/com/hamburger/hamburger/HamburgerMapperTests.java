package com.hamburger.hamburger;


import com.hamburger.hamburger.mapper.HamburgerMapper;
import com.hamburger.hamburger.pojo.entity.Hamburger;
import com.hamburger.hamburger.pojo.entity.HamburgerNumber;
import com.hamburger.hamburger.pojo.entity.HamburgerUpdate;
import com.hamburger.hamburger.pojo.vo.HamburgerListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class HamburgerMapperTests {

    @Autowired
    HamburgerMapper hamburgerMapper;


    @Test
    public void testAddNew() {

        Hamburger hamburger = new Hamburger();
        hamburger.setTotal(2000);
        int rows = hamburgerMapper.insert(hamburger);
        log.debug("rows 受引響行數:{}", rows);
        log.debug("hamburger 是:{}", hamburger.getTotal());

    }

    @Test
    public void testDeleteById() {

        Integer id = 206;
        int rows = hamburgerMapper.deleteById(id);
        log.debug("rows 受引響行數:{}", rows);
    }

    @Test
    public void testUpdateById() {
        Integer id = 95;
        HamburgerUpdate hamburgerUpdate = new HamburgerUpdate();
        hamburgerUpdate.setTotal(1500);
        hamburgerUpdate.setQuantity(5);


//        int rows = hamburgerMapper.updateById(hamburgerUpdate,id);
//        log.debug("rows 受引響行數:{}", rows);

    }

    @Test
    public void testCount() {
        int count = hamburgerMapper.count();
        log.debug("count:{}", count);
    }

    @Test
    public void testList() {
        List<HamburgerListItemVO> list = hamburgerMapper.list();
        for (HamburgerListItemVO item : list) {
            log.debug("item:{}", item);
        }
    }

    @Test
    public void testInsertOrder() {
        int rows = hamburgerMapper.insertOrder();
        log.debug("rows 受引響行數:{}", rows);
    }

    @Test
    public void testDeleteByData() {
        int rows = hamburgerMapper.deleteByData();
        log.debug("rows 受引響行數:{}", rows);
    }



    @Test
    public void testUpdateOrderNumber() {

        HamburgerNumber hamburgerNumber = new HamburgerNumber();
        hamburgerNumber.setOrdernumber(1);
        int rows = hamburgerMapper.updateOrderNumber(hamburgerNumber);
        log.debug("rows 受引響行數:{}", rows);

    }
}
