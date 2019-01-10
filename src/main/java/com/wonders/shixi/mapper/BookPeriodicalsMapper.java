package com.wonders.shixi.mapper;

import com.wonders.shixi.pojo.BookPeriodicals;

public interface BookPeriodicalsMapper {
    int deleteByPrimaryKey(Integer bookPeriodicalsId);

    int insert(BookPeriodicals record);

    int insertSelective(BookPeriodicals record);

    BookPeriodicals selectByPrimaryKey(Integer bookPeriodicalsId);

    int updateByPrimaryKeySelective(BookPeriodicals record);

    int updateByPrimaryKey(BookPeriodicals record);

    /**
     * 将ISBN添加到book_periodicals表中
     * @param isbn
     * @return
     */
    int insertISBN(BookPeriodicals bp);


}