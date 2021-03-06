package com.wonders.shixi.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wonders.shixi.mapper.BookMapper;
import com.wonders.shixi.pojo.*;
import com.wonders.shixi.service.IBookService;
import com.wonders.shixi.util.RestMsg;
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
     * 图书入库时添加标签
     * @return
     */
    @Override
    public int bookLabelAdd(BookLabelRelation br) {
        return bookMapper.bookLabelAdd(br);
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
     * 以借图书记录表,添加到借图书记录
     * @param bookId
     * @param readerId
     * @return
     */
    @Override
    public int addBookRecord(int bookId, int readerId) {
        int i = bookMapper.addBookRecord(bookId,readerId);
        System.out.println("借阅记录表id------>"+i);
        return i;
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
    public boolean updateByState(int brrId) {
        int i = bookMapper.updateByState(brrId);
        if (i>=1){
            return true;
        }
        return false;
    }

    @Override
    public List<BookBorrowModel> selectByBorrowAll() {
        return bookMapper.selectByBorrowAll();
    }

    @Override
    public int selectByBid(int id) {
        return bookMapper.selectByBid(id);
    }

    @Override
    public String findBookCoverById(int id) {
        String data=bookMapper.selectBookCoverById(id);
        return "".equals(data)?null:data;
    }

    @Override
    public List<BookResidueTimeModel> selectResidueTime(String currentTime) {
        return bookMapper.selectResidueTime(currentTime);
    }

    /**
     * 首页每日推荐8本图书
     * @return
     */
    @Override
    public List<Book> randomBook(){
        List<Book> list = bookMapper.randomBook();
        return list;
    }

    /**
     * 图书借阅排行榜
     * @return
     */
    @Override
    public RestMsg<Object> borrowTop(int currentPage,int pageSize){
        RestMsg<Object> rm = new RestMsg<>();
        PageHelper.startPage(currentPage,pageSize);
        List<BookBorrowTopModel> list = bookMapper.borrowTop();
        if (list.size()!=0){
            PageInfo<BookBorrowTopModel> pageInfo=new PageInfo<BookBorrowTopModel>(list);
            rm.setResult(pageInfo);
            return rm.successMsg();
        }else{
            return rm.errorMsg("暂无排行榜");
        }
    }

    @Override
    public Integer findISBN(String isbn){
        return bookMapper.findISBN(isbn);
    }
}
