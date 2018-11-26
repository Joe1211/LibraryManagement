package com.wonders.shixi.util;

import com.wonders.shixi.controller.vo.Massage;

public class MassageUtil {
    /**
     * bool类型的消息模板
     * @param bool
     * @return
     */
    public  static Massage boolMassage(boolean bool){
        Massage massage=new Massage() ;
        if(bool){
            massage.setCode("200");
            massage.setMassage("成功！");
        }else{
            massage.setCode("401");
            massage.setMassage("失败！");
        }
        return massage;
    }

    /**
     * 构造massage
     * @param code
     * @param massage
     * @return
     */
    public static Massage setMassage(String code ,String massage){
        Massage massage1 =new Massage();
        massage1.setCode(code);
        massage1.setMassage(massage);
        return  massage1;
    }

}
