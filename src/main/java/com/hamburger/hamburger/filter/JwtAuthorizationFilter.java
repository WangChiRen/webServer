package com.hamburger.hamburger.filter;


import com.alibaba.fastjson.JSON;
import com.hamburger.hamburger.security.LoginPrincipal;
import com.hamburger.hamburger.util.JwtUtils;
import com.hamburger.hamburger.web.JsonResult;
import com.hamburger.hamburger.web.ServiceCode;
import com.sun.deploy.net.DownloadException;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.Expression;
import java.io.IOException;
import java.util.List;

/**
 * OncePerRequestFilter 確保一次請求只通過一次 filter
 */
@Slf4j
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.debug("執行JwtAuthorizationFilter過濾器.....");

        //清除Security的上下文
        //不清除,只要此錢存入過訊息,即使後續不攜帶JWT,上下文的訊息依然存在
        SecurityContextHolder.clearContext();
        log.debug("清除Security的上下文");

        //從請求頭當中獲取jwt
        String jwt = request.getHeader("Authorization");
        log.debug("從請求頭中獲取jwt數據:{}", jwt);

        //先判斷是否獲取到有效的 JWT 數據,若無 JWT 數據,直接放行(驗證,登入等)
        //hasText不為null,不為empty,包含文本
        if (!StringUtils.hasText(jwt)) {
            log.debug("請求頭中的JWT數據是無效的,直接放行");
            //放行
            filterChain.doFilter(request, response);
            return;
        }

        Claims claims = null;
        try {
            //如果獲取到了有效的 JWT,則嘗試進行解析
            claims = JwtUtils.parse(jwt);
        } catch (ExpiredJwtException e) {
            log.debug("解析JWT失敗,JWT過期{},{}", e.getClass().getName(), e.getMessage());
            abnormal(response, "ExpiredJwtException");
            return;
        } catch (SignatureException e) {
            log.debug("解析JWT失敗,JWT簽名錯誤{},{}", e.getClass().getName(), e.getMessage());
            abnormal(response, "SignatureException");
            return;
        } catch (MalformedJwtException e) {
            log.debug("解析JWT失敗，JWT數據有誤，{},{}", e.getClass().getName(), e.getMessage());
            abnormal(response, "MalformedJwtException");
            return;
        } catch (Throwable e) {
            log.debug("解析JWT失敗，錯誤詳情，{},{}", e.getClass().getName(), e.getMessage());
            abnormal(response, "Throwable");
            return;
        }

        Object id = claims.get("id");
        log.debug("從JWT中解析得到的id:{}", id);

        Object account = claims.get("account");
        log.debug("從JWT中解析得到的帳號:{}", account);

        LoginPrincipal loginPrincipal = new LoginPrincipal();
        loginPrincipal.setId(Integer.parseInt(id.toString()));
        loginPrincipal.setAccount(account.toString());

        //準備用戶權限 *********
        Object authoritiesString = claims.get("authorities");
        List<SimpleGrantedAuthority> authorities =
                JSON.parseArray(authoritiesString.toString(),SimpleGrantedAuthority.class);


        //當解析成功後,將相關的數據存到 Spring Security 的上下文中
        Authentication authentication = new UsernamePasswordAuthenticationToken(loginPrincipal, null, authorities);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        //放行
        filterChain.doFilter(request, response);
    }

    private static void abnormal(HttpServletResponse response, String methodName) throws IOException {
        String message = "登入訊息已過期,請重新登入";
        String message1 = "獲取登入訊息失效,請重新登入";

        //設定字符集
        response.setContentType("application/json; charset=utf-8");

        //JsonResult jsonResult = JsonResult.fail(ServiceCode.ERR_JWT_EXPIRED,message);
        //String jsonResultString = JSON.toJSONString(jsonResult);
        //response.setContentType("application/json; charset=utf-8");
        //response.getWriter().println(jsonResultString);

        if ("ExpiredJwtException".equals(methodName)) {
            //響應 JSON 格式字符串給前端,內容包含(業務狀態碼,錯誤訊息)
            response.getWriter().println(JSON.toJSONString(JsonResult.fail(ServiceCode.ERR_JWT_EXPIRED, message)));
        } else if ("SignatureException".equals(methodName) || "MalformedJwtException".equals(methodName) || "Throwable".equals(methodName)) {
            response.getWriter().println(JSON.toJSONString(JsonResult.fail(ServiceCode.ERR_JWT_INVALID, message1)));
        }
    }
}
