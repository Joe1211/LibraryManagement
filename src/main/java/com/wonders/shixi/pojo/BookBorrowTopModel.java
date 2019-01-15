package com.wonders.shixi.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName BookBorrowTopModel
 * @Author 乔翰林
 * @Date 2019/1/15
 **/
public class BookBorrowTopModel {
    private Integer bookId;

    private String bookName;

    private String bookPeriodicals;

    private String bookCallnum;

    private String bookWriter;

    private String bookPress;

    private String bookCover;

    private String bookInfo;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bookTime;

    private Date bookUpdata;

    private String typeTwoValue;

    private String bookState;

    private Integer libraryId;

    private Integer bookBorrow;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPeriodicals() {
        return bookPeriodicals;
    }

    public void setBookPeriodicals(String bookPeriodicals) {
        this.bookPeriodicals = bookPeriodicals;
    }

    public String getBookCallnum() {
        return bookCallnum;
    }

    public void setBookCallnum(String bookCallnum) {
        this.bookCallnum = bookCallnum;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    public Date getBookUpdata() {
        return bookUpdata;
    }

    public void setBookUpdata(Date bookUpdata) {
        this.bookUpdata = bookUpdata;
    }

    public String getTypeTwoValue() {
        return typeTwoValue;
    }

    public void setTypeTwoValue(String typeTwoValue) {
        this.typeTwoValue = typeTwoValue;
    }

    public String getBookState() {
        return bookState;
    }

    public void setBookState(String bookState) {
        this.bookState = bookState;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public Integer getBookBorrow() {
        return bookBorrow;
    }

    public void setBookBorrow(Integer bookBorrow) {
        this.bookBorrow = bookBorrow;
    }
}
