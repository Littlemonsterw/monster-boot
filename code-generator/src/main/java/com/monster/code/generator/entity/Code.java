package com.monster.code.generator.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.monster.code.generator.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 代码生成表
 *
 * @author Monster-w
 * @date 2022-10-12 10:14:28
 */
@Data
@TableName("mpg_code")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Code对象", description = "代码生成表")
@JsonIgnoreProperties({"createUserId", "createTime", "updateUserId", "updateTime", "isDeleted"})
public class Code extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "数据源主键")
    @NotNull(message = "数据源主键不能为空")
    private Long datasourceId;

    @ApiModelProperty(value = "服务名称")
    @NotBlank(message = "服务名称不能为空")
    private String serviceName;

    @ApiModelProperty(value = "模块名称")
    @NotBlank(message = "模块名称不能为空")
    private String codeName;

    @ApiModelProperty(value = "表名")
    @NotBlank(message = "表名不能为空")
    private String tableName;

    @ApiModelProperty(value = "表前缀")
    @NotBlank(message = "表前缀不能为空")
    private String tablePrefix;

    @ApiModelProperty(value = "主键名")
    @NotBlank(message = "主键名不能为空")
    private String pkName;

    @ApiModelProperty(value = "后端包名")
    @NotBlank(message = "后端包名不能为空")
    private String packageName;

    @ApiModelProperty(value = "基础业务模式")
    @NotNull(message = "基础业务模式不能为空")
    private Boolean baseMode;

    @ApiModelProperty(value = "存放路径")
    @NotBlank(message = "存放路径不能为空")
    private String apiPath;
}