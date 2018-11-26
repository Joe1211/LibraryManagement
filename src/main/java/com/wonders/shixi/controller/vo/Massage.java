package com.wonders.shixi.controller.vo;

/**
 *返回信息vo
 * @author 吴建良 wujianliang
 */
public class Massage {
    /*
    200     成功
    500     连接出错
    401     不存在

     */
    private String code;//返回代码

    private String massage;//返回信息


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
