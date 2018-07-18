package com.example.usercenter.common.base;

import com.google.common.base.CaseFormat;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by zxn on 2018/1/11.
 */
public abstract class BaseService<T, PK extends Serializable> {
    private static final String SORT = "sort";
    private static final String ORDER = "order";

    protected abstract BaseDao<T, PK> getDao();

    public T get(PK id){
        return getDao().get(id);
    }

    @Transactional
    public boolean insert(T entity){
        return getDao().insert(entity)>0;
    }

    @Transactional
    public boolean update(T entity){
        return getDao().update(entity)>0;
    }

    @Transactional
    public boolean sensitiveUpdate(T entity){
        return getDao().sensitiveUpdate(entity)>0;
    }

    @Transactional
    public boolean delete(PK id){
        return getDao().delete(id)>0;
    }

    public boolean exists(T entity){
        return getDao().exists(entity)>0;
    }

    public Page findByPage(Map<String, Object> params){
        return new Page<T>(query(params), getDao().count(params));
    }

    public int count(Map<String, Object> params){
        return getDao().count(params);
    }

    public List<T> query(Map<String, Object> params){
        //驼峰转换
        Object sort = params.get(SORT);
        if(sort!=null){
            sort = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, sort.toString());
            params.put(SORT, sort);
        }
        Object order = params.get(ORDER);
        if(order!=null){
            order = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, order.toString());
            params.put(ORDER, order);
        }
        return getDao().query(params);
    }
}
