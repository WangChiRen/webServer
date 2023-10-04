package com.hamburger.hamburger.service.impl;

import com.hamburger.hamburger.ex.ServiceException;
import com.hamburger.hamburger.mapper.ForgetPasswordMapper;
import com.hamburger.hamburger.pojo.dto.ForgetPasswordDTO;
import com.hamburger.hamburger.pojo.entity.ForgetPassword;
import com.hamburger.hamburger.pojo.vo.*;
import com.hamburger.hamburger.service.IForgetPasswordService;
import com.hamburger.hamburger.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 業務層:負責處理前端 ForgetPasswordView 的業務邏輯
 */
@Slf4j
@Service
public class ForgetPasswordServiceImpl implements IForgetPasswordService {

    @Autowired
    private ForgetPasswordMapper forgetPasswordMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 根據 account 修改 ams_admin 表中的密碼數據
     */

    public void updateForgetPassword(ForgetPasswordDTO forgetPasswordDTO) {
        log.debug("開始處理忘記密碼頁的數據業務,數據={}", forgetPasswordDTO);

        //檢查密碼數據是否存在
        ForgetPasswordVO forgetPasswordVO = forgetPasswordMapper.getAdmin(forgetPasswordDTO.getAccount());

        if (forgetPasswordVO == null) {
            String message = "修改密碼失敗,修改的帳號不存在";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        } else {

            // 創建實體對象
            ForgetPassword forgetPassword = new ForgetPassword();
            // BeanUtils.copyProperties(hamburgerAddNewDTO,hamburger);
            //轉換對象(數據源,複製到哪)
            //將當前方法參數的屬性值複製到實體類的屬性中
            BeanUtils.copyProperties(forgetPasswordDTO, forgetPassword);

            //將原密碼從 forgetPassword 對象中取出
            String rawPassword = forgetPassword.getPassword();

            //通過 Security 的 passwordEncoder 中的 encode 方法將原密碼 (rawPassword) 做加密
            String encodePassword = passwordEncoder.encode(rawPassword);

            //將加密過後的密碼 (encodePassword) 存回至 forgetPassword 對象中
            forgetPassword.setPassword(encodePassword);

            //根據 account 修改數據
            int rows = forgetPasswordMapper.updateForgetPassword(forgetPassword);
            log.debug("受影響的行數:{}", rows);

            if (rows != 1) {
                String message = "修改失敗,請稍後重試";
                throw new ServiceException(ServiceCode.ERR_UPDATE, message);
            }
        }
    }
}
