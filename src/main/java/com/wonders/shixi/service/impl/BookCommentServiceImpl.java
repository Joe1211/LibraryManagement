package com.wonders.shixi.service.impl;

import com.wonders.shixi.mapper.BookCommentMapper;
import com.wonders.shixi.pojo.BookComment;
import com.wonders.shixi.pojo.Model;
import com.wonders.shixi.service.IBookCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCommentServiceImpl implements IBookCommentService {
    @Autowired
    BookCommentMapper mapper;
    @Override
    public List<Model> selectAllById(int bookId) {
        return mapper.selectAllByBookId(bookId);
    }

    @Override
    public int intsertComment(BookComment record) {
        return mapper.insert(record);
    }
}
