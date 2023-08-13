package com.hamburger.hamburger.mapper;
import com.hamburger.hamburger.pojo.entity.Hamburger;
import com.hamburger.hamburger.pojo.entity.HamburgerNumber;
import com.hamburger.hamburger.pojo.entity.HamburgerUpdate;
import com.hamburger.hamburger.pojo.vo.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Mapper接口
 */
@Repository
public interface HamburgerMapper {

    /**
     * 插入數據給到購物車
     * @param hamburger 前端給的數據
     * @return 受引響行數
     */
    int insert(Hamburger hamburger);

    /**
     * 插入所有數據給到Order
     * @return 受引響行數
     */
    int insertOrder();

    /**
     *根據id刪除購物車內數據
     * @param id 購物車內的id
     * @return 受引響行數
     */
    int deleteById(Integer id);

    /**
     *刪除全部的訂單數據
     * @return 受引響行數
     */
    int deleteByData();

    /**
     * 使用一個方法 實現多種不同數據更新(想更新那些字段更新那些字段 不想更新的字段保持不變)
     * @param hamburger 不同的數據
     * @return 受引響行數
     */
    int updateById(HamburgerUpdate hamburger);


    /**
     * 修改orderNumber數據
     * @param  hamburgerNumber 修改orderNumber的數據
     * @return 受引響行數
     */
    int updateOrderNumber(HamburgerNumber hamburgerNumber);


    /**
     * 查詢menu列表數據
     * @return 列表數據
     */
    List<HamburgerListItemVO> list();


    /**
     * 查詢order列表數據
     * @return 列表數據
     */
    List<HamburgerListOrderVO> listOrder();


    /**
     *統計所有數據量
     * @return 數據數量
     */
    int count();


    /**
     * 根據id查訂單數據
     *
     * @param id 定單id
     * @return 訂單詳情
     */
    HamburgerDetailVO getById(Integer id);


    /**
     * 根據id查詢要修改的訂單數據
     *
     * @param id 商品id
     * @return 商品详情
     */
   HamburgerUpdateDetailVO getUpdateById(Integer id);


}
