package com.wonders.shixi.pojo;

public class TypeOne {
    private Integer typeOneId;

    private Integer bookTypeId;

    private String typeOneType;

    private String typeOneValue;

    public Integer getTypeOneId() {
        return typeOneId;
    }

    public void setTypeOneId(Integer typeOneId) {
        this.typeOneId = typeOneId;
    }

    public Integer getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Integer bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getTypeOneType() {
        return typeOneType;
    }

    public void setTypeOneType(String typeOneType) {
        this.typeOneType = typeOneType == null ? null : typeOneType.trim();
    }

    public String getTypeOneValue() {
        return typeOneValue;
    }

    public void setTypeOneValue(String typeOneValue) {
        this.typeOneValue = typeOneValue == null ? null : typeOneValue.trim();
    }
}