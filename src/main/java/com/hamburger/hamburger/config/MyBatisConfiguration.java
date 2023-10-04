package com.hamburger.hamburger.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/*
* 指定要變成實現類的接口所在的包
*/
@Configuration
@MapperScan("com.hamburger.hamburger.mapper")
public class MyBatisConfiguration {


}
