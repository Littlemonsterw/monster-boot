package com.monster.code.generator.model;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Collection;
import java.util.Date;

/**
 * @author wuhan
 * @date 2022/10/12 16:03
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements BaseService<T> {

    @Override
    public boolean save(T entity) {
        this.handleEntity(entity);
        return super.save(entity);
    }

    @Override
    public boolean saveBatch(Collection<T> entityList) {
        entityList.forEach(this::handleEntity);
        return super.saveBatch(entityList, 1000);
    }

    @Override
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        entityList.forEach(this::handleEntity);
        return super.saveBatch(entityList, batchSize);
    }

    @Override
    public boolean updateById(T entity) {
        this.handleEntity(entity);
        return super.updateById(entity);
    }

    @Override
    public boolean updateBatchById(Collection<T> entityList) {
        entityList.forEach(this::handleEntity);
        return super.updateBatchById(entityList, 1000);
    }

    @Override
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        entityList.forEach(this::handleEntity);
        return super.updateBatchById(entityList, batchSize);
    }

    @Override
    public boolean saveOrUpdate(T entity) {
        this.handleEntity(entity);
        return super.saveOrUpdate(entity);
    }

    private void handleEntity(T entity) {
        Date now = new Date();
        if (entity.getId() == null) {
            entity.setCreateTime(now);
            entity.setIsDeleted(0);
        } else {
            entity.setUpdateTime(now);
        }
    }
}
