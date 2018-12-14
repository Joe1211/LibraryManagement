package com.wonders.shixi.pojo;

public class BookLabel {
    /**
     * 标签id
     */
    private Integer bookLabelId;
    /**
     * 标签名
     */
    private String bookLabel;

    public Integer getBookLabelId() {
        return bookLabelId;
    }

    public void setBookLabelId(Integer bookLabelId) {
        this.bookLabelId = bookLabelId;
    }

    public String getBookLabel() {
        return bookLabel;
    }

    public void setBookLabel(String bookLabel) {
        this.bookLabel = bookLabel == null ? null : bookLabel.trim();
    }
}