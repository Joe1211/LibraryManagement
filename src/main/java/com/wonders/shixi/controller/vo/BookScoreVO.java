package com.wonders.shixi.controller.vo;

/**
 * 图书评分展示
 * @author 邱家锦
 */
public class BookScoreVO {
    private Integer bookId=null;
    private Float scoreAvg=null;
    private Integer scoreNum=null;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Float getScoreAvg() {
        return scoreAvg;
    }

    public void setScoreAvg(Float scoreAvg) {
        this.scoreAvg = scoreAvg;
    }

    public Integer getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(Integer scoreNum) {
        this.scoreNum = scoreNum;
    }
}
