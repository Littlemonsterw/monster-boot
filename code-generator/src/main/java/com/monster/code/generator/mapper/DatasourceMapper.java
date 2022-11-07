package com.monster.code.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.code.generator.entity.Datasource;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 数据源配置表 Mapper 接口
 *
 * @author Monster-w
 * @date 2022-10-12 11:17:04
 */
public interface DatasourceMapper extends BaseMapper<Datasource> {

    /**
    * 分页查询
    *
    * @param page 分页
    * @param datasource 查询条件
    * @return List<DatasourceVO>
    */
    List<Datasource> getDatasourcePage(IPage<Datasource> page, @Param("pm") Datasource datasource);

}

