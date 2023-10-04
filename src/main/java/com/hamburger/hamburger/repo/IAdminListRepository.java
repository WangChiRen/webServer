package com.hamburger.hamburger.repo;


import com.hamburger.hamburger.pojo.vo.AdminListVO;


import java.util.List;

public interface IAdminListRepository  {

    String KEY_ADMIN_LIST = "admin:list";

    //存列表數據
    void putAdminList(List<AdminListVO> list);

    //取列表數據
    List<AdminListVO> adminList();

    //刪列表
    void deleteAdminList();
}
