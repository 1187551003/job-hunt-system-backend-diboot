package com.example.dibootdemo.handler;

import com.diboot.core.data.DefaultProtectFieldHandler;
import org.springframework.stereotype.Component;

/**
 * 自定义保护字段处理器
 */
@Component
public class CustomProtectFieldHandler extends DefaultProtectFieldHandler {
    // 父类中预置的加密脱敏实现不满足需求时，可override自定义
}
