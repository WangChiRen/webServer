package com.hamburger.hamburger.repo.impl;

import com.hamburger.hamburger.pojo.vo.AddAdminVO;
import com.hamburger.hamburger.pojo.vo.AdminListVO;
import com.hamburger.hamburger.pojo.vo.HamburgerListMenuVO;
import com.hamburger.hamburger.repo.IHamburgerMenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class HamburgerMenuRepositoryImpl extends SuperRepository<HamburgerListMenuVO> implements IHamburgerMenuRepository {



    public HamburgerMenuRepositoryImpl() {
        log.debug("HamburgerMenu數據訪問層對象.HamburgerMenuRepositoryImpl()");
    }

    @Override
    protected String getRedisKey() {
        return KEY_HAMBURGER_MENU;
    }


    @Override
    public void putHamburgerMenu(List<HamburgerListMenuVO> list) {

        log.debug("向Redis中寫入HamburgerMenu列表數據....{}", list);
        putData(list);
        log.debug("已經寫入List型資料到Redis");
    }

    @Override
    public List<HamburgerListMenuVO> hamburgerMenu() {

        log.debug("向Redis中讀取HamburgerMenu列表數據....");

        List<HamburgerListMenuVO> hamburgerListMenuVO = getData();
        log.debug("從Redis中讀取HamburgerMenu列表數據:{}", hamburgerListMenuVO);

        return hamburgerListMenuVO;
    }

    @Override
    public void deleteHamburgerMenu() {

        deleteData();
    }
}
