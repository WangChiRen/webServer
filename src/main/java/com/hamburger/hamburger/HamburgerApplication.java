package com.hamburger.hamburger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class HamburgerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HamburgerApplication.class, args);
    }

}
