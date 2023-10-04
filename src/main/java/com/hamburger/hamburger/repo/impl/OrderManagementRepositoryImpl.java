package com.hamburger.hamburger.repo.impl;

import com.hamburger.hamburger.pojo.vo.HamburgerListOrderVO;
import com.hamburger.hamburger.repo.IOrderManagementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;


import java.util.List;

@Slf4j
@Repository
public class OrderManagementRepositoryImpl extends SuperRepository<HamburgerListOrderVO> implements IOrderManagementRepository {

    public OrderManagementRepositoryImpl() {
        log.debug("OrderManagement數據訪問層對象.OrderManagementRepositoryImpl()");
    }

    @Override
    protected String getRedisKey() {
        return KEY_ORDER_MANAGEMENT;
    }

    @Override
    public void putOrderManagement(List<HamburgerListOrderVO> list) {

        log.debug("向Redis中寫入OrderManagement列表數據....{}", list);
        putData(list);
        log.debug("已經寫入List型資料到Redis");
    }

    @Override
    public List<HamburgerListOrderVO> orderManagement() {

        log.debug("向Redis中讀取OrderManagement列表數據....");
        List<HamburgerListOrderVO> hamburgerListOrderVO = getData();
        log.debug("從Redis中讀取OrderManagement列表數據:{}", hamburgerListOrderVO);
        return hamburgerListOrderVO;
    }

    @Override
    public void deleteOrderManagement() {
        deleteData();
    }
}
