package com.wonders.shixi.mapper;

import com.wonders.shixi.pojo.BookType;
import com.wonders.shixi.pojo.TypeTwo;

import java.util.List;

public interface TypeTwoMapper {
    int deleteByPrimaryKey(Integer typeTwoId);

    int insert(TypeTwo record);

    int insertSelective(TypeTwo record);

    TypeTwo selectByPrimaryKey(Integer typeTwoId);

    int updateByPrimaryKeySelective(TypeTwo record);

    int updateByPrimaryKey(TypeTwo record);

    List<BookType> selectByOId(String value);

}