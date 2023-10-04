package com.hamburger.hamburger.repo.impl;

import com.hamburger.hamburger.pojo.vo.AdminListVO;
import com.hamburger.hamburger.repo.IAdminListRepository;
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
public class AdminListRepositoryImpl extends SuperRepository<AdminListVO> implements IAdminListRepository {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    public AdminListRepositoryImpl() {
        log.debug("AdminList數據訪問層對象.AdminListRepositoryImpl()");
    }

    @Override
    protected String getRedisKey() {
        return KEY_ADMIN_LIST;
    }

    @Override
    public void putAdminList(List<AdminListVO> list) {

        log.debug("向Redis中寫入AdminList列表數據....{}", list);

       putData(list);
        log.debug("已經寫入List型資料到Redis");

    }

    @Override
    public List<AdminListVO> adminList() {

        log.debug("向Redis中讀取AdminList列表數據....");
        List<AdminListVO> adminListVO = getData();
        log.debug("從Redis中讀取AdminList列表數據:{}", adminListVO);

        return adminListVO;
    }

    @Override
    public void deleteAdminList() {
        deleteData();
    }


}
