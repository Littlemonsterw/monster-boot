package com.monster.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wuhan
 * @date 2022/10/13 17:00
 */
@Getter
@AllArgsConstructor
public enum DefaultConstant {
    /**
     * 默认返回信息枚举
     */
    CONTENT_TYPE_NAME("Content-type"),
    CONTENT_TYPE("application/json;charset=utf-8"),
    DEFAULT_NULL_MESSAGE("暂无承载数据"),
    DEFAULT_SUCCESS_MESSAGE("操作成功"),
    DEFAULT_FAILURE_MESSAGE("操作失败"),
    DEFAULT_UNAUTHORIZED_MESSAGE("签名认证失败"),
    ;

    final String desc;
}
