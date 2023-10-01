package com.hamburger.hamburger.mapper;



import com.hamburger.hamburger.pojo.entity.AddAdmin;
import com.hamburger.hamburger.pojo.entity.AddAdminRole;
import com.hamburger.hamburger.pojo.vo.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AddAdminMapper 接口
 */
@Repository
public interface AddAdminMapper {

    /**
     *
     * @param addAdmin 添加員工數據
     * @return 受引響行數
     */
    int insertAddAdmin(AddAdmin addAdmin);

    /**
     *
     * @param addAdminRole 添加 ams_admin 中id對應的權限數據
     * @return 受引響行數
     */
    int insertAddAdminRole(AddAdminRole addAdminRole);

    /**
     * 根據 account 查詢 ams_admin 表內的數據id
     *
     * @param account ams_admin 表中添加數據的 username
     * @return id數據
     */
    AddAdminRoleVO getByAccountId(String account);

    /**
     * 根據 name 查詢 ams_role 表內的數據id
     *
     * @param name ams_role 表中添加數據的 name
     * @return id數據
     */
    AddAdminDescriptionVO getByDescriptionId(String name);

    /**
     * 查詢 ams_role 列表數據
     *
     * @return 列表數據
     */
    List<AddAdminVO> addAdminList();

    /**
     * 根據 account 查詢 ams_admin 表內的數據
     *
     * @param account account 數據
     * @return 全部數據
     */
    AddAdminAccountVO getAdminAccount(String account);

    /**
     * 根據 phone 查詢 ams_admin 表內的數據
     *
     * @param phone phone 數據
     * @return 全部數據
     */
    AddAdminAccountVO getAdminPhone(String phone);

    /**
     * 根據 mail 查詢 ams_admin 表內的數據
     *
     * @param mail mail 數據
     * @return 全部數據
     */
    AddAdminAccountVO getAdminMail(String mail);

}
