package com.hamburger.hamburger.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.hamburger.hamburger.mapper")
public class MyBatisConfiguration {


}
