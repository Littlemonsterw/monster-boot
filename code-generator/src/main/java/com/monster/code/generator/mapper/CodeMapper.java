package com.monster.code.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.code.generator.entity.Code;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 代码生成表 Mapper 接口
 *
 * @author Monster-w
 * @date 2022-10-12 10:14:28
 */
public interface CodeMapper extends BaseMapper<Code> {

    /**
    * 分页查询
    *
    * @param page 分页
    * @param code 查询条件
    * @return List<CodeVO>
    */
    List<Code> getCodePage(IPage<Code> page, @Param("pm") Code code);

}

