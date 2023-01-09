package com.example.dibootdemo.service.impl;


import com.diboot.core.service.impl.BaseServiceImpl;
import com.example.dibootdemo.mapper.KillCountMapper;
import com.example.dibootdemo.entity.KillCount;
import com.example.dibootdemo.service.KillCountService;
import org.springframework.stereotype.Service;


/**
 * (KillCount)表服务实现类
 *
 * @author 刘长卿
 * @since 2023-01-09 15:13:48
 */
@Service
public class KillCountServiceImpl extends BaseServiceImpl<KillCountMapper, KillCount> implements KillCountService {
    
}
