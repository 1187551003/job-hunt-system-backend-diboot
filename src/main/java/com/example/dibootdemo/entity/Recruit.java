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
 * (Recruit)表实体类
 *
 * @author 刘长卿
 * @since 2023-01-07 12:32:25
 */
@Getter @Setter @Accessors(chain = true)
@TableName("t_ods_recruit")
public class Recruit extends BaseEntity implements Serializable {
    private static final long serialVersionUID=-56547067391704480L;
    /*  
        @TableId(type = IdType.ASSIGN_ID) id增长类型
        @NotEmpty(message = "名称不能为空")
        @Size(min = 3, max = 20, message = "书名长度范围应在3至20个字")
        @ProtectField 加密字段
        @TableField(fill = FieldFill.INSERT) 新增时自动插入值
        @TableField(fill = FieldFill.INSERT_UPDATE) 更新时自动插入值
    */
    //ID
    @TableId(type = IdType.AUTO)
    private Long id;
    //公司全名
    private String companyFullName;
    //公司简称
    private String companyShortName;
    //公司规模
    private String companySize;
    //融资阶段
    private String financeStage;
    //城市区域
    private String cityDistrict;
    //职位名称
    private String positionName;
    //工作经验
    private String workYear;
    //学历要求
    private String education;
    //薪资
    private String salary;
    //福利
    private String welfare;
    //所需技能
    private String kills;
    //经营范围
    private String industryField;
    //职位类型
    private String positionType;

}
