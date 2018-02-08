package com.pay.database.dao.impl;

import com.github.pagehelper.PageHelper;
import com.pay.database.dao.BasicDao;
import com.pay.database.dao.entity.PageInfo;
import com.pay.database.mybatis.config.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class BasicDaoImpl<T> implements BasicDao<T> {
    @Autowired
    protected BaseMapper<T> baseMapper;


    @Override
    public boolean insertNewEntity(Object o) {
        return baseMapper.insert((T)o) == 1;
    }

    @Override
    public boolean insertAll(List entityList) {
        return baseMapper.insertList(entityList) == 1;
    }

    @Override
    public boolean insertAll(Object[] t) {
        return insertAll(Arrays.asList(t));
    }

    @Override
    public boolean deleteByPrimaryKey(String id) {
        return baseMapper.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public boolean delete(Object[] t) {
        //TODO 完成批量删除的方法
        return false;
    }

    @Override
    public boolean deleteAll(List entityList) {
        //TODO 完成批量删除的方法
        return false;
    }

    @Override
    public boolean update(Object o) {
        return baseMapper.updateByPrimaryKey((T)o) == 1;
    }

    @Override
    public T getById(Object id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> findAll(Map selectMap) {
        //TODO 完成键值映射的查询方法
        return null;
    }

    @Override
    public List<T> findAllByCondition(Object condition) {
        return baseMapper.selectByExample(condition);
    }

    @Override
    public List<T> findAll(Object o) {
        return baseMapper.select((T)o);
    }

    @Override
    public int countAll(Object o) {
        return baseMapper.selectCount((T)o);
    }

    @Override
    public PageInfo<T> getPageInfo(Object o, int pageNum, int pageSize) {
        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setCount(baseMapper.selectCount((T)o));
        PageHelper.startPage(pageNum,pageSize);
        pageInfo.setResultList(baseMapper.select((T)o));
        return pageInfo;
    }

    @Override
    public PageInfo<T> getPageInfoByCondition(Object condition, int pageNum, int pageSize) {
        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setCount(baseMapper.selectCountByExample(condition));
        PageHelper.startPage(pageNum,pageSize);
        pageInfo.setResultList(baseMapper.selectByExample(condition));
        return pageInfo;
    }
}