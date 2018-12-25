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

    /**
     * 根据id查询图书
     * @param id
     * @return
     */
    @Override
    public Book selectByPrimaryKey(int id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    /**
     * 图书入库
     * @param book
     * @return
     */
    @Override
    public int insertBook(Book book) {
        return bookMapper.insert(book);
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

    /**
     * 根据图书类型查询图书
     * @param value
     * @return
     */
    @Override
    public List<Book> findTypeBook(String value) {
        return bookMapper.selectType(value);
    }

    /**
     * 根据bookId查询还有多少图书可借
     * @param bookId
     * @return
     */
    @Override
    public int selectNum(int bookId) {
        return bookMapper.selectNum(bookId);
    }

    /**
     * 根据图书id获取索书号，再将图书可借数量减一
     * @param bookId
     * @return
     */
    @Override
    public int updataByNumber(int bookId) {
        return bookMapper.updateByNumber(bookId);
    }

    /**
     * 以借图书记录表
     * @param bookId
     * @param readerId
     * @return
     */
    @Override
    public int addBookRecord(int bookId, int readerId) {
        return bookMapper.addBookRecord(bookId,readerId);
    }


}
