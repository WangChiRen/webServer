package com.hamburger.hamburger.service;


import com.hamburger.hamburger.ex.ServiceException;
import com.hamburger.hamburger.mapper.HamburgerMapper;
import com.hamburger.hamburger.pojo.dto.HamburgerAddNewDTO;
import com.hamburger.hamburger.pojo.dto.HamburgerUpdateByIdDTO;
import com.hamburger.hamburger.pojo.dto.HamburgerUpdateOrderNumberDTO;
import com.hamburger.hamburger.pojo.entity.Hamburger;
import com.hamburger.hamburger.pojo.entity.HamburgerNumber;
import com.hamburger.hamburger.pojo.entity.HamburgerUpdate;
import com.hamburger.hamburger.pojo.vo.*;
import com.hamburger.hamburger.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * 業務層:負責處理業務邏輯
 */
@Slf4j
@Service
public class HamburgerServiceImpl implements IHamburgerService {

    @Autowired
    private HamburgerMapper hamburgerMapper;


    @Override
    public void addNew(@RequestBody HamburgerAddNewDTO hamburgerAddNewDTO) {
        log.debug("開始處理添加訂單業務,參數:{}", hamburgerAddNewDTO);
        int counts = hamburgerMapper.count();

        if (counts == 12) {
            String message = "添加失敗,訂單最多不可超過12筆";
            throw new ServiceException(ServiceCode.ERR_EXCEED, message);
        } else {
            // 創建實體對象
            Hamburger hamburger = new Hamburger();
            // BeanUtils.copyProperties(hamburgerAddNewDTO,hamburger);
            //轉換對象(數據源,複製到哪)
            //將當前方法參數的屬性值複製到實體類的屬性中
            BeanUtils.copyProperties(hamburgerAddNewDTO, hamburger);
            hamburger.setOrdernumber(0);
            // 將管理員信息寫入到數據庫
            int rows = hamburgerMapper.insert(hamburger);
            if (rows != 1) {
                String message = "添加失敗,請稍後重試";
                throw new ServiceException(ServiceCode.ERR_INSERT, message);
            }
        }
    }

    @Override
    public void addOrder() {
        log.debug("開始處理添加訂單業務至Order的操作");
        int rows = hamburgerMapper.insertOrder();
        if (rows == 0) {
            String message = "訂單送出失敗,請稍後重試,[錯誤碼:1]";
            throw new ServiceException(ServiceCode.ERR_INSERT_ORDER, message);
        }
    }

    public void deleteById(Integer id) {
        log.debug("開始刪除訂單業務,id={}", id);

        HamburgerDetailVO hamburger = hamburgerMapper.getById(id);

        if (hamburger == null) {
            String message = "刪除數據失敗,刪除的訂單(id=" + id + ")不存在";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        int rows = hamburgerMapper.deleteById(id);
        if (rows != 1) {
            String message = "刪除訂單失敗,服務器忙,請稍後重試";
            throw new ServiceException(ServiceCode.ERR_DELETE, message);
        }
    }


    public void deleteByData() {
        log.debug("開始刪除全部的訂單業");
        int rows = hamburgerMapper.deleteByData();
        log.debug("rows:{}", rows);
        if (rows < 1) {
            String message = "點餐失敗,服務器忙,請稍後重試";
            throw new ServiceException(ServiceCode.ERR_DELETE_ALLDATA, message);
        }

    }


    @Override
    public void updateById(HamburgerUpdateByIdDTO hamburgerUpdateByIdDTO, Integer id) {
        log.debug("開始編輯訂單業務,id={},數據:{}", id, hamburgerUpdateByIdDTO);

        //檢查數據是否存在
        HamburgerUpdateDetailVO hamburgerUpdateDetailVO = hamburgerMapper.getUpdateById(id);
        if (hamburgerUpdateDetailVO == null) {
            String message = "修改數據失敗,修改的訂單(id=" + id + ")不存在";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        } else {
            // 創建實體對象
            HamburgerUpdate hamburger = new HamburgerUpdate();
            // BeanUtils.copyProperties(hamburgerAddNewDTO,hamburger);
            //轉換對象(數據源,複製到哪)
            //將當前方法參數的屬性值複製到實體類的屬性中
            BeanUtils.copyProperties(hamburgerUpdateByIdDTO, hamburger);

            log.debug("開始編輯,id={},數據:{}", id, hamburger);
            log.debug("hamburgerUpdate.getTotal():{}", hamburger.getTotal());
            log.debug("hamburgerUpdate.getQuantity():{}", hamburger.getQuantity());
            hamburger.setId(id);
            hamburger.setTotal(hamburger.getTotal());
            hamburger.setQuantity(hamburger.getQuantity());
            //根據id修改數據
            int rows = hamburgerMapper.updateById(hamburger);
            log.debug("rows:{}", rows);
            if (rows != 1) {
                String message = "修改失敗,,請稍後重試";
                throw new ServiceException(ServiceCode.ERR_UPDATE, message);
            }
        }
    }

    @Override
    public void updateOrderNumber(HamburgerUpdateOrderNumberDTO hamburgerUpdateOrderNumberDTO) {
            log.debug("開始編輯OrderNumber的業務,數據:{}", hamburgerUpdateOrderNumberDTO);
            // 創建實體對象
            HamburgerNumber hamburgerNumber = new HamburgerNumber();

            // BeanUtils.copyProperties(hamburgerAddNewDTO,hamburger);
            //轉換對象(數據源,複製到哪)
            //將當前方法參數的屬性值複製到實體類的屬性中
            BeanUtils.copyProperties(hamburgerUpdateOrderNumberDTO, hamburgerNumber);
            hamburgerNumber.setOrdernumber(hamburgerNumber.getOrdernumber());
            int rows = hamburgerMapper.updateOrderNumber(hamburgerNumber);
            if (rows == 0) {
                String message = "添加訂單失敗,請聯繫管理員";
                throw new ServiceException(ServiceCode.ERR_UPDATE_NUMBER, message);
            }
    }


    @Override
    public List<HamburgerListItemVO> list() {
        log.debug("開始處理查詢hamburgermenu表中的業務");

        return hamburgerMapper.list();
    }

    @Override
    public List<HamburgerListOrderVO> listOrder() {
        log.debug("開始處理查詢hamburgerorder表中的業務");
        return hamburgerMapper.listOrder();
    }
}
