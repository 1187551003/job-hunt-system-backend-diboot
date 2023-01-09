package com.example.dibootdemo.controller.dto;

import com.example.dibootdemo.entity.Recruit;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * (Recruit)表实体类
 *
 * @author 刘长卿
 * @since 2023-01-07 12:32:25
 */
@Getter
@Setter
@Accessors(chain = true)
public class RecruitDTO extends Recruit {
    private static final long serialVersionUID = 114906933653810780L;

}
