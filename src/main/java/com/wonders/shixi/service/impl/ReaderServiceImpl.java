package com.wonders.shixi.service.impl;

import com.wonders.shixi.controller.vo.ReaderCondition;
import com.wonders.shixi.mapper.AdminMapper;
import com.wonders.shixi.mapper.ReaderMapper;

import com.wonders.shixi.pojo.Admin;
import com.wonders.shixi.pojo.Reader;
import com.wonders.shixi.pojo.ReaderExample;
import com.wonders.shixi.service.ReaderService;
import com.wonders.shixi.util.RestMsg;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 读者管理service实现
 *
 * @author 吴建良
 */
@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    ReaderMapper readerMapper;
    @Autowired
    AdminMapper adminMapper;
    private static final Logger log = LogManager.getLogger(ReaderServiceImpl.class.getName());

    /**
     * 通过id获取读者信息
     *
     * @param id
     * @return
     */
    @Override
    public Reader getReaderById(int id) {
        return readerMapper.selectById(id);
    }

    /**
     * 通过id删除读者信息（改变信息）
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public boolean deleteReaderById(int id) {

        int b = readerMapper.deleteByPrimaryKey(id);
        boolean bool = false;
        if (b == 1) {
            bool = true;
        }
        return bool;
    }

    /**
     * 通过Reader对象更新该对象信息,无法更新密码不为空的对象
     *
     * @param reader
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public boolean updateReader(Reader reader) {
        int result = 0;
        if (reader.getReaderPassword() == null) {
            result = readerMapper.updateByPrimaryKeySelective(reader);
        }
        boolean bool = false;
        if (result == 1) {
            bool = true;
        }
        return bool;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public boolean updatePasswordByAdmin(Admin admin, Reader reader) {
        Admin adminSelect = adminMapper.selectByPrimaryKey(admin.getAdminId());
        //查询管理员密码是否正确
        boolean bool = adminSelect.getAdminPassword().equals(admin.getAdminPassword());
        if (bool) {
            //正确则更新读者密码
            int retult = readerMapper.updateByPrimaryKeySelective(reader);
            if (retult == 1) {
                bool = true;
            } else {
                bool = false;
            }
        }
        ;


        return bool;

    }


    /**
     * 创建读者记录
     *
     * @param reader
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public boolean creatReader(Reader reader) {


        return readerMapper.insert(reader) > 0;
    }

    /**
     * 根据条件查询符合条件的Reader集合
     *
     * @return
     */
    @Override
    public List<Reader> selectReadersByCondition(ReaderCondition readerCondition) {
        ReaderExample readerExample = new ReaderExample();
        ReaderExample.Criteria criteria = null;
        //判断查询条件是否拥有，并构建查询sql
        if (readerCondition != null) {
            criteria = readerExample.createCriteria();
            String name = readerCondition.getReaderName().trim();
            String email = readerCondition.getReaderEmail().trim();
            String phone = readerCondition.getReaderPhone().trim();
            Integer state = readerCondition.getReaderState();
            Double minBalance = readerCondition.getMinReaderBalance();
            Double maxBalance = readerCondition.getMaxReaderBalance();
            Integer blackList = readerCondition.getReaderBlacklist();
            if (name != null && !name.isEmpty()) {
                criteria.andReaderNameLike(name);
            }
            if (email != null && !email.isEmpty()) {
                criteria.andReaderEmailLike(email);
            }
            if (phone != null && !phone.isEmpty()) {
                criteria.andReaderPhoneLike(phone);
            }
            if (state != null) {
                criteria.andReaderStateEqualTo(state);
            }
            if (minBalance != null) {
                criteria.andReaderBalanceGreaterThanOrEqualTo(minBalance);
            }
            if (maxBalance != null) {
                criteria.andReaderBalanceLessThanOrEqualTo(maxBalance);
            }
        }
        //查询
        List<Reader> readers = readerMapper.selectByExample(readerExample);

        return readers;

    }

    /**
     * 读者登陆
     *
     * @param phone    手机号
     * @param password 密码
     * @return RestMsg<Object>
     */
    @Override
    public RestMsg<Object> readerLogin(String phone, String password) {
        Reader reader = readerMapper.readerLogin(phone);
        RestMsg<Object> rm = new RestMsg<>();
        System.out.println("reader:test1");
        if (reader != null && password.equals(reader.getReaderPassword())) {
            System.out.println("reader:test2");
            rm.setResult(reader);
            return rm.successMsg("登陆成功");
        }
        System.out.println("reader:test3");
        return rm.errorMsg("登陆失败,你不是读者");
    }

    /**
     * 管理员登录
     *
     * @param phone    手机号
     * @param password 密码
     * @return RestMsg<Object>
     */
    @Override
    public RestMsg<Object> adminLogin(String phone, String password) {
        Reader reader = readerMapper.adminLogin(phone);
        RestMsg<Object> rm = new RestMsg<>();
        if (reader != null && password.equals(reader.getReaderPassword())) {
            rm.setResult(reader);
            return rm.successMsg("登陆成功");
        }
        return rm.errorMsg("登陆失败,你不是管理员");
    }


    @Override
    public List<Reader> selectReaderByReaderId(int readerId) {
        List<Reader> list = readerMapper.selectByPrimaryKey(readerId);
        return list;
    }

    /**
     * 修改密码
     *
     * @param phone
     * @param password
     * @return
     */
    @Override
    public boolean updataByPassword(String phone, String password) {
        int i = readerMapper.updateBypassword(phone, password);
        if (i != 0) {
            return true;
        }
        return false;
    }


}
