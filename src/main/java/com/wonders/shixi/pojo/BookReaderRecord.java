package com.wonders.shixi.pojo;

import java.util.Date;

public class BookReaderRecord {
    private Integer bookReaderRecordId;

    private Integer readerId;

    private Integer bookId;

    private Integer bookReaderRecordState;

    private Date bookRecordTime;

    public Integer getBookReaderRecordId() {
        return bookReaderRecordId;
    }

    public void setBookReaderRecordId(Integer bookReaderRecordId) {
        this.bookReaderRecordId = bookReaderRecordId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBookReaderRecordState() {
        return bookReaderRecordState;
    }

    public void setBookReaderRecordState(Integer bookReaderRecordState) {
        this.bookReaderRecordState = bookReaderRecordState;
    }

    public Date getBookRecordTime() {
        return bookRecordTime;
    }

    public void setBookRecordTime(Date bookRecordTime) {
        this.bookRecordTime = bookRecordTime;
    }
}