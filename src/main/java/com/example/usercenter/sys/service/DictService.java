package com.example.usercenter.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usercenter.common.base.BaseService;
import com.example.usercenter.common.base.BaseDao;
import com.example.usercenter.sys.dao.DictDao;

import com.example.usercenter.sys.entity.Dict;
@Service
public class DictService extends BaseService<Dict, Long> {
    @Autowired
    private DictDao dictDao;

    protected BaseDao<Dict, Long> getDao(){
            return dictDao;
    }
}