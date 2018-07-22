package com.example.usercenter.sys.entity;
public class UserGroup {
    //ID
    private Long id;
    //组名
    private String name;
    //父级
    private UserGroup parent;
    //路径
    private String path;

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

    public String getPath(){
        return path;
    }

    public void setPath(String path){
        this.path = path;
    }
}