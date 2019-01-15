package com.wonders.shixi.service.impl;

import com.wonders.shixi.controller.vo.BookScoreVO;
import com.wonders.shixi.mapper.BookScoreMapper;
import com.wonders.shixi.pojo.BookScore;
import com.wonders.shixi.service.IBookScoreService;
import com.wonders.shixi.util.RestMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author 邱家锦
 */
@Service
public class BookScoreServiceImpl implements IBookScoreService {
    @Autowired
    private BookScoreMapper bookScoreMapper;

    @Override
    public RestMsg<BookScore> selectBookScoreByBookIdAndReaderId(BookScore bookScore) {
        RestMsg<BookScore> msg=new RestMsg<BookScore>();
        BookScore result=bookScoreMapper.selectByBookIdAndReaderId(bookScore);
        if(result!=null){
            msg.setResult(result);
            return msg.successMsg("获取评分成功");
        }else{
            return msg.errorMsg("获取评分失败");
        }
    }

    @Override
    public RestMsg<Object> insertBookScore(BookScore bookScore) {
        bookScore.setUpdateTime(new Timestamp(new Date().getTime()));
        RestMsg<Object> msg=new RestMsg<Object>();
        int insertNum=bookScoreMapper.insertBookScore(bookScore);
        if(insertNum>0){
            return msg.successMsg("评分成功");
        }else{
            return msg.errorMsg("评分失败");
        }
    }

    @Override
    public RestMsg<BookScoreVO> selectBookScoreVOByBookId(int bookId) {
        RestMsg<BookScoreVO> restMsg=new RestMsg<BookScoreVO>();
        BookScoreVO vo=bookScoreMapper.selectBookScoreVOByBookId(bookId);
        if(vo!=null&&vo.getScoreAvg()!=null){
            restMsg.setResult(vo);
            return restMsg.successMsg("获取成功");
        }else{
            return restMsg.errorMsg("获取失败");
        }
    }
}
