package com.wonders.shixi.mapper;

import com.wonders.shixi.pojo.BookPeriodicals;

public interface BookPeriodicalsMapper {
    int deleteByPrimaryKey(Integer bookPeriodicalsId);

    int insert(BookPeriodicals record);

    int insertSelective(BookPeriodicals record);

    BookPeriodicals selectByPrimaryKey(Integer bookPeriodicalsId);

    int updateByPrimaryKeySelective(BookPeriodicals record);

    int updateByPrimaryKey(BookPeriodicals record);

    int insertISBN(BookPeriodicals bp);

    int updateClick(int bookId);

    int updateBorrow(int bookId);



}