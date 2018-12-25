package com.wonders.shixi.mapper;

import com.wonders.shixi.pojo.Book;
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
     * @param record
     * @return
     */
    int insert(Book record);

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

    int selectStateById(int Bookid);
}