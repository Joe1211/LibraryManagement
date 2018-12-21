package com.wonders.shixi.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.util.RestMsg;
import com.wonders.shixi.service.IBookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    Book b = new Book();

    @PostMapping("/add")
    @ResponseBody
    public void addBook(HttpServletRequest request, HttpServletResponse response){

        //检查请求是否是multipart/form-data类型
            if(!ServletFileUpload.isMultipartContent(request)){
                //不是multipart/form-data类型
                throw new RuntimeException("表单的enctype属性不是multipart/form-data类型！！");
            }

            //创建上传所需要的两个对象
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024*1024*5);
            //解析器依赖于工厂
            ServletFileUpload upload = new ServletFileUpload(factory);


            //创建容器来接受解析的内容
            List<FileItem> items = new ArrayList<>();

            //将上传的文件信息放入容器中
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

            //遍历容器,处理解析的内容;封装两个方法，一个处理普通表单域，一个处理文件的表单域
            for(FileItem item : items){
                if(item.isFormField()){
                    handleFormField(item);
                }else{
                    handleUploadField(item);
                }
            }

        bookService.insertBook(b);
        }
    /**
     * 处理普通表单域（FormField）
     * @param item
     */
    private void handleFormField(FileItem item) {
        //得到表单域的name的值
        String fieldName = item.getFieldName();
        String value = "";
        try {
            //得到普通表单域中所输入的值
            value = item.getString("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//        将首字母大写
        String fName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        //打印到控制台
        System.out.println("fileName:"+fName+"--value:"+value);
    }
    /**
     * 处理文件的表单域
     * @param item
     */
    private void handleUploadField(FileItem item) {
        //得到上传文件的文件名
        String fileName = item.getName();
        if(fileName!=null && !"".equals(fileName)){
            //控制只能上传图片
            if(!item.getContentType().startsWith("image")){
                return;
            }
            //向控制台打印文件信息
//            System.out.println("fileName:"+fileName);
//            System.out.println("fileSize:"+item.getSize());

        }

        //上传文件存储路径
        String path = "D:/code/bookCover";
        //创建子目录
        File childDirectory = getChildDirectory(path);

        //写入服务器或者磁盘
        try {
            String name = UUID.randomUUID()+"_"+fileName;
            item.write(new File(childDirectory.toString(), name));
            System.out.println("数据库相对路径"+"\\"+time()+"\\"+name);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 按照时间创建子目录，防止一个目录中文件过多，不利于以后遍历查找
     * @param path
     * @return
     */
    private File getChildDirectory(String path) {

        String time = time();

        File file = new File(path,time);
        if(!file.exists()){
            file.mkdirs();
        }
        return file;
    }
    private String time(){
        Date currTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(currTime);
        return time;
    }



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
        if (pageInfo.getList().size() != 0){
            rm.setResult(pageInfo);
            return rm.successMsg();
        }else {
            return rm.errorMsg("图书未找到");
        }
    }

    /**
     * 根据标签搜索
     * @param   lab 标签字符串
     * @return  RestMsg(状态码、消息、图书集合)
     */
    @ApiOperation(value = "根据标签查找图书", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lab",value="标签id",required=true,dataType="String",paramType = "query")
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
     * @param
     * @return
     */
    @ApiOperation(value = "根据类型查找图书", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="booktype",value="图书类型",required=true,dataType="String",paramType = "query")
    })
    @GetMapping("/type")
    @ResponseBody
    public RestMsg<Object> findTypeBook(String booktype,@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn){
        RestMsg<Object> rm = new RestMsg<>();
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn,5);
        //startPage后紧跟的这个查询就是分页查询
        List<Book> list = bookService.findTypeBook(booktype);
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(list,5);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        if (pageInfo.getList().size() != 0){
            rm.setResult(pageInfo);
            return rm.successMsg();
        }else {
            return rm.errorMsg("没有该类型的图书");
        }
    }

}
