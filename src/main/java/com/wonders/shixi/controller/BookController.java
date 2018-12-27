package com.wonders.shixi.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.pojo.BookBorrowModel;
import com.wonders.shixi.util.RestMsg;
import com.wonders.shixi.service.IBookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
     * 图书添加
     * @param request
     * @param response
     */
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
                return ;
//                System.out.println("上传图片类型错误");
            }
            //向控制台打印文件信息
//            System.out.println("fileName:"+fileName);
//            System.out.println("fileSize:"+item.getSize());
        }
        //上传文件存储路径
        String path = "D:/code/bookCover";
        //创建子目录
        File childDirectory = getChildDirectory(path);
        String s="";
        //写入服务器或者磁盘
        try {
            String name = UUID.randomUUID()+"_"+fileName;
            item.write(new File(childDirectory.toString(), name));
            s = "\\"+time()+"\\"+name;
            System.out.println("数据库相对路径"+s);
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

    /**
     * 图书借阅
     * @param bookId
     * @param readerId
     * @return
     */
    @GetMapping("/borrow")
    @ResponseBody
    public RestMsg<Object> borrowBook(String bookId,String readerId){
        RestMsg<Object> rm = new RestMsg<>();
        System.out.println(bookId+"--->"+readerId);
        if(bookId==null){
            System.out.println("没登陆");
        }
        int id = Integer.parseInt(bookId);
        int rid = Integer.parseInt(readerId);
        int num = bookService.selectNum(id);
        System.out.println("图书数量为："+num);
//        图书可借数量>=1为可借
        if(num>=1){
            //根据图书id获取书刊号，再将书刊信息表(book_periodicals)里可借图书数量减1
            int n = bookService.updataByNumber(id);
            System.out.println("图书减1：");
            //将减借书记录存放到以借书目表中(book_reader_record)
            int m = bookService.addBookRecord(id,rid);
            System.out.println("成功");
            if(m>=1){
                timer();
                return rm.successMsg("借书成功，免费借书时间为一个月，请按时归还！");
            }else{
                return rm.errorMsg("借书失败！");
            }
        }else{
            return rm.errorMsg("该图书以借完");
        }
    }


    public void timer() {
        //线程池中初始化只放了2个线程去执行任务
        ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(2);
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("发送消息");
            }
        }, 2, 2, TimeUnit.SECONDS);
        //initialDelay表示首次执行任务的延迟时间，period表示每次执行任务的间隔时间，TimeUnit.DAYS执行的时间间隔数值单位

    }

    /**
     * 图书归还
     * @param bookId
     * @param readerId
     * @return
     */
    @GetMapping("/repay")
    @ResponseBody
    public RestMsg<Object> repayBook(String bookId,String readerId){
        RestMsg<Object> rm = new RestMsg<>();
        int id = Integer.parseInt(bookId);
        int rid = Integer.parseInt(readerId);
        //图书归还，将可借图书数量加1
        boolean b = bookService.updateByAddNumber(id);
        //图书归还，根据读者id和图书id修改图书状态为已还（1）
        boolean b1 = bookService.updateByState(id,rid);
        if(b&&b1){
            return rm.successMsg("还书成功！");
        }
        return rm.errorMsg("还书失败");
    }

    /**
     * 根据用户id查询以借图书
     * @param bookId
     * @return
     */
    @GetMapping("/record/borrow")
    @ResponseBody
    public RestMsg<Object> selectByRecord(String bookId){
        return bookService.selectByRecord(Integer.parseInt(bookId));
    }

    /**
     * 根据用户id查询以还图书
     * @param bookId
     * @return
     */
    @GetMapping("/record/repay")
    @ResponseBody
    public RestMsg<Object> selectByRepay(String bookId){
        return bookService.selectByRepay(Integer.parseInt(bookId));
    }

    /**
     * 查询所有待还图书
     * @return
     */
    @GetMapping("/borrowall")
    @ResponseBody
    public RestMsg<Object> selectByborrowAll(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn){
        RestMsg<Object> rm = new RestMsg<>();
        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn,5);
        //startPage后紧跟的这个查询就是分页查询
        List<BookBorrowModel> list = bookService.selectByBorrowAll();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(list,5);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        if (pageInfo.getList().size() != 0){
            rm.setResult(pageInfo);
            return rm.successMsg();
        }else {
            return rm.errorMsg("没有待还的图书");
        }
    }

}
