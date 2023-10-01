package com.hamburger.hamburger.security;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Setter
@Getter
@EqualsAndHashCode
@ToString(callSuper = true)
public class AdminDetails extends User {

    private Integer id;

    public AdminDetails(String account, String password, boolean enable, Collection<? extends GrantedAuthority> authorities) {
        super(account, password, enable, true, true, true, authorities);

        //帳號
        //密碼
        //帳號是否禁用
        //帳號是否鎖定
        //帳號使否過期
        //認證是否過期
        //權限訊息
    }


}
