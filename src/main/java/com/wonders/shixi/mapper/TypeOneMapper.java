package com.wonders.shixi.mapper;

import com.wonders.shixi.pojo.BookType;
import com.wonders.shixi.pojo.TypeOne;

import java.util.List;

public interface TypeOneMapper {
    int deleteByPrimaryKey(Integer typeOneId);

    int insert(TypeOne record);

    int insertSelective(TypeOne record);

    TypeOne selectByPrimaryKey(Integer typeOneId);

    int updateByPrimaryKeySelective(TypeOne record);

    int updateByPrimaryKey(TypeOne record);

    List<TypeOne> selectByBId(int bid);
}