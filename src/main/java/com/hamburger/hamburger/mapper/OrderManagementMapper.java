package com.hamburger.hamburger.mapper;


import com.hamburger.hamburger.pojo.vo.HamburgerListOrderVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OrderManagementMapper 接口
 */
@Repository
public interface OrderManagementMapper {


    /**
     * 查詢order列表數據
     *
     * @return 列表數據
     */
    List<HamburgerListOrderVO> listOrder();
}
