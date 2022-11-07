package com.monster.common.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wuhan
 * @date 2022/10/13 11:18
 */
@Data
@ApiModel(value = "Query", description = "查询条件")
public class Query {

    @ApiModelProperty(value = "当前页")
    private Integer current;

    @ApiModelProperty(value = "每页的数量")
    private Integer size;
}
