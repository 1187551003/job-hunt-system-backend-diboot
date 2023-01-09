package com.example.dibootdemo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SpringMvc配置类
 *
 * @author 刘长卿
 * @since 2023-01-04 18:51:18
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages={"com.example"})
@MapperScan(basePackages={"com.example.dibootdemo.mapper"})
public class SpringMvcConfig {

}
