package com.wonders.shixi.service.impl;


import com.wonders.shixi.mapper.BookLabelMapper;
import com.wonders.shixi.pojo.BookLabel;
import com.wonders.shixi.util.RestMsg;
import com.wonders.shixi.service.IBookLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @ClassName 图书查询控制器
 * @author 乔翰林
 * @date 2018.12.14
 */
@Service
public class BookLabelServiceImpl implements IBookLabelService {
    @Autowired
    BookLabelMapper bookLabelMapper;

    @Override
    public RestMsg<Object> findLabelAll() {
        System.out.println("进入service");
        RestMsg<Object> rm = new RestMsg<>();
        List<BookLabel> list = bookLabelMapper.selectByAll();
        System.out.println(list.size());
        if (list.size() != 0){
            rm.setResult(list);
            return rm.successMsg();
        }else {
            return rm.errorMsg("标签未找到");
        }
    }
}
