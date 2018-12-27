package com.wonders.shixi.mapper;/*
    @author 韩佳奇
    @date 2018/12/19
*/

import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.pojo.TypeTwo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface InformationMapper {

    @Select("select * from book")
    @Results(value= {@Result(id = true,property = "bookId",column = "book_id"),
                @Result(property = "bookPeriodicals", column = "book_periodicals"),
                @Result(property = "bookName", column = "book_name"),
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

    @Delete("delete from book where book_id=#{bookId}")
    public void deletebook(@Param("bookId") int bookId);

    @Update("update book set book_name=#{bookName},book_periodicals=#{bookPeriodicals}, book_callnum=#{bookCallnum},book_writer=#{bookWriter},book_press=#{bookPress},book_cover=#{bookCover},book_info=#{bookInfo},book_updata=#{bookUpdata},library_id=#{libraryId} where book_id=#{bookId}")
    public int updatebook(Book book);//type_two_value=#{typeTwoValue},book_state=#{bookState},

    @Select("select type_two_id,type_one_id,type_two_type,type_two_value from type_two")
    @Results(value = {@Result(id = true,property = "typeTwoId",column = "type_two_id"),
            @Result(property = "typeOneId", column = "type_one_id"),
            @Result(property = "typeTwoType", column = "type_two_type"),
            @Result(property = "typeTwoValue", column = "type_two_value")})
    public List<TypeTwo> findbooktype();
}
