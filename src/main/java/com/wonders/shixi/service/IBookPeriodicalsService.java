package com.wonders.shixi.service;

import com.wonders.shixi.pojo.BookPeriodicals;

/**
 * @Auther: qiaohanlin
 * @Date: 2019/1/10 09:59
 * @Description:
 */
public interface IBookPeriodicalsService {
    /**
     * 将ISBN添加到book_periodicals表中
     * @param bp
     * @return
     */
    int insertISBN(BookPeriodicals bp);

    /**
     * 点击次数
     * @param bookId
     * @return
     */
    int updateClick(int bookId);

    /**
     * 借阅次数
     * @param bookId
     * @return
     */
    int updateBorrow(int bookId);
}
