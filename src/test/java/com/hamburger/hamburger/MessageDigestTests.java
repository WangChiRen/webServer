package com.hamburger.hamburger;


import com.hamburger.hamburger.validation.AddAdminValidationConst;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
@Slf4j
public class MessageDigestTests {

    @Test
    public void testMatches() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "A002";
        String encodePassword = "$2a$10$z2OnWScAlWdQkHG4Pri6gu3takXcXZ6ssrQm3TPwIBQZsneQXH/KO";
        boolean b = passwordEncoder.matches(rawPassword, encodePassword);
        log.debug("驗證結果:{}",b);

    }

    @Test
    public void testDescription(){
        String description = "超級管理"; // 或其他角色描述
        if (description.matches(AddAdminValidationConst.PATTERN_REGEXP_DESCRIPTION)) {
            System.out.println("角色描述有效");
        } else {
            System.out.println("角色描述無效");
        }

    }
}
