package com.wonders.shixi.service.impl;



import com.wonders.shixi.mapper.BookMapper;
import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.pojo.BookBorrowModel;
import com.wonders.shixi.pojo.BookRecordModel;
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

//
//    @Override
//    public int findStateById(int bookId) {
//        return bookMapper.selectStateById(bookId);
//    }

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
     * 以借图书记录表,添加以借图书记录
     * @param bookId
     * @param readerId
     * @return
     */
    @Override
    public int addBookRecord(int bookId, int readerId) {
        return bookMapper.addBookRecord(bookId,readerId);
    }

    /**
     * 以借阅图书
     * @param bookId
     * @return
     */
    @Override
    public RestMsg<Object> selectByRecord(int bookId) {
        RestMsg<Object> rm = new RestMsg<>();
        List<BookRecordModel> brm = bookMapper.selectByBorrow(bookId);
        if (brm != null){
            rm.setResult(brm);
            return rm.successMsg("已借阅的图书");
        }else {
            return rm.errorMsg("没有已借阅的图书");
        }
    }

    /**
     * 以归还图书
     * @param bookId
     * @return
     */
    @Override
    public RestMsg<Object> selectByRepay(int bookId) {
        RestMsg<Object> rm = new RestMsg<>();
        List<BookRecordModel> brm = bookMapper.selectByRepay(bookId);
        if (brm != null){
            rm.setResult(brm);
            return rm.successMsg("已归还的图书");
        }else {
            return rm.errorMsg("没有已归还的图书");
        }
    }

    @Override
    public boolean updateByAddNumber(int bookId) {
        int i = bookMapper.updateByAddNumber(bookId);
        if (i>=1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateByState(int bookId, int readerId) {
        int i = bookMapper.updateByState(bookId,readerId);
        if (i>=1){
            return true;
        }
        return false;
    }

    @Override
    public List<BookBorrowModel> selectByBorrowAll() {
        return bookMapper.selectByBorrowAll();
    }


}
