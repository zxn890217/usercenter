package com.example.usercenter.sys.web;

import com.example.usercenter.common.base.RespBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.usercenter.common.base.BaseRestController;
import com.example.usercenter.common.base.BaseService;
import com.example.usercenter.sys.service.DictService;
import com.example.usercenter.sys.entity.Dict;

@RestController
@RequestMapping(value="/dict")
public class DictController extends BaseRestController<Dict, Long> {
    @Autowired
    private DictService dictService;

    protected BaseService<Dict, Long> getService(){
            return dictService;
    }

    @RequestMapping(value="/reloadCache")
    @ResponseBody
    public RespBody reloadCache(){
        dictService.cacheInit();
        return new RespBody(true, "重新加载数据字典成功");
    }
}