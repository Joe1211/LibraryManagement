package com.wonders.shixi.mapper;

import com.wonders.shixi.pojo.BookScore;

/**
 * @author 邱家锦
 */
public interface BookScoreMapper {
    BookScore selectByBookIdAndReaderId(BookScore bookScore);
    int insertBookScore(BookScore bookScore);
}
