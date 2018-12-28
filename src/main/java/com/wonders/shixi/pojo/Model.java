package com.wonders.shixi.pojo;

import java.util.Date;

public class Model {
    private int id;
    private int bookId;
    private int readerId;
    private String comment;
    private Date updateTime;
    private String readerName;
    private String readerPhone;
    private String readerEmail;
    private Integer readerBlacklist;
    private Date readerUpdate;
    private Integer readerState;
    private Double readerBalance;
    private String readerPassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getReaderPhone() {
        return readerPhone;
    }

    public void setReaderPhone(String readerPhone) {
        this.readerPhone = readerPhone;
    }

    public String getReaderEmail() {
        return readerEmail;
    }

    public void setReaderEmail(String readerEmail) {
        this.readerEmail = readerEmail;
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

    public String getReaderPassword() {
        return readerPassword;
    }

    public void setReaderPassword(String readerPassword) {
        this.readerPassword = readerPassword;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", comment='" + comment + '\'' +
                ", updateTime=" + updateTime +
                ", readerName='" + readerName + '\'' +
                ", readerPhone='" + readerPhone + '\'' +
                ", readerEmail='" + readerEmail + '\'' +
                ", readerBlacklist=" + readerBlacklist +
                ", readerUpdate=" + readerUpdate +
                ", readerState=" + readerState +
                ", readerBalance=" + readerBalance +
                ", readerPassword='" + readerPassword + '\'' +
                '}';
    }
}
