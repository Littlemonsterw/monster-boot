package com.monster.common.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author wuhan
 * @date 2022/10/14 11:34
 */
@Data
@ApiModel(description = "返回结果封装")
public class ResultData {

    @ApiModelProperty(value = "当前页")
    private int current;

    @ApiModelProperty(value = "每页显示条数")
    private int size;

    @ApiModelProperty(value = "总数")
    private int total;

    @ApiModelProperty(value = "当前分页总页数")
    private int pages;

    @ApiModelProperty(value = "查询数据列表")
    private List<?> records;
}
