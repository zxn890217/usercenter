package com.example.usercenter.sys.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.usercenter.common.base.BaseRestController;
import com.example.usercenter.common.base.BaseService;
import com.example.usercenter.sys.service.UserGroupService;
import com.example.usercenter.sys.entity.UserGroup;

@RestController
@RequestMapping(value="/userGroup")
public class UserGroupController extends BaseRestController<UserGroup, Long> {
    @Autowired
    private UserGroupService userGroupService;

    protected BaseService<UserGroup, Long> getService(){
            return userGroupService;
    }
}