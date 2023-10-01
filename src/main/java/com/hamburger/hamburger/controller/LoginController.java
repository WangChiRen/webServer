package com.hamburger.hamburger.controller;


import com.hamburger.hamburger.pojo.dto.LoginDTO;
import com.hamburger.hamburger.service.ILoginService;
import com.hamburger.hamburger.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 控制器層:負責接收前端 LoginView 的請求與響應
 */
@Slf4j
@RestController
@RequestMapping("/hamburgers")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    /**
     * 根據id刪除 ams 表內的數據
     *
     * @param loginDTO 訂單的id
     */
    @PostMapping("/login")
    public JsonResult login(@RequestBody @Validated LoginDTO loginDTO) {
        log.debug("開始處理:LoginController.login()");
        String jwt = loginService.login(loginDTO);
        return JsonResult.ok(jwt);
    }



}
