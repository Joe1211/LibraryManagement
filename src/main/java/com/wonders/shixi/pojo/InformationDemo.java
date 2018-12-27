package com.wonders.shixi.pojo;/*
    @author 韩佳奇
    @date 2018/12/27
*/

public class InformationDemo {
    private int bookPeriodicals;
    private int bookNumber;
    private int bookBorrow;
    private int bookClick;
    private String bookName;
    private String typeTwoValue;

    public InformationDemo() {
    }

    public InformationDemo(int bookPeriodicals, int bookNumber, int bookBorrow, int bookClick, String bookName, String typeTwoValue) {
        this.bookPeriodicals = bookPeriodicals;
        this.bookNumber = bookNumber;
        this.bookBorrow = bookBorrow;
        this.bookClick = bookClick;
        this.bookName = bookName;
        this.typeTwoValue = typeTwoValue;
    }

    public String getTypeTwoValue() {
        return typeTwoValue;
    }

    public void setTypeTwoValue(String typeTwoValue) {
        this.typeTwoValue = typeTwoValue;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPeriodicals() {
        return bookPeriodicals;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public int getBookBorrow() {
        return bookBorrow;
    }

    public int getBookClick() {
        return bookClick;
    }

    public void setBookPeriodicals(int bookPeriodicals) {
        this.bookPeriodicals = bookPeriodicals;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public void setBookBorrow(int bookBorrow) {
        this.bookBorrow = bookBorrow;
    }

    public void setBookClick(int bookClick) {
        this.bookClick = bookClick;
    }

    @Override
    public String toString() {
        return "InformationDemo{" +
                "bookPeriodicals=" + bookPeriodicals +
                ", bookNumber=" + bookNumber +
                ", bookBorrow=" + bookBorrow +
                ", bookClick=" + bookClick +
                ", bookName='" + bookName + '\'' +
                ", typeTwoValue='" + typeTwoValue + '\'' +
                '}';
    }
}
