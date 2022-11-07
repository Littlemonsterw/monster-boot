package com.monster.common.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Objects;

/**
 * @author wuhan
 * @date 2022/10/14 15:08
 */
public class Condition {

    private Condition() {

    }

    public static <T> IPage<T> getPage(Query query) {
        int current = Objects.isNull(query.getCurrent())? 1 : query.getCurrent();
        int size = Objects.isNull(query.getSize())? 10 : query.getSize();
        return new Page<>(current, size);
    }
}
