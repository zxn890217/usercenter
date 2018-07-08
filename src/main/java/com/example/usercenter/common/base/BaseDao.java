package com.example.usercenter.common.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by zxn on 2018/1/11.
 */
public interface BaseDao<T, PK extends Serializable> {
    /**
     * 根据主键获取对象
     * */
    public T get(PK id);
    /**
     * 插入
     * */
    public int insert(T entity);
    /**
     * 根据主键更新
     * */
    public int update(T entity);
    /**
     * 根据主键非空更新
     * */
    public int sensitiveUpdate(T entity);
    /**
     * 根据主键删除
     * */
    public int delete(PK id);
    /**
     * 存在查找
     * */
    public int exists(T entity);
    /**
     * 查询列表
     * */
    public List<T> query(Map<String, Object> params);
    /**
     * 统计
     * */
    public int count(Map<String, Object> params);
}
