package com.example.usercenter.sys.entity;

import java.util.List;

public class Authority {
    //权限ID
    private Long id;
    //名称
    private String name;
    //代码
    private String code;
    //用户组
    private List<UserGroup> groups;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public List<UserGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<UserGroup> groups) {
        this.groups = groups;
    }
}