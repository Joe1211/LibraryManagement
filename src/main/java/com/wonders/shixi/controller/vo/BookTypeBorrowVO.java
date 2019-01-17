package com.wonders.shixi.controller.vo;

/**
 * 书记类别借阅
 *
 * @author 邱家锦
 */
public class BookTypeBorrowVO {
    private Integer bookTypeId = null;//类别主键
    private String bookTypeName = null;//类别名
    private Integer borrowSum = null;//借阅总数

    public Integer getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Integer bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    public Integer getBorrowSum() {
        return borrowSum;
    }

    public void setBorrowSum(Integer borrowSum) {
        this.borrowSum = borrowSum;
    }
}
