package com.example.usercenter.sys.entity;

import java.util.List;

public class UserGroup {
    //ID
    private Long id;
    //组名
    private String name;
    //父级
    private UserGroup parent;
    //路径
    private String path;
    //权限列表
    private List<Authority> authorities;

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

    public UserGroup getParent() {
        return parent;
    }

    public void setParent(UserGroup parent) {
        this.parent = parent;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}