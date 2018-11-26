package com.wonders.shixi.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Person" ,description = "人")
public class Person {
    @ApiModelProperty(value = "名字",required = true)
    private String name =null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
