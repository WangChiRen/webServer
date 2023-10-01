package com.hamburger.hamburger.service.impl;


import com.alibaba.fastjson.JSON;
import com.hamburger.hamburger.mapper.LoginMapper;
import com.hamburger.hamburger.pojo.dto.LoginDTO;
import com.hamburger.hamburger.security.AdminDetails;
import com.hamburger.hamburger.service.ILoginService;
import com.hamburger.hamburger.util.JwtUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jdk.nashorn.internal.runtime.JSONFunctions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 業務層:負責處理前端 LoginView 的業務邏輯
 */
@Slf4j
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public String login(LoginDTO loginDTO) {
        log.debug("開始處理登入業務,參數:{}", loginDTO);
        //調用 Security 中的 Authentication 添加驗證訊息
        Authentication authentication =
                //將(帳號,密碼)傳入
                new UsernamePasswordAuthenticationToken(loginDTO.getAccount(), loginDTO.getPassword());

        //調用 authenticate() 方法做帳號密碼的驗證,查看返回結果相關訊息,類名與數據
        Authentication loginResult = authenticationManager.authenticate(authentication);

        //以上調用 authenticate() 方法實際會拋出異常,如果還能執行到此處,表示帳號與密碼是匹配的
        log.debug("登入成功:認證方法返回{}>>>>>{}", loginResult.getClass().getName(), loginResult);

        //從認證結果中 Principal,本質是User類型,是 UserDetailsService 中 loadUserByUsername() 的回傳結果
        log.debug("嘗試取得Principal:{}>>>{}", loginResult.getPrincipal().getClass().getName(), loginResult.getPrincipal());

        //取得登入成功的帳號
        AdminDetails adminDetails = (AdminDetails) loginResult.getPrincipal();

        Integer id = adminDetails.getId();
        log.debug("登入成功的id:{}", id);
        String account = adminDetails.getUsername();
        log.debug("登入成功的帳號:{}", account);
        Collection<GrantedAuthority> authorities = adminDetails.getAuthorities();
        log.debug("登入成功時的權限:{}",authorities);
        String authoritiesString = JSON.toJSONString(authorities);
        log.debug("權限轉換為JSON:{}",authoritiesString);

        //需要封裝到JWT中的數據
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",id);
        claims.put("account", account);
        claims.put("authorities", authoritiesString);

        //在此處生成 JWT,向JWT中存:id,account,權限
        String jwt = JwtUtils.generate(claims);

        log.debug("生成的Jwt數據:{}", jwt);

        return jwt;
    }
}
