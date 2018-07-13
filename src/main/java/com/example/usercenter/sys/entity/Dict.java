package com.example.usercenter.sys.entity;
public class Dict {
    //ID
    private Long id;
    //类型
    private String type;
    //编码
    private String code;
    //文字描述
    private String text;
    //值
    private String value;
    //可下载（1：可以；2：不可以）
    private String downLoad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getDownLoad(){
        return downLoad;
    }

    public void setDownLoad(String downLoad){
        this.downLoad = downLoad;
    }
}