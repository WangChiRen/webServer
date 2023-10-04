package com.hamburger.hamburger.service.impl;


import com.hamburger.hamburger.mapper.OrderManagementMapper;
import com.hamburger.hamburger.pojo.vo.HamburgerListOrderVO;
import com.hamburger.hamburger.repo.IOrderManagementRepository;
import com.hamburger.hamburger.service.IOrderManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 業務層:負責處理前端 OrderManagementView 的業務邏輯
 */
@Slf4j
@Service
public class OrderManagementServiceImpl implements IOrderManagementService {


    @Autowired
    private OrderManagementMapper orderManagementMapper;

    @Autowired
    private IOrderManagementRepository orderManagementRepository;


    public List<HamburgerListOrderVO> listOrder() {
        log.debug("開始處理查詢hamburgerorder表中的業務");
        return orderManagementRepository.orderManagement();
    }
}
