package com.example.usercenter.sys.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.usercenter.common.base.BaseRestController;
import com.example.usercenter.common.base.BaseService;
import com.example.usercenter.sys.service.RoleService;
import com.example.usercenter.sys.entity.Role;

@RestController
@RequestMapping(value="/role")
public class RoleController extends BaseRestController<Role, Long> {
    @Autowired
    private RoleService roleService;

    protected BaseService<Role, Long> getService(){
            return roleService;
    }
}