package com.wonders.shixi.controller;
/*
    @author 韩佳奇
    @date 2018/12/17
*/

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.service.IInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class InformationController {

    @Autowired
    private IInformationService informationService;

    @RequestMapping(value = "/admin/bookListFenYe",method = {RequestMethod.POST,RequestMethod.GET})
    public String bookListFenye(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize, Model model){

        System.out.println("pageNum="+pageNum+",pageSize="+pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<Book> bookList=informationService.bookList();
        System.out.println(bookList.toString());
        PageInfo<Book> pageInfo=new PageInfo<Book>(bookList);


        model.addAttribute("bookList",bookList);
        model.addAttribute("pageInfo",pageInfo);
        return "/management/bookinformation.jsp";
    }
}
