package com.wonders.shixi.mapper;

import com.wonders.shixi.pojo.BookType;

import java.util.List;

public interface BookTypeMapper {
    int deleteByPrimaryKey(Integer bookTypeId);

    int insert(BookType record);

    int insertSelective(BookType record);

    BookType selectByPrimaryKey(Integer bookTypeId);

    int updateByPrimaryKeySelective(BookType record);

    int updateByPrimaryKey(BookType record);

    List<BookType> selectAll();
}