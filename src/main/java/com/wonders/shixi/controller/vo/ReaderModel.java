package com.wonders.shixi.controller.vo;


import com.wonders.shixi.pojo.Reader;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 返回的读者信息模板（去除关键信息）
 * @author 吴建良
 */
@ApiModel(value = "Reader", description = "读者")
public class ReaderModel {
    @ApiModelProperty(value = "读者id")
    /**
     * 读者id
     */
    private Integer readerId;
    @ApiModelProperty(value = "读者姓名")
    /**
     * 读者姓名
     */
    private String readerName;
    /**
     * 读者手机号
     */
    @ApiModelProperty(value = "读者手机号")
    private String readerPhone;
    /**
     * 读者邮箱
     */
    @ApiModelProperty(value = "读者邮箱")
    private String readerEmail;
    /**
     * 黑名单
     */
    @ApiModelProperty(value = "黑名单")
    private Integer readerBlacklist;
    /**
     * 读者最后登录时间
     */
    @ApiModelProperty(value = "读者最后登录时间")
    private Date readerUpdate;
    /**
     * 该读者激活状态
     */
    @ApiModelProperty(value = "激活状态")
    private Integer readerState;
    /**
     * 读者余额
     */
    @ApiModelProperty(value = "余额")
    private Double readerBalance;

    /**
     * reader转换readerModel
     * @param reader
     */
    public ReaderModel(Reader reader){

        this.setReaderId(reader.getReaderId());
        this.setReaderBalance(reader.getReaderBalance());
        this.setReaderBlacklist(reader.getReaderBlacklist());
        this.setReaderEmail(reader.getReaderEmail());
        this.setReaderPhone(reader.getReaderPhone());
        this.setReaderUpdate(reader.getReaderUpdate());
        this.setReaderState(reader.getReaderState());
        this.setReaderName(reader.getReaderName());

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
}