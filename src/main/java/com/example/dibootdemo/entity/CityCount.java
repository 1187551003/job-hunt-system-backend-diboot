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
 * (CityCount)表实体类
 *
 * @author 刘长卿
 * @since 2023-01-09 15:12:53
 */
@Getter @Setter @Accessors(chain = true)
@TableName("t_city_count")
public class CityCount extends BaseEntity implements Serializable {
    private static final long serialVersionUID=542741724124709289L;

    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String city;
    
    private Integer count;

    @Override
    public String toString() {
        return "{\"name\":\"" + city + "\",\"value\":" + count + "}";
    }
}
