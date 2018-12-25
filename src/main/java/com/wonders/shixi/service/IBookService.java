package com.wonders.shixi.service;




import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.util.RestMsg;

import java.util.List;
/**
 * @ClassName 图书查询控制器
 * @author 乔翰林
 * @date 2018.12.14
 */
public interface IBookService {
    Book selectByPrimaryKey(int id);

    int insertBook(Book book);

    List<Book> findDimBook(String s);

    List<Book> findLabelBook(String[] arr);

    List<Book> findTypeBook(String value);

    int findStateById(int bookId);
}
