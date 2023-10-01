package com.hamburger.hamburger.service.impl;


import com.hamburger.hamburger.ex.ServiceException;
import com.hamburger.hamburger.mapper.ShoppingCarMapper;
import com.hamburger.hamburger.pojo.dto.ShoppingCarUpdateByIdDTO;
import com.hamburger.hamburger.pojo.dto.ShoppingCarUpdateOrderNumberDTO;
import com.hamburger.hamburger.pojo.entity.ShoppingCarNumber;
import com.hamburger.hamburger.pojo.entity.ShoppingCarUpdate;
import com.hamburger.hamburger.pojo.vo.HamburgerDetailVO;
import com.hamburger.hamburger.pojo.vo.HamburgerListItemVO;
import com.hamburger.hamburger.pojo.vo.HamburgerUpdateDetailVO;
import com.hamburger.hamburger.service.IShoppingCarService;
import com.hamburger.hamburger.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 業務層:負責處理前端 ShoppingCarView 的業務邏輯
 */
@Slf4j
@Service
public class ShoppingCarServiceImpl implements IShoppingCarService {


    @Autowired
    private ShoppingCarMapper shoppingCarMapper;


    @Transactional(rollbackFor = {Exception.class})
    public void addOrder() {
        log.debug("開始處理添加訂單業務至Order的操作");
        int rows = shoppingCarMapper.insertOrder();
        if (rows == 0) {
            String message = "訂單送出失敗,請稍後重試,[錯誤碼:1]";
            throw new ServiceException(ServiceCode.ERR_INSERT_ORDER, message);
        }
    }


    /**
     * 送出訂單後,刪除購物車內的訂單
     */
    @Transactional(rollbackFor = {Exception.class})
    public void deleteByData() {
        log.debug("開始刪除全部的訂單業務，因為送出訂單了");
        int rows = shoppingCarMapper.deleteByData();
        log.debug("rows:{}", rows);
        if (rows < 1) {
            String message = "點餐失敗,服務器忙,請稍後重試";
            throw new ServiceException(ServiceCode.ERR_DELETE_ALLDATA, message);
        }
    }


    /**
     * 根據id刪除購物車內的訂單
     */
    @Transactional(rollbackFor = {Exception.class})
    public void deleteById(Integer id) {
        log.debug("開始刪除購物車內的訂單業務,id={}", id);

        HamburgerDetailVO hamburger = shoppingCarMapper.getById(id);

        if (hamburger == null) {
            String message = "刪除購物車內的訂單失敗,刪除的訂單(id=" + id + ")不存在";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        int rows = shoppingCarMapper.deleteById(id);
        if (rows != 1) {
            String message = "刪除購物車內的訂單失敗,服務器忙,請稍後重試";
            throw new ServiceException(ServiceCode.ERR_DELETE, message);
        }
    }


    /**
     * 關閉或刷新瀏覽器時刪除全部訂單
     */
    @Transactional(rollbackFor = {Exception.class})
    public void deleteShoppingCartData() {
        log.debug("開始刪除全部的訂單業務，因為刷新或關閉瀏覽器了");
        int counts = shoppingCarMapper.count();

        if (counts >= 1) {
            int rows = shoppingCarMapper.deleteShoppingCartData();
            log.debug("受引響行數:{}", rows);
        }
    }


    @Transactional(rollbackFor = {Exception.class})
    public void updateById(ShoppingCarUpdateByIdDTO shoppingCarUpdateByIdDTO, Integer id) {
        log.debug("開始編輯訂單業務,數據:{}",shoppingCarUpdateByIdDTO);


        HamburgerUpdateDetailVO hamburgerUpdateDetailVO = shoppingCarMapper.getUpdateById(id);

        if (hamburgerUpdateDetailVO == null) {
            String message = "修改數據失敗,修改的訂單(id=" + id + ")不存在";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        } else {
            // 創建實體對象
            ShoppingCarUpdate shoppingCarUpdate = new ShoppingCarUpdate();
            // BeanUtils.copyProperties(hamburgerAddNewDTO,hamburger);
            //轉換對象(數據源,複製到哪)
            //將當前方法參數的屬性值複製到實體類的屬性中
            BeanUtils.copyProperties(shoppingCarUpdateByIdDTO, shoppingCarUpdate);

            log.debug("開始編輯,id={},數據:{}", id, shoppingCarUpdate);
            log.debug("hamburgerUpdate.getTotal():{}", shoppingCarUpdate.getTotal());
            log.debug("hamburgerUpdate.getQuantity():{}", shoppingCarUpdate.getQuantity());
            shoppingCarUpdate.setId(id);
            shoppingCarUpdate.setTotal(shoppingCarUpdate.getTotal());
            shoppingCarUpdate.setQuantity(shoppingCarUpdate.getQuantity());
            //根據id修改數據
            int rows = shoppingCarMapper.updateById(shoppingCarUpdate);
            log.debug("rows:{}", rows);
            if (rows != 1) {
                String message = "修改失敗,,請稍後重試";
                throw new ServiceException(ServiceCode.ERR_UPDATE, message);
            }
        }
    }


    @Transactional(rollbackFor = {Exception.class})
    public void updateOrderNumber(ShoppingCarUpdateOrderNumberDTO shoppingCarUpdateOrderNumberDTO) {
        log.debug("開始編輯OrderNumber的業務,數據:{}", shoppingCarUpdateOrderNumberDTO);
        // 創建實體對象
        ShoppingCarNumber shoppingCarNumber = new ShoppingCarNumber();

        // BeanUtils.copyProperties(hamburgerAddNewDTO,hamburger);
        //轉換對象(數據源,複製到哪)
        //將當前方法參數的屬性值複製到實體類的屬性中
        BeanUtils.copyProperties(shoppingCarUpdateOrderNumberDTO, shoppingCarNumber);
        shoppingCarNumber.setOrdernumber(shoppingCarNumber.getOrdernumber());
        int rows = shoppingCarMapper.updateOrderNumber(shoppingCarNumber);
        if (rows == 0) {
            String message = "添加訂單失敗,請聯繫管理員";
            throw new ServiceException(ServiceCode.ERR_UPDATE_NUMBER, message);
        }
    }


    @Transactional(rollbackFor = {Exception.class})
    public List<HamburgerListItemVO> list() {
        log.debug("開始處理查詢hamburgermenu表中的業務");

        return shoppingCarMapper.list();
    }
}
