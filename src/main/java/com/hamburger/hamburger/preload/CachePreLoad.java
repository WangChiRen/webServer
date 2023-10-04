package com.hamburger.hamburger.preload;

import com.hamburger.hamburger.mapper.AdminListMapper;
import com.hamburger.hamburger.pojo.vo.AdminListVO;
import com.hamburger.hamburger.repo.IAdminListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 緩存預熱組件類
 */

//@Component
//public class CachePreLoad implements ApplicationRunner {
//
//    @Autowired
//    private AdminListMapper adminListMapper;
//
//    @Autowired
//    private IAdminListRepository adminListRepository;
//
//    public CachePreLoad() {
//        log.debug("創建啟動自動執行方法的ApplicationRunner對象:CachePreLoad");
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        log.debug("執行CachePreLoad.run方法");
//
//        //將Redis中的列表刪除否則數據會重複
//        adminListRepository.deleteList();
//
//        //從MySQL讀取 ams_admin 表
//        List<AdminListVO> list = adminListMapper.adminList();
//
//        //將 ams_admin 表寫入到 Redis
//        adminListRepository.putList(list);
//
//
//    }
//}
