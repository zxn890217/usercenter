package com.example.usercenter.sys.entity;
import java.util.Date;
import java.util.List;

public class Role {
    //角色ID
    private Long id;
    //角色名称
    private String name;
    //创建人ID
    private Long creatorId;
    //创建时间
    private Date createTime;
    //权限
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

    public Long getCreatorId(){
        return creatorId;
    }

    public void setCreatorId(Long creatorId){
        this.creatorId = creatorId;
    }

    public Date getCreateTime(){
        return createTime;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}