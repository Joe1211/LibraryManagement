package com.wonders.shixi.service;

import com.wonders.shixi.pojo.BookComment;
import com.wonders.shixi.pojo.BookCommentModel;
import com.wonders.shixi.pojo.Model;

import java.util.List;

public interface IBookCommentService {

    public List<BookCommentModel> selectAllById(int bookId,int readerId);

    public int intsertComment(BookComment record);

    List<BookComment> selectCommentAll();

    int deleteComment(int id);
}
