package com.example.dibootdemo.config;

import com.example.dibootdemo.filter.CustomCorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 解决跨域问题
 */
@Configuration
public class CorsConfig{
    // 初始化filter
    @Bean
    public FilterRegistrationBean<CustomCorsFilter> customCorsFilter(){
        FilterRegistrationBean<CustomCorsFilter> registrationBean = new FilterRegistrationBean<>(new CustomCorsFilter());
        //过滤所有路径
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
