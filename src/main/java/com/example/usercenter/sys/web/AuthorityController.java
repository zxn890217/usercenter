package com.example.usercenter.sys.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.usercenter.common.base.BaseRestController;
import com.example.usercenter.common.base.BaseService;
import com.example.usercenter.sys.service.AuthorityService;
import com.example.usercenter.sys.entity.Authority;

@RestController
@RequestMapping(value="/authority")
public class AuthorityController extends BaseRestController<Authority, Long> {
    @Autowired
    private AuthorityService authorityService;

    protected BaseService<Authority, Long> getService(){
            return authorityService;
    }
}