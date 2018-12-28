package com.wonders.shixi.mapper;

import com.wonders.shixi.pojo.Library;

public interface LibraryMapper {
    int deleteByPrimaryKey(Integer libraryId);

    int insert(Library record);

    int insertSelective(Library record);

    Library selectByPrimaryKey(Integer libraryId);

    int updateByPrimaryKeySelective(Library record);

    int updateByPrimaryKey(Library record);
}