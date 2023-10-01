package com.hamburger.hamburger.mapper;

import com.hamburger.hamburger.pojo.entity.ForgetPassword;
import com.hamburger.hamburger.pojo.vo.ForgetPasswordVO;
import org.springframework.stereotype.Repository;

/**
 * ForgetPassword 接口
 */
@Repository
public interface ForgetPasswordMapper {

    /**
     * 根據 account 修改 ams_admin 表中的密碼數據
     *
     * @param forgetPassword 帳號,密碼數據
     * @return 受影響行數
     */
    int updateForgetPassword(ForgetPassword forgetPassword);


    /**
     * 根據 account 查詢 ams_admin 表內的數據
     *
     * @param account 帳號數據
     * @return 數據詳情
     */
    ForgetPasswordVO getAdmin(String account);


}
