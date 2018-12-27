package com.wonders.shixi.mapper;

import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.pojo.BookBorrowModel;
import com.wonders.shixi.pojo.BookRecordModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author
 */
public interface BookMapper {
    int deleteByPrimaryKey(Integer bookId);

    /**
     * 图书入库
     * @param book
     * @return
     */
    int insert(Book book);

    int insertSelective(Book record);

    /**
     * 图书出库
     * @param bookId
     * @return
     */
    com.wonders.shixi.pojo.Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    /**
     * 根据书名模糊查询
     * @param s
     * @return
     */
    List<Book> selectDimBook(@Param("bookName") String s);

    /**
     * 标签查询
     * @param label
     * @return
     */
    List<Book> selectLabelBook(String[] label);

    List<Book> selectType(String value);

    /**
     * 查询还有几本书可借
     * @param bookId
     * @return
     */
    int selectNum(int bookId);

    /**
     * 借阅，图书数量减一
     * @param bookId
     * @return
     */
    int updateByNumber(@Param("bookId")int bookId);

    /**
     * 归还，图书数量加1
     * @param bookId
     * @return
     */
    int updateByAddNumber(@Param("bookId")int bookId);

    /**
     * 根据读者id和图书id修改图书状态为已还（1）
     * @param bookId
     * @param readerId
     * @return
     */
    int updateByState(@Param("bookId")int bookId,@Param("readerId")int readerId);

    /**
     * 以借图书表
     * @param bookId
     * @param readerId
     * @return
     */
    int addBookRecord(@Param("bookId") int bookId,@Param("readerId")int readerId);

    /**
     * 以借图书（待归还）
     * @param bookId
     * @return
     */
    List<BookRecordModel> selectByBorrow(int bookId);

    /**
     * 以归还图书
     * @param bookId
     * @return
     */
    List<BookRecordModel> selectByRepay(int bookId);

    /**
     * 查询所有待还图书
     * @return
     */
    List<BookBorrowModel> selectByBorrowAll();
}