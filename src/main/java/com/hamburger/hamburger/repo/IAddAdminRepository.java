package com.hamburger.hamburger.repo;

import com.hamburger.hamburger.pojo.vo.AddAdminVO;


import java.util.List;

public interface IAddAdminRepository  {

    String KEY_ADD_ADMIN = "add:admin";

    //存列表數據
    void putAddAdmin(List<AddAdminVO> list);

    //取列表數據
    List<AddAdminVO> addAdmin();

    //刪列表
    void deleteAddAdmin();


}
