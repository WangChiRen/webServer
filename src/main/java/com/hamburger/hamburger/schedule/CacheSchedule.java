package com.hamburger.hamburger.schedule;

import com.hamburger.hamburger.mapper.*;
import com.hamburger.hamburger.pojo.vo.*;
import com.hamburger.hamburger.repo.*;
import com.hamburger.hamburger.repo.impl.SuperRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 定期更新數據組件類
 */
@Slf4j
@Component
public class CacheSchedule {

    @Autowired
    private AdminListMapper adminListMapper;

    @Autowired
    private IAdminListRepository adminListRepository;

    @Autowired
    private AddAdminMapper  addAdminMapper;

    @Autowired
    private IAddAdminRepository addAdminRepository;

    @Autowired
    private HamburgerMenuMapper hamburgerMenuMapper;

    @Autowired
    private IHamburgerMenuRepository hamburgerMenuRepository;

    @Autowired
    private MenuListMapper menuListMapper;

    @Autowired
    private IMenuListRepository menuListRepository;

    @Autowired
    private OrderManagementMapper orderManagementMapper;

    @Autowired
    private IOrderManagementRepository orderManagementRepository;

    public CacheSchedule() {
        log.debug("創建計畫任務對象:CacheSchedule");
    }

    //一分鐘執行一次該方法
    @Scheduled(fixedRate = 10 * 1000)
    public void updateCache() {
        log.debug("執行計畫任務方法");

        //將Redis中的列表刪除否則數據會重複
        adminListRepository.deleteAdminList();
        addAdminRepository.deleteAddAdmin();
        hamburgerMenuRepository.deleteHamburgerMenu();
        menuListRepository.deleteMenuList();
        orderManagementRepository.deleteOrderManagement();

        //從MySQL讀取 ams_admin 表
        List<AdminListVO> adminListVOS = adminListMapper.adminList();
        //從MySQL讀取 ams_role 表
        List<AddAdminVO>  addAdminVOS = addAdminMapper.addAdminList();
        //從MySQL讀取 hamburger_menu 表
        List<HamburgerListMenuVO> hamburgerListMenuVOS = hamburgerMenuMapper.listMenu();
        //從MySQL讀取 add_menu 表
        List<HamburgerListEditMenuVO> hamburgerListEditMenuVOS = menuListMapper.listEditMenu();
        //從MySQL讀取  hamburger_order 表
        List<HamburgerListOrderVO> hamburgerListOrderVOS = orderManagementMapper.listOrder();

        //將 ams_admin 表寫入到 Redis
        adminListRepository.putAdminList(adminListVOS);
        //將 ams_role 表寫入到 Redis
        addAdminRepository.putAddAdmin(addAdminVOS);
        //將 hamburger_menu 表寫入到 Redis
        hamburgerMenuRepository.putHamburgerMenu(hamburgerListMenuVOS);
        //將 add_menu 表寫入到 Redis
        menuListRepository.putMenuList(hamburgerListEditMenuVOS);
        //將 hamburger_order 表寫入到 Redis
        orderManagementRepository.putOrderManagement(hamburgerListOrderVOS);
    }

}
