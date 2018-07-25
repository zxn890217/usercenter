package com.example.usercenter.sys.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.usercenter.common.base.BaseRestController;
import com.example.usercenter.common.base.BaseService;
import com.example.usercenter.sys.service.OrgService;
import com.example.usercenter.sys.entity.Org;

@RestController
@RequestMapping(value="/org")
public class OrgController extends BaseRestController<Org, Long> {
    @Autowired
    private OrgService orgService;

    protected BaseService<Org, Long> getService(){
            return orgService;
    }
}