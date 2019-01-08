package com.wonders.shixi.pojo;/**
 * @Auther: qiaohanlin
 * @Date: 2019/1/8 13:26
 * @Description:
 */

import java.util.Date;

/**
 *@ClassName BookResidueTimeModel
 *@Author 乔翰林
 *@Date 2019/1/8
 **/
public class BookResidueTimeModel {
    private Integer bookReaderRecordId;

    private Integer readerId;

    private Integer bookId;

    private Integer bookReaderRecordState;

    private Date bookRecordTime;

    private Integer bookResidueTime;

    private String readerEmail;

    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

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

    public Integer getBookResidueTime() {
        return bookResidueTime;
    }

    public void setBookResidueTime(Integer bookResidueTime) {
        this.bookResidueTime = bookResidueTime;
    }

    public String getReaderEmail() {
        return readerEmail;
    }

    public void setReaderEmail(String readerEmail) {
        this.readerEmail = readerEmail;
    }
}
