package com.wonders.shixi.service;

import com.wonders.shixi.controller.vo.ReaderCondition;
import com.wonders.shixi.pojo.Admin;
import com.wonders.shixi.pojo.Reader;
import com.wonders.shixi.util.RestMsg;

import java.util.List;

/**
 * 读者管理service接口
 *
 * @author 吴建良
 */
public interface ReaderService {
    /**
     * 通过id获取读者信息
     *
     * @param id
     * @return
     */
    Reader getReaderById(int id);

    /**
     * 通过id删除读者信息（改变信息）
     *
     * @param id
     * @return
     */
    boolean deleteReaderById(int id);

    /**
     * 通过Reader对象更新该对象信息
     *
     * @param reader
     * @return
     */
    boolean updateReader(Reader reader);

    /**
     * 通过管理员重置读者密码
     *
     * @param admin  管理员账号密码
     * @param reader 读者账号密码
     * @return
     */
    boolean updatePasswordByAdmin(Admin admin, Reader reader);

    /**
     * 创建读者记录
     *
     * @param reader
     * @return
     */
    boolean creatReader(Reader reader);

    List<Reader> selectReadersByCondition(ReaderCondition readerCondition);

    /**
     * 读者登录
     * @param phone 手机号
     * @param password 密码
     * @return RestMsg<Object>
     */
    RestMsg<Object> readerLogin(String phone, String password);

    /**
     * 管理员登录
     * @param phone 手机号
     * @param password 密码
     * @return RestMsg<Object>
     */
    RestMsg<Object> adminLogin(String phone,String password);

    boolean updataByPassword(String phone, String password);

    List<Reader> selectReaderByReaderId(int readerId);

    /**
     *手机号是否已注册
     * @param phone 手机号
     * @return 是否已注册
     */
    boolean isPhoneRegistered(String phone);

    /**
     * 邮箱是否已注册
     * @param email 邮箱
     * @return 是否已注册
     */
    boolean isEmailRegistered(String email);
}
