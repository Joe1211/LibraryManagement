package com.wonders.shixi.service.impl;/*
    @author 韩佳奇
    @date 2018/12/19
*/

import com.wonders.shixi.mapper.InformationMapper;
import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.service.IInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("IInformationService")
public class InformationServiceimpl implements IInformationService {
    @Autowired
    InformationMapper informationMapper;

    @Override
    public List<Book> bookList() {
        return informationMapper.findAll();
    }
}
