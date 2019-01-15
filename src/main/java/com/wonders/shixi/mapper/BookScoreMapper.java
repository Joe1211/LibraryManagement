package com.wonders.shixi.mapper;

import com.wonders.shixi.controller.vo.BookScoreVO;
import com.wonders.shixi.pojo.BookScore;

/**
 * @author 邱家锦
 */
public interface BookScoreMapper {
    BookScore selectByBookIdAndReaderId(BookScore bookScore);
    int insertBookScore(BookScore bookScore);
    BookScoreVO selectBookScoreVOByBookId(int bookId);
}
