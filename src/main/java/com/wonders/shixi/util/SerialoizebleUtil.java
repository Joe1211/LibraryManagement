package com.wonders.shixi.util;
/**
 *@ClassName SerialoizebleUtil
 *@Author 乔翰林
 *@Date 2019/1/11
 **/
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerialoizebleUtil {
    /**
     * 将对象序列化:要求对象要实现序列化接口
     */
    public static byte[] serialize(Object obj ){
        //对象输出流
        ObjectOutputStream oos = null;
        //字节数组输出流
        ByteArrayOutputStream baos = null;
        byte[] bt=null;
        try {
            baos = new ByteArrayOutputStream();
            oos=new ObjectOutputStream(baos);
            oos.writeObject(obj);
            bt=baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bt;
    }
    //反序列化，将byte字节转换为对象
    public static Object unSerialize(byte[] bt){
        ByteArrayInputStream bais = null;
        Object object =null;
        try {
            bais = new ByteArrayInputStream(bt);
            ObjectInputStream ois = new ObjectInputStream(bais);
            object  = ois .readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(bais!=null){
                try {
                    bais.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }

    /**
     * 序列化 list 集合
     *
     * @param list
     * @return
     */
    public static byte[] serializeList(List<?> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        byte[] bytes = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            for (Object obj : list) {
                oos.writeObject(obj);
            }
            bytes = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return bytes;
    }

    /**
     * 反序列化 list 集合
     *
     * @param
     * @return
     */
    public static List<?> unserializeList(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        List<Object> list = new ArrayList<Object>();
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            while (bais.available() > 0) {
                Object obj = (Object) ois.readObject();
                if (obj == null) {
                    break;
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bais.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


}
