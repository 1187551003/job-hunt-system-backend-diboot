package com.example.dibootdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.diboot.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (SalaryCount)表实体类
 *
 * @author 刘长卿
 * @since 2023-01-09 15:14:03
 */
@Getter @Setter @Accessors(chain = true)
@TableName("t_salary_count")
public class SalaryCount extends BaseEntity implements Serializable {
    private static final long serialVersionUID=-53027396034056472L;

    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String salary;
    
    private Integer count;

    @Override
    public String toString() {
        return "{\"name\":\"" + salary + "\",\"value\":" + count + "}";
    }

}
