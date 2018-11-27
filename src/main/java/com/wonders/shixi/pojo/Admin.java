package com.wonders.shixi.pojo;

import java.util.Date;

public class Admin {
    private Integer adminId;

    private String adminPassword;

    private Integer adminJurisdiction;

    private Date adminUpdate;

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