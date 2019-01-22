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

    /**
     * 根据图书id查询该书评论
     * @param bookId
     * @param readerId
     * @return
     */
    @Override
    public List<BookCommentModel> selectAllById(int bookId,int readerId) {
        List<BookCommentModel> list = mapper.selectAllByBookId(bookId);
        for (BookCommentModel bcm:list) {
            if(bcm.getLikeCount()>0){
               int bcmId = bcm.getId();
               //根据bookId和readerId判断是否给该条评论点过赞
               Integer i = mapper.findIsComment(bcmId,readerId);
               if (i!=null){
                   //点过赞，状态为1，默认为null
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

    /**
     * 前3条数据根据点赞数排序
     * @param bookId
     * @return
     */
    @Override
    public List<BookCommentModel> likeSort(int bookId) {
        return mapper.likeSort(bookId);
    }

}
