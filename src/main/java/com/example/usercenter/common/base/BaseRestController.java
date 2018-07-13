package com.example.usercenter.common.base;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * Created by zxn on 2017/10/23.
 */
public abstract class BaseRestController<T, PK extends Serializable> {
    protected abstract BaseService<T, PK> getService();

    @GetMapping(value="/{id}")
    @ResponseBody
    public RespBody get(@PathVariable("id") PK id){
        T result = getService().get(id);
        if(result!=null)
            return new RespBody(true,"获取成功", result);
        return new RespBody(false,"获取失败");
    }

    @PostMapping(value="")
    @ResponseBody
    public RespBody save(@RequestBody T entity){
        try {
            if(getService().insert(entity))
                return new RespBody(true, "保存成功");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new RespBody(false, "保存失败");
    }

    @PutMapping(value="")
    @ResponseBody
    public RespBody update(@RequestBody T entity){
        try{
            if(getService().update(entity))
                return new RespBody(true, "修改成功");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new RespBody(false, "修改失败");
    }

    @DeleteMapping(value="/{id}")
    @ResponseBody
    public RespBody delete(@PathVariable("id") PK id){
        try{
            if(getService().delete(id))
                return new RespBody(true, "删除成功");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new RespBody(false, "删除失败");
    }

    @PostMapping(value="/page")
    @ResponseBody
    public RespBody page(@RequestBody JSONObject params){
        return new RespBody(true, "查询分页数据成功", getService().findByPage(params));
    }

    @PostMapping(value="/query")
    @ResponseBody
    public RespBody query(@RequestBody JSONObject params){
        return new RespBody(true, "查询列表成功", getService().query(params));
    }
}
