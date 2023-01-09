package com.example.dibootdemo.handler;

import com.diboot.core.handler.DefaultExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 通用异常处理类
 * @author 刘长卿
 * @version 1.0
 * @date 2023-01-07
 * Copyright © 刘长卿
 */
@ControllerAdvice
@Slf4j
public class GeneralExceptionHandler extends DefaultExceptionHandler{

}