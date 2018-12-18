package com.wonders.shixi.service.impl;

import com.wonders.shixi.mapper.TypeOneMapper;
import com.wonders.shixi.pojo.BookType;
import com.wonders.shixi.service.ITypeOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@ClassName TypeOneServiceImpl
 *@Author 乔翰林
 *@Date 2018/12/18
 **/
@Service
public class TypeOneServiceImpl implements ITypeOneService {
    @Autowired
    TypeOneMapper typeOneMapper;


    @Override
    public List<BookType> selectByBId(int bid) {
        return typeOneMapper.selectByBId(bid);
    }
}
