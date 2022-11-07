package com.monster.code.generator.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.code.generator.entity.Datasource;
import com.monster.code.generator.mapper.DatasourceMapper;
import com.monster.code.generator.model.BaseServiceImpl;
import com.monster.code.generator.service.IDatasourceService;
import org.springframework.stereotype.Service;


/**
 * 数据源配置表 实现类
 *
 * @author Monster-w
 * @date 2022-10-12 11:17:04
 */
@Service
public class DatasourceServiceImpl extends BaseServiceImpl<DatasourceMapper, Datasource> implements IDatasourceService {

    @Override
    public IPage<Datasource> getDatasourcePage(IPage<Datasource> page, Datasource datasource) {
        return page.setRecords(baseMapper.getDatasourcePage(page, datasource));
    }

}
