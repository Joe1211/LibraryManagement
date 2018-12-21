package com.wonders.shixi.mapper;/*
    @author 韩佳奇
    @date 2018/12/19
*/

import com.wonders.shixi.pojo.Book;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InformationMapper {

    @Select("select * from book")
    @Results(value= {@Result(id = true,property = "bookId",column = "book_id"),
                @Result(property = "bookPeriodicals", column = "book_periodicals"),
                @Result(property = "bookCallnum", column = "book_callnum"),
                @Result(property = "bookWriter", column = "book_writer"),
                @Result(property = "bookPress", column = "book_press"),
                @Result(property = "bookCover", column = "book_cover"),
                @Result(property = "bookInfo", column = "book_info"),
                @Result(property = "bookTime", column = "book_time"),
                @Result(property = "bookUpdata", column = "book_updata"),
                @Result(property = "typeTwoValue", column = "type_two_value"),
                @Result(property = "bookState", column = "book_state"),
                @Result(property = "libraryId", column = "library_id")})
    public List<Book> findAll();
}
