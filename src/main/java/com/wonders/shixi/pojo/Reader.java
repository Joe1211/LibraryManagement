package com.wonders.shixi.pojo;

import java.util.Date;

public class Reader {
    private Integer readerId;//读者id

    private String readerName;//读者名字

    private String readerPhone;//读者手机号

    private String readerEmail;//读者邮箱

    private Integer readerBlacklist;//黑名单

    private Date readerUpdate;//更新时间

    private Integer readerState;//读者激活状态

    private Double readerBalance;//余额

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName == null ? null : readerName.trim();
    }

    public String getReaderPhone() {
        return readerPhone;
    }

    public void setReaderPhone(String readerPhone) {
        this.readerPhone = readerPhone == null ? null : readerPhone.trim();
    }

    public String getReaderEmail() {
        return readerEmail;
    }

    public void setReaderEmail(String readerEmail) {
        this.readerEmail = readerEmail == null ? null : readerEmail.trim();
    }

    public Integer getReaderBlacklist() {
        return readerBlacklist;
    }

    public void setReaderBlacklist(Integer readerBlacklist) {
        this.readerBlacklist = readerBlacklist;
    }

    public Date getReaderUpdate() {
        return readerUpdate;
    }

    public void setReaderUpdate(Date readerUpdate) {
        this.readerUpdate = readerUpdate;
    }

    public Integer getReaderState() {
        return readerState;
    }

    public void setReaderState(Integer readerState) {
        this.readerState = readerState;
    }

    public Double getReaderBalance() {
        return readerBalance;
    }

    public void setReaderBalance(Double readerBalance) {
        this.readerBalance = readerBalance;
    }
}