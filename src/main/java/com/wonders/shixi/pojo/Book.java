package com.wonders.shixi.pojo;

import java.util.Date;

public class Book {
    private Integer bookId;

    private String bookName;

    private String bookPeriodicals;

    private String bookCallnum;

    private String bookWriter;

    private String bookPress;

    private String bookCover;

    private String bookInfo;

    private Date bookTime;

    private Date bookUpdata;

    private String typeTwoValue;

    private String bookState;

    private Integer libraryId;

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
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookPeriodicals() {
        return bookPeriodicals;
    }

    public void setBookPeriodicals(String bookPeriodicals) {
        this.bookPeriodicals = bookPeriodicals == null ? null : bookPeriodicals.trim();
    }

    public String getBookCallnum() {
        return bookCallnum;
    }

    public void setBookCallnum(String bookCallnum) {
        this.bookCallnum = bookCallnum == null ? null : bookCallnum.trim();
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter == null ? null : bookWriter.trim();
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress == null ? null : bookPress.trim();
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover == null ? null : bookCover.trim();
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo == null ? null : bookInfo.trim();
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
        this.typeTwoValue = typeTwoValue == null ? null : typeTwoValue.trim();
    }

    public String getBookState() {
        return bookState;
    }

    public void setBookState(String bookState) {
        this.bookState = bookState == null ? null : bookState.trim();
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPeriodicals='" + bookPeriodicals + '\'' +
                ", bookCallnum='" + bookCallnum + '\'' +
                ", bookWriter='" + bookWriter + '\'' +
                ", bookPress='" + bookPress + '\'' +
                ", bookCover='" + bookCover + '\'' +
                ", bookInfo='" + bookInfo + '\'' +
                ", bookTime=" + bookTime +
                ", bookUpdata=" + bookUpdata +
                ", typeTwoValue='" + typeTwoValue + '\'' +
                ", bookState='" + bookState + '\'' +
                ", libraryId=" + libraryId +
                '}';
    }
}