package com.example.dibootdemo.filter;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 定义跨域filter

public class CustomCorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 告诉浏览器允许所有的域访问
        // 注意 * 不能满足带有cookie的访问,Origin 必须是全匹配
        // resp.addHeader("Access-Control-Allow-Origin", "*");
        // 解决办法通过获取Origin请求头来动态设置
        String origin = request.getHeader("Origin");
        if (StringUtils.hasText(origin)) {
            resp.addHeader("Access-Control-Allow-Origin", "*");
        }
        // 允许带有cookie访问
        resp.addHeader("Access-Control-Allow-Credentials", "true");

        // 告诉浏览器允许跨域访问的方法
        resp.addHeader("Access-Control-Allow-Methods", "*");
        // 设置支持所有的自定义请求头
        String headers = request.getHeader("Access-Control-Request-Headers");
        if (StringUtils.hasText(headers)) {
            resp.addHeader("Access-Control-Allow-Headers", headers);
        }
        // 告诉浏览器缓存OPTIONS预检请求1小时,避免非简单请求每次发送预检请求,提升性能
        resp.addHeader("Access-Control-Max-Age", "3600");
        // 暴露响应头authorization
        resp.setHeader("Access-Control-Expose-Headers", "authorization");
        chain.doFilter(request, resp);
    }
}

