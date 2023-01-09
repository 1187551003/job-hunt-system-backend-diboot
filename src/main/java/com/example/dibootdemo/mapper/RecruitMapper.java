package com.example.dibootdemo.mapper;

import com.diboot.core.mapper.BaseCrudMapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.dibootdemo.entity.Recruit;

/**
 * (Recruit)表数据库访问层
 *
 * @author 刘长卿
 * @since 2023-01-07 12:32:25
 */
@Mapper
public interface RecruitMapper extends BaseCrudMapper<Recruit> {

}


