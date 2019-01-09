package com.wonders.shixi.controller;/**
 * @Auther: qiaohanlin
 * @Date: 2019/1/9 13:39
 * @Description:
 */

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.wonders.shixi.pojo.BookResidueTimeModel;
import com.wonders.shixi.service.IBookService;
import com.wonders.shixi.service.impl.BookServiceImpl;
import com.wonders.shixi.util.MailUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Quartz job
 *@ClassName EmailJob
 *@Author 乔翰林
 *@Date 2019/1/9
 **/

@Service
public class EmailJob implements Job {

    @Autowired
    IBookService bookService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //Service注入
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        //具体的业务逻辑
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<BookResidueTimeModel> list = bookService.selectResidueTime(sdf.format(date));
        for(BookResidueTimeModel list1:list) {
            int time = list1.getBookResidueTime();
            String bookName = list1.getBookName();
            String email = list1.getReaderEmail();
            if(time>=25&&time<=26){
                MailUtil.sendEmail(bookName,5,email);
            }else if(time>=28&&time<=29){
                MailUtil.sendEmail(bookName,1,email);
            }else if(time>=30){
                MailUtil.sendEmailOut(bookName,time-30,email);
            }
        }
    }
}