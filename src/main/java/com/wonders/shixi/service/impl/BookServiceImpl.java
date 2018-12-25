package com.wonders.shixi.service.impl;



import com.wonders.shixi.mapper.BookMapper;
import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.util.RestMsg;
import com.wonders.shixi.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @ClassName 图书查询控制器
 * @author 乔翰林
 * @date 2018.12.14
 */
@Service("bookService")
public class BookServiceImpl implements IBookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public Book selectByPrimaryKey(int id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据图书名模糊查询图书
     * @param s
     * @return
     */
    @Override
    public List<Book> findDimBook(String s) {
       return bookMapper.selectDimBook(s);
    }

    /**
     * 根据标签查询图书
     * @param arr
     * @return
     */
    @Override
    public List<Book> findLabelBook(String[] arr) {
        return bookMapper.selectLabelBook(arr);
    }

    @Override
    public List<Book> findTypeBook(String value) {
        return bookMapper.selectType(value);
    }

    @Override
    public int findStateById(int bookId) {

        return bookMapper.selectStateById(bookId);
    }


}
