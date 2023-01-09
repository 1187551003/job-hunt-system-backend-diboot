package com.example.dibootdemo.mapper;

import com.diboot.core.mapper.BaseCrudMapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.dibootdemo.entity.KillCount;

/**
 * (KillCount)表数据库访问层
 *
 * @author 刘长卿
 * @since 2023-01-09 15:13:48
 */
@Mapper
public interface KillCountMapper extends BaseCrudMapper<KillCount> {

}


