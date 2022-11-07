package com.monster.code.generator.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.monster.code.generator.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数据源配置表
 *
 * @author Monster-w
 * @date 2022-10-12 11:17:04
 */
@Data
@TableName("mpg_datasource")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Datasource对象", description = "数据源配置表")
@JsonIgnoreProperties({"createUserId", "createTime", "updateUserId", "updateTime", "isDeleted"})
public class Datasource extends BaseEntity {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "连接地址")
    private String url;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;
}