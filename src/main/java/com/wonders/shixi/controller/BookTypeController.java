package com.wonders.shixi.controller;/**
 * @Auther: qiaohanlin
 * @Date: 2018/12/18 08:58
 * @Description:
 */

import com.wonders.shixi.pojo.BookType;
import com.wonders.shixi.service.IBookTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *@ClassName BookTypeController 中图法部类
 *@Author 乔翰林
 *@Date 2018/12/18
 **/
@Controller
@RequestMapping("api/booktypes")
public class BookTypeController {

    @Autowired
    IBookTypeService bookTypeService;

    @ApiOperation(value = "查找所有中图法部类", httpMethod = "GET")
    @GetMapping
    @ResponseBody
    public List<BookType> selectAll(){
        return bookTypeService.selectAll();
    }

}
