package com.wonders.shixi.service;

import com.wonders.shixi.pojo.BookComment;
import com.wonders.shixi.pojo.BookCommentLike;
import com.wonders.shixi.pojo.BookCommentModel;
import com.wonders.shixi.pojo.Model;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBookCommentService {

    public List<BookCommentModel> selectAllById(int bookId,int readerId);

    public int intsertComment(BookComment record);

    List<BookComment> selectCommentAll();

    int deleteComment(int id);

    int addLike(BookCommentLike bcl);

    int deleteLike(int bookCommentId,int readerId);
}
