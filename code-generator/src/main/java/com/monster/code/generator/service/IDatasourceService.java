package com.monster.code.generator.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.code.generator.entity.Datasource;
import com.monster.code.generator.model.BaseService;


/**
 * 数据源配置表 服务类
 *
 * @author Monster-w
 * @date 2022-10-12 11:17:04
 */
public interface IDatasourceService extends BaseService<Datasource> {

    /**
     * 分页查询
     *
     * @param page 分页
     * @param datasource 查询条件
     * @return IPage<DatasourceVO>
     */
    IPage<Datasource> getDatasourcePage(IPage<Datasource> page, Datasource datasource);

}
