package com.example.usercenter.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ZXN on 2018/7/5.
 */
@Configuration
@MapperScan("com.example.usercenter.*.dao")
public class MybatisConfig {
}
