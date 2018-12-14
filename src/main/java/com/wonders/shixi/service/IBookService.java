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

    /**
     * 图书入库
     * @param book
     * @return
     */
    RestMsg<Object> addBook(Book book);

    RestMsg<Object> deleteBook(int id);

    List<Book> findDimBook(String s);

    RestMsg<Object> findLabelBook(String[] arr);

    List<Book> findTypeBook(String... arr);
}
