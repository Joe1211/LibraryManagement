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
     * @param isbn
     * @return
     */
    int insertISBN(BookPeriodicals bp);
}
