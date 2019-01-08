package com.wonders.shixi.controller;
/*
    @author 韩佳奇
    @date 2018/12/17
*/

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.pojo.InformationDemo;
import com.wonders.shixi.pojo.TypeTwo;
import com.wonders.shixi.service.IBookService;
import com.wonders.shixi.service.IInformationService;
import com.wonders.shixi.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class InformationController {

    @Autowired
    private IInformationService informationService;
    @Autowired
    IBookService bookService;

    @RequestMapping(value = "/bookListFenYe",method = {RequestMethod.POST,RequestMethod.GET})
    //@ResponseBody
    public Object bookListFenye(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize, Model model){

        PageHelper.startPage(pageNum,pageSize);
        List<Book> bookList=informationService.bookList();

        PageInfo pageInfo=new PageInfo<>(bookList);

        model.addAttribute("pageinfo",pageInfo);
        return "forward:/management/bookinformation.jsp";
        //return pageInfo;
    }

    @RequestMapping(value = "/delete",method = {RequestMethod.POST,RequestMethod.GET})
    public String deletebook(@RequestParam(value = "bookId")Integer bookId){
        System.out.println("bookid="+bookId);
        informationService.deletebook(bookId);
        return "redirect:/admin/bookListFenYe";
    }

    @RequestMapping(value = "/findbookbyid",method = {RequestMethod.POST,RequestMethod.GET})

    public Object selcetById(@RequestParam(value = "bookId") Integer bookId,Model model) {
        Book book=bookService.selectByPrimaryKey(bookId);
        model.addAttribute("book",book);
        return "forward:/management/updatebook.jsp";
    }

    @RequestMapping(value = "/updatebook",method = {RequestMethod.POST,RequestMethod.GET})
    public String updatebook(Book book, MultipartFile bimg) {
        try {
//            //将图片保存在磁盘目录
//            bimg.transferTo(new File("D:/code/"+file.getOriginalFilename()));
//            //设置值，将路径存入数据库
//            book.setBookCover("/bookCover/"+file.getOriginalFilename());
            String base64Str= Base64Util.encode(bimg.getInputStream());
            book.setBookCover(base64Str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date bookUpdata=new Date();
        book.setBookUpdata(bookUpdata);
        System.out.println(book);
        informationService.updatebook(book);
        return "redirect:/admin/bookListFenYe";
    }

    @RequestMapping(value = "/findbookTypeList",method = RequestMethod.POST)
    @ResponseBody
    public List<TypeTwo> findbooktypelist(){
        List<TypeTwo> list=informationService.typetwolist();
        System.out.println(list);
        return list;
    }

    @RequestMapping(value = "/findhostbook",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<InformationDemo> findhostbook(){
        System.out.println(informationService.findhostbook().toString());
        return informationService.findhostbook();
    }

    @RequestMapping(value = "/findclickbook",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public  List<InformationDemo> findclickbook(){
        return informationService.findclickbook();
    }
}
