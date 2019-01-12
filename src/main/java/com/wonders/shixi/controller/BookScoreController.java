package com.wonders.shixi.controller;

import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.pojo.BookScore;
import com.wonders.shixi.pojo.Reader;
import com.wonders.shixi.service.IBookScoreService;
import com.wonders.shixi.util.RestMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 邱家锦
 */
@RestController
@RequestMapping("api/bookScore")
public class BookScoreController {
    @Autowired
    private IBookScoreService bookScoreService;

    @RequestMapping("selectBookScoreByBookAndReader")
    public RestMsg<BookScore> selectBookScoreByBookAndReader(Book book,HttpSession session){
        BookScore bookScore=new BookScore();
        bookScore.setBook(book);
        bookScore.setReader((Reader)session.getAttribute("reader"));
        RestMsg<BookScore> msg=bookScoreService.selectBookScoreByBookIdAndReaderId(bookScore);
        return msg;
    }

    @RequestMapping("insertBookScore")
    public RestMsg<Object> insertBookScore(Book book,BookScore bookScore, HttpSession session){
        Reader user=(Reader)session.getAttribute("reader");
        bookScore.setReader(user);
        bookScore.setBook(book);
        RestMsg<Object> msg=bookScoreService.insertBookScore(bookScore);
        return msg;
    }
}
