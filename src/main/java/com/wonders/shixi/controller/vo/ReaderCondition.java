package com.wonders.shixi.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "读者查询条件")
public class ReaderCondition {
    /**
     * 读者名字查询条件
     */
    @ApiModelProperty(value = "读者名字查询条件")
    private String readerName;
    /**
     * 读者手机号查询条件
     */
@ApiModelProperty(value = "读者手机号查询条件")
    private String readerPhone;
    /**
     * 读者邮箱查询条件
     */
    @ApiModelProperty(value = "读者邮箱查询条件")
    private String readerEmail;
    /**
     * 读者黑名单查询条件
     */
    @ApiModelProperty(value = "读者黑名单查询条件")
    private Integer readerBlacklist;
    /**
     * 读者状态查询条件
     */
    @ApiModelProperty(value = "读者状态查询条件")
    private Integer readerState;
    /**
     * 读者余额查询条件最小范围
     */
    @ApiModelProperty(value = "读者余额查询条件最小范围")
    private Double minReaderBalance;
    /**
     * 读者余额查询条件最大范围
     */
    @ApiModelProperty(value = "读者余额查询条件最大范围")
    private Double maxReaderBalance;

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

    public Integer getReaderState() {
        return readerState;
    }

    public void setReaderState(Integer readerState) {
        this.readerState = readerState;
    }

    public Double getMinReaderBalance() {
        return minReaderBalance;
    }

    public void setMinReaderBalance(Double minReaderBalance) {
        this.minReaderBalance = minReaderBalance;
    }

    public Double getMaxReaderBalance() {
        return maxReaderBalance;
    }

    public void setMaxReaderBalance(Double maxReaderBalance) {
        this.maxReaderBalance = maxReaderBalance;
    }
}
