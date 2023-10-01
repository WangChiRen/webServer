package com.hamburger.hamburger.service;

import com.hamburger.hamburger.pojo.dto.ForgetPasswordDTO;

/**
 * ForgetPasswordServiceImpl業務層接口
 */
public interface IForgetPasswordService {

    /**
     * 根據 account 修改 ams_admin 表中的密碼數據
     */
    void updateForgetPassword(ForgetPasswordDTO forgetPasswordDTO);

}
