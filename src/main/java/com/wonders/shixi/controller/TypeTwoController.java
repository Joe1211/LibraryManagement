package com.wonders.shixi.controller;/**
 * @Auther: qiaohanlin
 * @Date: 2018/12/18 09:00
 * @Description:
 */

import com.wonders.shixi.pojo.BookType;
import com.wonders.shixi.service.IBookTypeService;
import com.wonders.shixi.service.ITypeTwoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *@ClassName TypeTwoController 中图法二级分类
 *@Author 乔翰林
 *@Date 2018/12/18
 **/
@Controller
@RequestMapping("api/typetwos")
public class TypeTwoController {
    @Autowired
    ITypeTwoService typeTwoService;

    @ApiOperation(value = "查找所有中图法二级分类", httpMethod = "GET")
    @GetMapping("/{ovalue}")
    @ResponseBody
    public List<BookType> selectAll(@PathVariable("ovalue")String ovalue){
        return typeTwoService.selectByOId(ovalue);
    }
}
