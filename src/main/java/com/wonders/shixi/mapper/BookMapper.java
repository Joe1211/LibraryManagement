package com.wonders.shixi.mapper;

import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.pojo.BookBorrowModel;
import com.wonders.shixi.pojo.BookRecordModel;
import com.wonders.shixi.pojo.BookResidueTimeModel;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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
    Book selectByPrimaryKey(Integer bookId);

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
    int updateByNumber(@Param("bookId") int bookId);

    /**
     * 归还，图书数量加1
     * @param bookId
     * @return
     */
    int updateByAddNumber(@Param("bookId") int bookId);

    /**
     * 根据读者id和图书id修改图书状态为已还（1）
     * @param brrId
     * @return
     */
    int updateByState(int brrId);

    /**
     * 以借图书表
     * @param bookId
     * @param readerId
     * @return
     */
    int addBookRecord(@Param("bookId") int bookId, @Param("readerId") int readerId);

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

    /**
     * 根据借阅记录表id,查对应的图书id
     * @return
     */
    int selectByBid(@Param("bookReaderRecordId")int bookReaderRecordId);

    /**
     * 根据主键查询图书封面
     * @param id
     * @return
     */
    String selectBookCoverById(Integer id);

    /**
     * 查询未还图书剩余免费借阅时间
     * @param currentTime
     * @return
     */
    List<BookResidueTimeModel> selectResidueTime(String currentTime);

    /**
     * 首页每日推荐8本图书
     * @return
     */
    List<Book> randomBook();
}