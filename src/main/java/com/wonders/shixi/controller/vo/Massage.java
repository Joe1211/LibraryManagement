package com.wonders.shixi.controller.vo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *返回信息vo
 * @author 吴建良 wujianliang
 */
@ApiModel(value = "返回的消息提示")
public class Massage<T> {
    /*
    200     成功
    500     连接出错
    401     不存在

     */
    /**
     * 返回代码
     */
    @ApiModelProperty(value = "返回的消息代码")
    private String code;
    /**
     * 返回的结果
     */
    @ApiModelProperty(value = "返回的结果")
    private T result;
    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回的具体消息")
    private String massage;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
