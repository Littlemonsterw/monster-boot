package com.monster.common.api;

import java.io.Serializable;

/**
 * @author wuhan
 * @date 2022/10/13 15:59
 */
public interface IResultCode extends Serializable {

    /**
     * 状态码
     *
     * @return 状态码
     */
    int getCode();

    /**
     * 获取消息
     *
     * @return 消息内容
     */
    String getMessage();
}
