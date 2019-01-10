package com.wonders.shixi.service.impl;/**
 * @Auther: qiaohanlin
 * @Date: 2019/1/10 10:05
 * @Description:
 */

import com.wonders.shixi.mapper.BookPeriodicalsMapper;
import com.wonders.shixi.pojo.BookPeriodicals;
import com.wonders.shixi.service.IBookPeriodicalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@ClassName BookPeriodicalsImpl
 *@Author 乔翰林
 *@Date 2019/1/10
 **/
@Service
public class BookPeriodicalsImpl implements IBookPeriodicalsService {

    @Autowired
    BookPeriodicalsMapper bookPeriodicalsMapper;

    /**
     * 将ISBN添加到book_periodicals表中
     * @param bp
     * @return
     */
    @Override
    public int insertISBN(BookPeriodicals bp) {
        return bookPeriodicalsMapper.insertISBN(bp);
    }
}
