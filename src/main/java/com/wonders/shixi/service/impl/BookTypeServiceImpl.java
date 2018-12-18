package com.wonders.shixi.service.impl;/**
 * @Auther: qiaohanlin
 * @Date: 2018/12/18 09:47
 * @Description:
 */

import com.wonders.shixi.mapper.BookTypeMapper;
import com.wonders.shixi.pojo.BookType;
import com.wonders.shixi.service.IBookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@ClassName BookTypeServiceImpl
 *@Author 乔翰林
 *@Date 2018/12/18
 **/
@Service
public class BookTypeServiceImpl implements IBookTypeService {

    @Autowired
    BookTypeMapper bookTypeMapper;

    @Override
    public List<BookType> selectAll() {
        return bookTypeMapper.selectAll();
    }
}
