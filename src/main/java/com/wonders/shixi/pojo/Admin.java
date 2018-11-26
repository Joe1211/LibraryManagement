package com.wonders.shixi.pojo;

import java.util.Date;

public class Admin {
    private Integer adminId;//管理员id

    private String adminPassword;//管理员密码

    private Integer adminJurisdiction;//管理员权限

    private Date adminUpdate;//管理员最后时间

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public Integer getAdminJurisdiction() {
        return adminJurisdiction;
    }

    public void setAdminJurisdiction(Integer adminJurisdiction) {
        this.adminJurisdiction = adminJurisdiction;
    }

    public Date getAdminUpdate() {
        return adminUpdate;
    }

    public void setAdminUpdate(Date adminUpdate) {
        this.adminUpdate = adminUpdate;
    }
}