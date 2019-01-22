package com.wonders.shixi.service.impl;

import com.wonders.shixi.mapper.BookCommentMapper;
import com.wonders.shixi.pojo.BookComment;
import com.wonders.shixi.pojo.BookCommentLike;
import com.wonders.shixi.pojo.BookCommentModel;
import com.wonders.shixi.service.IBookCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCommentServiceImpl implements IBookCommentService {
    @Autowired
    BookCommentMapper mapper;
    @Override
    public List<BookCommentModel> selectAllById(int bookId,int readerId) {
        List<BookCommentModel> list = mapper.selectAllByBookId(bookId);
        for (BookCommentModel bcm:list) {
            if(bcm.getLikeCount()>0){
               int bcmId = bcm.getId();
               Integer i = mapper.findIsComment(bcmId,readerId);
               if (i!=null){
                    bcm.setStatus(1);
               }
            }
        }

        return list;
    }

    @Override
    public int intsertComment(BookComment record) {
        return mapper.insert(record);
    }

    @Override
    public List<BookComment> selectCommentAll() {
        return mapper.selectCommentAll();
    }

    @Override
    public int deleteComment(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addLike(BookCommentLike bcl) {
        return mapper.addLike(bcl);
    }

    @Override
    public int deleteLike(int bookCommentId, int readerId) {
        return mapper.deleteLike(bookCommentId, readerId);
    }

}
