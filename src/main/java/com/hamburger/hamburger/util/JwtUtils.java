package com.hamburger.hamburger.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    /**
     * 簽名密鑰
     */
    private static final String SECRET_KEY = "qwerdf";

    /**
     * 過期時間：以分鐘為單位
     */
    private static final long EXPIRED_IN_MINUTE = 24 * 60;

    /**
     * 私有化構造方法,禁止new對象
     */
    private JwtUtils(){}

    /**
     * 生成JWT
     * @param claims 希望在JWT中封装的數據
     * @return JWT字符串
     */
    public static String generate(Map<String, Object> claims) {

        //JWT過期時間(1天)
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRED_IN_MINUTE * 60 * 1000);

        // JWT組成部分:
        // (Header)頭
        // 用於配置演算法與結果資料類型
        // (Payload)載重
        // 用於配置需要封裝到JWT中的數據
        // (Signature)簽名
        // 用於指定演算法與金鑰(鹽值)
        String jwt = Jwts.builder()
                // Header: typ-型，alg-演算法
                .setHeaderParam("typ", "jwt")
                .setHeaderParam("alg", "HS256")
                // Payload
                .setClaims(claims)
                .setExpiration(expirationDate)
                // Signature
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();// 打包

        return jwt;
    }

    /**
     * 解析JWT
     * @param jwt JWT數據
     * @return 解析等到的Claims，其中封装了生成JWT時所存入的數據
     */
    public static Claims parse(String jwt){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt).getBody();
    }

}
