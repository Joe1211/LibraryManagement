package com.wonders.shixi.pojo;

public class BookPeriodicals {
    private Integer bookPeriodicalsId;

    private Integer bookId;

    private String bookPeriodicals;

    private Integer bookBorrow;

    private Integer bookClick;

    private Integer bookNumber;

    public Integer getBookPeriodicalsId() {
        return bookPeriodicalsId;
    }

    public void setBookPeriodicalsId(Integer bookPeriodicalsId) {
        this.bookPeriodicalsId = bookPeriodicalsId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookPeriodicals() {
        return bookPeriodicals;
    }

    public void setBookPeriodicals(String bookPeriodicals) {
        this.bookPeriodicals = bookPeriodicals == null ? null : bookPeriodicals.trim();
    }

    public Integer getBookBorrow() {
        return bookBorrow;
    }

    public void setBookBorrow(Integer bookBorrow) {
        this.bookBorrow = bookBorrow;
    }

    public Integer getBookClick() {
        return bookClick;
    }

    public void setBookClick(Integer bookClick) {
        this.bookClick = bookClick;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }
}