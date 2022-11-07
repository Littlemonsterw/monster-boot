package com.monster.code.generator.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monster.code.generator.entity.Datasource;
import com.monster.code.generator.service.IDatasourceService;
import com.monster.common.api.Condition;
import com.monster.common.api.Query;
import com.monster.common.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 *
 * 数据源配置表 控制器
 *
 * @author Monster-w
 * @date 2022-10-12 11:17:04
 */
@RestController
@AllArgsConstructor
@RequestMapping("/datasource")
@Api(value = "数据源配置表", tags = "数据源配置表接口")
public class DatasourceController {

    private IDatasourceService datasourceService;

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public R<Datasource> detail(@ApiParam(value = "主键id", required = true) @RequestParam Long id) {
        return R.data(datasourceService.getById(id));
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public R<IPage<Datasource>> page(Datasource datasource, Query query) {
        return R.data(datasourceService.getDatasourcePage(Condition.getPage(query), datasource));
    }

    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改")
    public R<Boolean> submit(@Valid @RequestBody Datasource datasource) {
        return R.data(datasourceService.saveOrUpdate(datasource));
    }

    @PostMapping("/remove")
    @ApiOperation(value = "逻辑删除")
    public R<Boolean> remove(@ApiParam(value = "主键id", required = true) @RequestParam Long id) {
        return R.data(datasourceService.removeById(id));
    }
}