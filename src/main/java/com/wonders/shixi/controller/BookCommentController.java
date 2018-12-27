package com.wonders.shixi.controller;


import com.wonders.shixi.pojo.BookComment;
import com.wonders.shixi.pojo.Model;
import com.wonders.shixi.service.impl.BookCommentServiceImpl;
import com.wonders.shixi.service.impl.ReaderServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("/api/bookcomment")
public class BookCommentController {

    @Autowired
    BookCommentServiceImpl bookCommentService;
    ReaderServiceImpl readerService;

    @RequestMapping("/select")
    @ResponseBody
    public List<Model> select(int bookId){
        List<Model> list=bookCommentService.selectAllById(bookId);
        return list;
    }

    @ApiOperation(value = "添加评论信息", httpMethod = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bookId",value="图书Id",required=true,dataType="int",paramType = "query"),
            @ApiImplicitParam(name="ReaderId",value="读者Id",required=true,dataType="int",paramType = "query"),
            @ApiImplicitParam(name="say",value="评论信息",required=true,dataType="String",paramType = "query")
    })
    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public int insertComment(Integer bookId, Integer readerId,String say){
        System.out.println(bookId+" "+readerId+" "+say);
        BookComment record=new BookComment();
        record.setBookId(bookId);
        record.setReaderId(readerId);
        record.setComment(say);
        System.out.println(record);
        int num=bookCommentService.intsertComment(record);
        System.out.println(num);
        return num;
    }
}
