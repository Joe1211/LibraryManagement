package com.wonders.shixi.pojo;

import java.sql.Timestamp;

/**
 * 图书评分
 * @author 邱家锦
 */
public class BookScore {
    private Integer id=null;//主键id
    private Integer score=null;//评分
    private Timestamp updateTime=null;//更新时间
    private Book book=null;//对应图书
    private Reader reader=null;//对应读者

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
