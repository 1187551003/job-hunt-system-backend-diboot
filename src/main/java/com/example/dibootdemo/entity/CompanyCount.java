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
 * (CompanyCount)表实体类
 *
 * @author 刘长卿
 * @since 2023-01-09 15:13:34
 */
@Getter @Setter @Accessors(chain = true)
@TableName("t_company_count")
public class CompanyCount extends BaseEntity implements Serializable {
    private static final long serialVersionUID=860017619760559951L;

    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String company;
    
    private Integer count;

    @Override
    public String toString() {
        return "{\"name\":\"" + company + "\",\"value\":" + count + "}";
    }
}
