package com.wonders.shixi.pojo;

import java.util.Date;

public class BookComment {
    private Integer id;

    private Integer bookId;

    private Integer readerId;

    private String comment;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BookComment{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", comment='" + comment + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}