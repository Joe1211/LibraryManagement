package com.wonders.shixi.mapper;

import com.wonders.shixi.pojo.BookComment;
import com.wonders.shixi.pojo.Model;

import java.util.List;

public interface BookCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookComment record);

    int insertSelective(BookComment record);

    BookComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookComment record);

    int updateByPrimaryKey(BookComment record);

    /**
     * 根据bookId查询
     * @param bookId
     * @return
     */
    List<BookComment> selectByBookId(Integer bookId);

    List<Model> selectAllByBookId(Integer bookId);
}