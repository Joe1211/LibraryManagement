package com.wonders.shixi.controller;

import com.wonders.shixi.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@Controller
@RequestMapping("api/reserve")
public class ReserveController {
    @Autowired
    BookServiceImpl bookService;
    String string;

    @RequestMapping("/borrowBook")
    @ResponseBody
    public void borrowBook(int bookId,HttpServletRequest request,HttpServletResponse response) throws IOException {
        String msg=null;
        String str=null;
//        String  id=request.getParameter("bookId");
//        int bookId=Integer.parseInt("id");
        int bookState=bookService.findStateById(bookId);
        if (bookState==1){
            msg="预约成功，请在6个小时之内取走书籍！";
            str=daoShu(6,request,response);
        }else {
            msg="预约失败,图书已借出，请过明日再来！";
        }
        request.getSession().setAttribute("reser",msg);
        response.sendRedirect("../../bookdetail.jsp");
    }
    public String daoShu(int day, HttpServletRequest request, HttpServletResponse response){

        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                string="时间不多了,请抓紧时间去借书";
                System.out.println("任务开始！！！");
                request.getSession().setAttribute("news",string);
                try {
                    response.sendRedirect("bookdetail.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.schedule(task,day*24*60*1000-3*24*60*1000);
        return string;
    }

}
