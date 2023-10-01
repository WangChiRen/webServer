package com.hamburger.hamburger.security;

import com.hamburger.hamburger.mapper.LoginMapper;
import com.hamburger.hamburger.pojo.vo.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginMapper loginMapper;

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        log.debug("Spring Security 自動根據帳號:{},查詢用戶詳情", account);

        LoginVO loginVO = loginMapper.getByAccount(account);

        log.debug("查詢到的結果:{}", loginVO);

        if (loginVO != null) {

            List<String> permissions = loginVO.getPermissions();
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for (String permission : permissions) {
                authorities.add(new SimpleGrantedAuthority(permission));
            }

            AdminDetails adminDetails = new AdminDetails(
                    loginVO.getAccount(), //帳號
                    loginVO.getPassword(), //密碼
                    loginVO.getEnable() == 1, //帳號是否禁用
                    authorities //權限訊息
            );

            adminDetails.setId(loginVO.getId());

            return adminDetails;

        }

        return null;
    }
}
