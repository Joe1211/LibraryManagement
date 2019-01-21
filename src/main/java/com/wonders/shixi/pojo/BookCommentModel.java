package com.wonders.shixi.pojo;

import java.util.Date;

/**
 * @ClassName BookCommentModel
 * @Author 乔翰林
 * @Date 2019/1/21
 **/
public class BookCommentModel {
    private int id;
    private int bookId;
    private int readerId;
    private String ReaderName;
    private String comment;
    private Date updateTime;
    private int likeCount;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getReaderName() {
        return ReaderName;
    }

    public void setReaderName(String readerName) {
        ReaderName = readerName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCout) {
        this.likeCount = likeCout;
    }
}
