package com.wonders.shixi.service;




import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.pojo.BookBorrowModel;
import com.wonders.shixi.pojo.BookRecordModel;
import com.wonders.shixi.util.RestMsg;

import java.util.List;
/**
 * @ClassName 图书查询控制器
 * @author 乔翰林
 * @date 2018.12.14
 */
public interface IBookService {
    Book selectByPrimaryKey(int id);

    int insertBook(Book book);

    List<Book> findDimBook(String s);

    List<Book> findLabelBook(String[] arr);

    List<Book> findTypeBook(String value);


//    int findStateById(int bookId);
    int selectNum(int bookId);

    int updataByNumber(int bookId);

    int addBookRecord(int bookId,int readerId);

    /**
     * 以借阅图书
     * @param bookId
     * @return
     */
    RestMsg<Object> selectByRecord(int bookId);

    /**
     * 以归还图书
     * @param bookId
     * @return
     */
    RestMsg<Object> selectByRepay(int bookId);
    /**
     * 归还，图书数量加1
     * @param bookId
     * @return
     */
    boolean updateByAddNumber(int bookId);

    /**
     * 根据读者id和图书id修改图书状态为已还（1）
     * @param bookId
     * @param readerId
     * @return
     */
    boolean updateByState(int bookId,int readerId);

    /**
     * 查询所有待还图书
     * @return
     */
    List<BookBorrowModel> selectByBorrowAll();
}
