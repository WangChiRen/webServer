package com.hamburger.hamburger.service;

import com.hamburger.hamburger.pojo.dto.ForgetPasswordDTO;
import org.springframework.transaction.annotation.Transactional;

/**
 * ForgetPasswordServiceImpl業務層接口
 */
public interface IForgetPasswordService {

    /**
     * 根據 account 修改 ams_admin 表中的密碼數據
     */
    @Transactional(rollbackFor = {Exception.class})
    void updateForgetPassword(ForgetPasswordDTO forgetPasswordDTO);

}
