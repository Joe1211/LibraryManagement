package com.wonders.shixi.service;/*
    @author 韩佳奇
    @date 2018/12/19
*/

import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.pojo.InformationDemo;
import com.wonders.shixi.pojo.TypeTwo;

import java.util.List;

public interface IInformationService {

    public List<Book> bookList();

    public void deletebook(int bookId);

    public int updatebook(Book book);

    public List<TypeTwo> typetwolist();

    public List<InformationDemo> findhostbook();

    public List<InformationDemo> findclickbook();
}
