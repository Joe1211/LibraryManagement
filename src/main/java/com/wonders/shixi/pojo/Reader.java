package com.wonders.shixi.pojo;

import java.util.Date;

public class Reader {
    private Integer readerId;

    private String readerName;

    private String readerPhone;

    private String readerEmail;

    private Integer readerBlacklist;

    private Date readerUpdate;

    private Integer readerState;

    private Double readerBalance;

    private String readerPassword;

    /**
     * 角色
     * 0：读者，1：管理员，2：既是读者又是管理员
     */
    private Integer role;

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

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

    public String getReaderPassword() {
        return readerPassword;
    }

    public void setReaderPassword(String readerPassword) {
        this.readerPassword = readerPassword == null ? null : readerPassword.trim();
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId=" + readerId +
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