package com.hamburger.hamburger.repo.impl;

import com.hamburger.hamburger.pojo.vo.AddAdminVO;
import com.hamburger.hamburger.pojo.vo.AdminListVO;
import com.hamburger.hamburger.pojo.vo.HamburgerListMenuVO;
import com.hamburger.hamburger.repo.IAddAdminRepository;
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
public class AddAdminRepositoryImpl extends SuperRepository<AddAdminVO> implements IAddAdminRepository {

    public AddAdminRepositoryImpl() {
        log.debug("AddAdmin數據訪問層對象.AddAdminRepositoryImpl()");
    }

    @Override
    protected String getRedisKey() {
        return KEY_ADD_ADMIN;
    }

    @Override
    public void putAddAdmin(List<AddAdminVO> list) {
        log.debug("向Redis中寫入AddAdmin列表數據....{}", list);

        putData(list);
        log.debug("已經寫入List型資料到Redis");
    }

    @Override
    public List<AddAdminVO> addAdmin() {
        log.debug("向Redis中讀取AddAdmin列表數據....");


        List<AddAdminVO> addAdminVO =getData();

        log.debug("從Redis中讀取AddAdmin列表數據:{}", addAdminVO);

        return addAdminVO;
    }

    @Override
    public void deleteAddAdmin() {
        deleteData();
    }
}
