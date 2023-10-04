package com.hamburger.hamburger.service.impl;


import com.hamburger.hamburger.ex.ServiceException;

import com.hamburger.hamburger.mapper.HamburgerMenuMapper;
import com.hamburger.hamburger.pojo.dto.HamburgerMenuAddNewDTO;
import com.hamburger.hamburger.pojo.entity.HamburgerMenu;
import com.hamburger.hamburger.pojo.vo.HamburgerListMenuVO;
import com.hamburger.hamburger.repo.IHamburgerMenuRepository;
import com.hamburger.hamburger.service.IHamburgerMenuService;
import com.hamburger.hamburger.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 業務層:負責處理前端 HamburgerMenuView 的業務邏輯
 */
@Slf4j
@Service
public class HamburgerMenuServiceImpl implements IHamburgerMenuService {


    @Autowired
    private HamburgerMenuMapper hamburgerMenuMapper;

    @Autowired
    private IHamburgerMenuRepository hamburgerMenuRepository;



    public void addNew(@RequestBody HamburgerMenuAddNewDTO hamburgerMenuAddNewDTO) {
        log.debug("開始處理:HamburgerMenuServiceImpl.addNew(),參數:{}", hamburgerMenuAddNewDTO);
        int counts = hamburgerMenuMapper.count();

        if (counts >= 12) {
            String message = "添加失敗,訂單最多不可超過12筆";
            throw new ServiceException(ServiceCode.ERR_EXCEED, message);
        } else {
            // 創建實體對象
            HamburgerMenu hamburgerMenu = new HamburgerMenu();
            // BeanUtils.copyProperties(hamburgerAddNewDTO,hamburger);
            //轉換對象(數據源,複製到哪)
            //將當前方法參數的屬性值複製到實體類的屬性中
            BeanUtils.copyProperties(hamburgerMenuAddNewDTO, hamburgerMenu);
            //將訂單號設定為0
            hamburgerMenu.setOrdernumber(0);
            // 將管理員信息寫入到數據庫
            int rows = hamburgerMenuMapper.insert(hamburgerMenu);
            //int a = 1/0;
            if (rows != 1) {
                String message = "添加失敗,請稍後重試";
                throw new ServiceException(ServiceCode.ERR_INSERT, message);
            }
        }
    }



    public List<HamburgerListMenuVO> listMenu() {
        log.debug("開始處理:HamburgerMenuServiceImpl.addNew()");
        return hamburgerMenuRepository.hamburgerMenu();
    }



}
