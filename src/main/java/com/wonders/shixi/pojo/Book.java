package com.wonders.shixi.pojo;

import java.util.Date;
import java.util.List;

public class Book {
    /**
     *图书id
     */
    private Integer bookId;
    /**
     *图书名
     */
    private String bookName;
    /**
     *期刊号
     */
    private String bookPeriodicals;
    /**
     *索书号
     */
    private String bookCallnum;
    /**
     * 作者
     */
    private String bookWriter;
    /**
     *出版社
     */
    private String bookPress;
    /**
     *封面
     */
    private String bookCover;
    /**
     *图书信息
     */
    private String bookInfo;
    /**
     *入库时间
     */
    private Date bookTime;
    /**
     *最后更新时间
     */
    private Date bookUpdata;
    /**
     *二级类目
     */
    private Integer typeTwoId;
    /**
     *图书馆id
     */
    private Integer libraryId;
    /**
     *图书状态
     */
    private String bookState;
    /**
     *图书标签
     */
    private List<BookLabel> label;

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

    public Integer getTypeTwoId() {
        return typeTwoId;
    }

    public void setTypeTwoId(Integer typeTwoId) {
        this.typeTwoId = typeTwoId;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public String getBookState() {
        return bookState;
    }

    public void setBookState(String bookState) {
        this.bookState = bookState == null ? null : bookState.trim();
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
                ", typeTwoId=" + typeTwoId +
                ", libraryId=" + libraryId +
                ", bookState='" + bookState + '\'' +
                '}';
    }
}