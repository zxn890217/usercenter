package com.example.usercenter.sys.entity;

import java.util.List;

public class Org {
    //ID
    private Long id;
    //名称
    private String name;
    //路径
    private String path;
    //父级
    private Org parent;
    //地区编码
    private String regionCode;
    //街道地址
    private String street;
    //详细地址
    private String fullAddress;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Org getParent() {
        return parent;
    }

    public void setParent(Org parent) {
        this.parent = parent;
    }

    public String getRegionCode(){
        return regionCode;
    }

    public void setRegionCode(String regionCode){
        this.regionCode = regionCode;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public String getFullAddress(){
        return fullAddress;
    }

    public void setFullAddress(String fullAddress){
        this.fullAddress = fullAddress;
    }
}