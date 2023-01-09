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
 * (KillCount)表实体类
 *
 * @author 刘长卿
 * @since 2023-01-09 15:13:48
 */
@Getter @Setter @Accessors(chain = true)
@TableName("t_kill_count")
public class KillCount extends BaseEntity implements Serializable {
    private static final long serialVersionUID=262165635132336080L;

    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String kills;
    
    private Integer count;

    @Override
    public String toString() {
        return "{\"name\":\"" + kills + "\",\"value\":" + count + "}";
    }

}
