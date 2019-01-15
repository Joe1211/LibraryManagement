package com.wonders.shixi.service;

import com.wonders.shixi.controller.vo.BookScoreVO;
import com.wonders.shixi.pojo.BookScore;
import com.wonders.shixi.util.RestMsg;

/**
 * @author 邱家锦
 */
public interface IBookScoreService {

    RestMsg<BookScore> selectBookScoreByBookIdAndReaderId(BookScore bookScore);
    RestMsg<Object> insertBookScore(BookScore bookScore);
    RestMsg<BookScoreVO> selectBookScoreVOByBookId(int bookId);
}
