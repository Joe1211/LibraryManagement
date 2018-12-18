package com.wonders.shixi.service.impl;/**
 * @Auther: qiaohanlin
 * @Date: 2018/12/18 09:56
 * @Description:
 */

import com.wonders.shixi.mapper.TypeTwoMapper;
import com.wonders.shixi.pojo.BookType;
import com.wonders.shixi.service.ITypeTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@ClassName TypeTwoServiceImpl
 *@Author 乔翰林
 *@Date 2018/12/18
 **/
@Service
public class TypeTwoServiceImpl implements ITypeTwoService {

    @Autowired
    TypeTwoMapper typeTwoMapper;

    @Override
    public List<BookType> selectByOId(String value) {
        return typeTwoMapper.selectByOId(value);
    }
}
