package com.wonders.shixi.pojo;

public class BookLabelRelation {
    private Integer bookLabelRelation;

    private Integer bookId;

    private Integer bookLabelId;

    public BookLabelRelation() {
    }

    public BookLabelRelation(Integer bookId, Integer bookLabelId) {
        this.bookId = bookId;
        this.bookLabelId = bookLabelId;
    }

    public Integer getBookLabelRelation() {
        return bookLabelRelation;
    }

    public void setBookLabelRelation(Integer bookLabelRelation) {
        this.bookLabelRelation = bookLabelRelation;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBookLabelId() {
        return bookLabelId;
    }

    public void setBookLabelId(Integer bookLabelId) {
        this.bookLabelId = bookLabelId;
    }
}