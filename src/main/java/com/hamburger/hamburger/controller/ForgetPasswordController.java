package com.hamburger.hamburger.controller;


import com.hamburger.hamburger.pojo.dto.ForgetPasswordDTO;
import com.hamburger.hamburger.service.IForgetPasswordService;
import com.hamburger.hamburger.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器層:負責接收前端 ForgetPasswordView 的請求與響應
 */
@Slf4j
@RestController
@RequestMapping("/hamburgers")
public class ForgetPasswordController {

    @Autowired
    private IForgetPasswordService forgetPasswordService;

    /**
     * 根據 account 修改 ams_admin 表中的密碼數據
     *
     * @param forgetPasswordDTO 修改密碼數據
     */
    @PostMapping("/update-password")
    public JsonResult updateForgetPassword(@RequestBody @Validated ForgetPasswordDTO forgetPasswordDTO) {

        log.debug("開始處理:ForgetPasswordController.updateForgetPassword()");
        forgetPasswordService.updateForgetPassword(forgetPasswordDTO);
        return JsonResult.ok();
    }




}
