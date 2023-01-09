package com.example.dibootdemo.service.impl;


import com.diboot.core.service.impl.BaseServiceImpl;
import com.example.dibootdemo.mapper.CompanyCountMapper;
import com.example.dibootdemo.entity.CompanyCount;
import com.example.dibootdemo.service.CompanyCountService;
import org.springframework.stereotype.Service;


/**
 * (CompanyCount)表服务实现类
 *
 * @author 刘长卿
 * @since 2023-01-09 15:13:34
 */
@Service
public class CompanyCountServiceImpl extends BaseServiceImpl<CompanyCountMapper, CompanyCount> implements CompanyCountService {
    
}
