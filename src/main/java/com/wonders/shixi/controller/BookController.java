package com.wonders.shixi.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.util.RestMsg;
import com.wonders.shixi.service.IBookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName 图书查询控制器
 * @author 乔翰林
 * @date 2018.12.14
 */
@Controller
@RequestMapping("api/books")
public class BookController {

    @Autowired
    IBookService bookService;

    /**
     * 模糊搜索(根据图书名查找图书)
     * @param bookname 书名
     * @param pn 页数
     * @return RestMsg(状态码、消息、图书集合)
     */
    @ApiOperation(value = "根据书名查找图书", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bookname",value="图书名",required=true,dataType="String",paramType = "query")
    })
    @GetMapping("/books")
    @ResponseBody
    public RestMsg<Object> findDimBook(String bookname, @RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn){
        RestMsg<Object> rm = new RestMsg<>();
        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn,5);
        //startPage后紧跟的这个查询就是分页查询
        List<Book> list = bookService.findDimBook(bookname);
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(list,5);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        rm.successMsg();
        rm.setResult(pageInfo);
        return rm;
    }

    /**
     * 根据标签搜索
     * @param   lab 标签字符串
     * @return  RestMsg(状态码、消息、图书集合)
     */
    @ApiOperation(value = "根据标签查找图书", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="label",value="标签名",required=true,dataType="String",paramType = "query")
    })
    @GetMapping("/label")
    @ResponseBody
    public RestMsg<Object> findLabelBook( String lab,@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn){
        RestMsg<Object> rm = new RestMsg<>();
        //将前台字符串（标签id）以","分开并放入数组中
        String[] arr = lab.split(",");
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn,5);
        //startPage后紧跟的这个查询就是分页查询
        List<Book> list = bookService.findLabelBook(arr);
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(list,5);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        if (pageInfo.getList().size() != 0){
            rm.setResult(pageInfo);
            return rm.successMsg();
        }else {
            return rm.errorMsg("没有该标签的图书");
        }
    }

    /**
     * 分类搜索
     * @param arr
     * @return
     */
    public List<Book> findTypeBook(String... arr){
        return  bookService.findTypeBook();
    }

    /**
     * 图书入库
     */
    @PostMapping("/add")
    @ResponseBody
    public RestMsg<Object> addBook(HttpServletRequest request){
        //获取页面参数
        String bookName = request.getParameter("bookName");
        String bookPeriodicals = request.getParameter("bookPeriodicals");
        String bookCallnum = request.getParameter("bookCallnum");
        String bookWriter = request.getParameter("bookWriter");
        String bookPress = request.getParameter("bookPress");
        String bookCover = request.getParameter("bookCover");
        String bookInfo = request.getParameter("bookInfo");
        String typeTwoId = request.getParameter("typeTwoId");
        String libraryId = request.getParameter("libraryId");
        String bookState = request.getParameter("bookState");

        //将值传入book
        Book b = new Book();
        b.setBookName(bookName);
        b.setBookPeriodicals(bookPeriodicals);
        b.setBookCallnum(bookCallnum);
        b.setBookWriter(bookWriter);
        b.setBookPress(bookPress);
        b.setBookCover(bookCover);
        b.setBookInfo(bookInfo);
        b.setTypeTwoId(Integer.parseInt(typeTwoId));
        b.setLibraryId(Integer.parseInt(libraryId));
        b.setBookState(bookState);

        return bookService.addBook(b);
    }


    /**
     * 根据图书id删除图书
     * @param id 图书id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public RestMsg<Object> deleteBook(@PathVariable("id") int id){
        return bookService.deleteBook(id);
    }
}
