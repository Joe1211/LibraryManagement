package com.wonders.shixi.pojo;

public class TypeTwo {
    private Integer typeTwoId;

    private Integer typeOneId;

    private String typeTwoType;

    private String typeTwoValue;

    public Integer getTypeTwoId() {
        return typeTwoId;
    }

    public void setTypeTwoId(Integer typeTwoId) {
        this.typeTwoId = typeTwoId;
    }

    public Integer getTypeOneId() {
        return typeOneId;
    }

    public void setTypeOneId(Integer typeOneId) {
        this.typeOneId = typeOneId;
    }

    public String getTypeTwoType() {
        return typeTwoType;
    }

    public void setTypeTwoType(String typeTwoType) {
        this.typeTwoType = typeTwoType == null ? null : typeTwoType.trim();
    }

    public String getTypeTwoValue() {
        return typeTwoValue;
    }

    public void setTypeTwoValue(String typeTwoValue) {
        this.typeTwoValue = typeTwoValue == null ? null : typeTwoValue.trim();
    }
}