package com.wonders.shixi.controller;
import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.pojo.BookResidueTimeModel;
import com.wonders.shixi.pojo.RedisPool;
import com.wonders.shixi.service.IBookService;
import com.wonders.shixi.util.MailUtil;
import com.wonders.shixi.util.SerialoizebleUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 *@ClassName RecommendJob
 *@Author 乔翰林
 *@Date 2019/1/14
 **/
public class RecommendJob implements Job {
    @Autowired
    IBookService bookService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //Service注入
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        //具体的业务逻辑
        System.out.println("修改每日推荐");
        Jedis jedis = RedisPool.getJedis();
        String k = "tushu";
        byte[] key = k.getBytes();
        List<Book> list = bookService.randomBook();
        byte[] value = SerialoizebleUtil.serializeList(list);
        jedis.set(key,value);
    }
}
