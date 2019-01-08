package com.wonders.shixi.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.pojo.BookBorrowModel;
import com.wonders.shixi.pojo.Model;
import com.wonders.shixi.pojo.Reader;
import com.wonders.shixi.service.ReaderService;
import com.wonders.shixi.service.impl.BookCommentServiceImpl;
import com.wonders.shixi.util.Base64Util;
import com.wonders.shixi.util.IC;
import com.wonders.shixi.util.MailUtil;
import com.wonders.shixi.util.RestMsg;
import com.wonders.shixi.service.IBookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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

    @Autowired
    BookCommentServiceImpl bookCommentService;

    @Autowired
    ReaderService readerService;
//    /**
//     * 图书添加（基于文件的ajax上传）
//     * @param request
//     * @param response
//     */
//    @PostMapping("/add")
//    @ResponseBody
//    public void addBook(HttpServletRequest request, HttpServletResponse response){
//        //检查请求是否是multipart/form-data类型
//            if(!ServletFileUpload.isMultipartContent(request)){
//                //不是multipart/form-data类型
//                throw new RuntimeException("表单的enctype属性不是multipart/form-data类型！！");
//            }
//
//            //创建上传所需要的两个对象
//            DiskFileItemFactory factory = new DiskFileItemFactory();
//            factory.setSizeThreshold(1024*1024*5);
//            //解析器依赖于工厂
//            ServletFileUpload upload = new ServletFileUpload(factory);
//
//
//            //创建容器来接受解析的内容
//            List<FileItem> items = new ArrayList<>();
//
//            //将上传的文件信息放入容器中
//            try {
//                items = upload.parseRequest(request);
//            } catch (FileUploadException e) {
//                e.printStackTrace();
//            }
//
//            //遍历容器,处理解析的内容;封装两个方法，一个处理普通表单域，一个处理文件的表单域
//            for(FileItem item : items){
//                if(item.isFormField()){
//                  handleFormField(item);
//                }else{
//                    handleUploadField(item);
//                }
//            }
//        }
//    /**
//     * 处理普通表单域（FormField）
//     * @param item
//     */
//    private void handleFormField(FileItem item) {
//        //得到表单域的name的值
//        String fieldName = item.getFieldName();
//        String value = "";
//        try {
//            //得到普通表单域中所输入的值
//            value = item.getString("utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
////        将首字母大写
//        String fName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
//        //打印到控制台
//        System.out.println("fileName:"+fName+"--value:"+value);
//
//    }
//    /**
//     * 处理文件的表单域
//     * @param item
//     */
//    private void handleUploadField(FileItem item) {
//        //得到上传文件的文件名
//        String fileName = item.getName();
//        if(fileName!=null && !"".equals(fileName)){
//            //控制只能上传图片
//            if(!item.getContentType().startsWith("image")){
//                return ;
////                System.out.println("上传图片类型错误");
//            }
//            //向控制台打印文件信息
////            System.out.println("fileName:"+fileName);
////            System.out.println("fileSize:"+item.getSize());
//        }
//        //上传文件存储路径
//        String path = "D:/code/bookCover";
//        //创建子目录
//        File childDirectory = getChildDirectory(path);
//        String s="";
//        //写入服务器或者磁盘
//        try {
//            String name = UUID.randomUUID()+"_"+fileName;
//            item.write(new File(childDirectory.toString(), name));
//            s = "\\"+time()+"\\"+name;
//            System.out.println("数据库相对路径"+s);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
        /**
     * 图书添加（基于form表单上传）
     * @param request
     * @param
     */
        @PostMapping("/add")
        @ResponseBody
        public RestMsg<Object> addBook(HttpServletRequest request, @RequestParam("bookCover") CommonsMultipartFile bookCover){
            //获取页面参数
            String bookName = request.getParameter("bookName");
            String bookPeriodicals = request.getParameter("bookPeriodicals");
            String bookCallnum = request.getParameter("bookCallnum");
            String bookWriter = request.getParameter("bookWriter");
            String bookPress = request.getParameter("bookPress");
            String bookInfo = request.getParameter("bookInfo");
            String typeTwoValue = request.getParameter("typeTwoValue");
            String libraryId = request.getParameter("libraryId");
            String bookState = request.getParameter("bookState");

            //将值传入book
            Book b = new Book();
            b.setBookName(bookName);
            b.setBookPeriodicals(bookPeriodicals);
            b.setBookCallnum(bookCallnum);
            b.setBookWriter(bookWriter);
            b.setBookPress(bookPress);
            b.setBookInfo(bookInfo);
            b.setTypeTwoValue(typeTwoValue);
            b.setLibraryId(Integer.parseInt(libraryId));
            b.setBookState(bookState);

            /**
             * 商品图片表
             */
            //获取表单中的附件部分
//            Part part = null;
//            try {
//
//                part = request.getPart("bookCover");
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ServletException e) {
//                e.printStackTrace();
//            }
            //获取提交的文件名称
//            String iname =UUID.randomUUID()+part.getSubmittedFileName();
            //目录
//            String base = "D:/code/bookCover";
            //根据当前日期创建目录
//            File dir = new File(time()+"\\"+iname);
            //当目录不存在时，创建
//            if(!dir.exists()){
//                dir.mkdirs();
//            }
            //写入到服务器中
//            part.write(dir+File.separator+iname);

//            b.setBookCover(dir.toString());
//            //创建img对象
//            Img i = new Img();
//            //model.getDate是商品表的gid
//            i.setGid((int)model.getData());
//            i.setImg((int)model.getData()+File.separator+iname);
//
//            //将数据传送到service中
//            model = service.insertimg(i);

//            if(model.getCode() == 1){
//                //发布成功
//                request.setAttribute("msg", model.getMessage());
//                return "redirect:goods?method=findGoodsAll";
//            }else{
//                //注册失败，请求转发
//                return "main.jsp";
//            }

            if(!bookCover.isEmpty()){
                //封面不为空
//                String iname=UUID.randomUUID()+bookCover.getOriginalFilename();
//                File file=new File(IC.BOOK_COVER_BASE+File.separator+time()+File.separator+iname);
//                if(!file.getParentFile().exists()){
//                    file.getParentFile().mkdirs();
//                }
                try {
                    //传输封面到本地
//                    FileUtils.copyInputStreamToFile(bookCover.getInputStream(),file);
//                    b.setBookCover(file.getPath());
                    //转化为base64编码
                    String base64Str= Base64Util.encode(bookCover.getInputStream());
                    b.setBookCover(base64Str);
                } catch (IOException e) {
                    Logger.getLogger("获取文件流失败");
                }finally {
                    try {
                        if(bookCover.getInputStream()!=null){
                            bookCover.getInputStream().close();
                        }
                    } catch (IOException e) {
                        Logger.getLogger("文件流关闭失败");
                    }
                }
            }
            int insertNum=bookService.insertBook(b);
            RestMsg<Object> rm =new RestMsg<Object>();
            if(insertNum>0){
                rm.successMsg("图书上传成功,可以继续上传");
            }else{
                rm.errorMsg("图书上传失败,请检查图书信息");
            }
//            response.setContentType("application/json");
//            System.out.println(JSON.toJSONString(rm));
            return rm;
        }

    /**
     * 获取图书封面
     * @param id
     * @param response
     */
    @RequestMapping("findBookCover")
        public void findBookCover(int id,HttpServletRequest request,HttpServletResponse response){
            String data=bookService.findBookCoverById(id);
        byte[] bytes=null;
        try {
            bytes = Base64.getDecoder().decode(data);
            if(bytes==null){throw new NullPointerException();}
        } catch (Exception e) {
            //没有图片或解析出错，则返回默认图片
            String path=this.getClass().getClassLoader().getResource(".."+File.separator+".."+File.separator+IC.NO_BOOK_COVER).getPath();
            File file=new File(path);
            try {
                InputStream in=new BufferedInputStream(new FileInputStream(file));
                bytes=new byte[in.available()];
                in.read(bytes);
                in.close();
            } catch (IOException e1) {
                Logger.getLogger("读取默认封面图片失败，可能缺少默认文件");
            }
        }
        try {
                OutputStream out=response.getOutputStream();
                out.write(bytes);
                out.flush();
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
     * 根据书id查询
     * 查询一本书的详细内容
     * @param
     * @return
     */
    @RequestMapping("/selectById")
    @ResponseBody
    public void selcetById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("bookId");
        int bookId=Integer.parseInt(id);
        Book book=bookService.selectByPrimaryKey(bookId);
        request.getSession().setAttribute("msg",book);
        response.sendRedirect("../../bookdetail.jsp");
    }

    /**
     * 根据书id查询
     * 查询一本书的详细内容并可评论
     * @param
     * @return
     */
    @RequestMapping("/selectComment")
    @ResponseBody
    public void selcetByComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("bookId");
        int bookId=Integer.parseInt(id);
        Book book=bookService.selectByPrimaryKey(bookId);
        request.getSession().setAttribute("msg",book);
        response.sendRedirect("../../bookComment.jsp");
    }

    @GetMapping("/comments")
    @ResponseBody
    public RestMsg<Object> selectCommentAll(String bookId,@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn){
        RestMsg<Object> rm = new RestMsg<>();
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn,5);
        //startPage后紧跟的这个查询就是分页查询
        List<Model> list=bookCommentService.selectAllById(Integer.parseInt(bookId));
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(list,5);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        rm.setResult(pageInfo);
        return rm.successMsg();

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
                //查询借图书的书名
                Book book = bookService.selectByPrimaryKey(id);
                String bookName = book.getBookName();
                //查询用户邮箱，用于发邮件
                Reader reader = readerService.getReaderById(rid);
                String email = reader.getReaderEmail();
//              调用定时任务
                timer(bookName,email);
                return rm.successMsg("借书成功，免费借书时间为一个月，请按时归还！");
            }else{
                return rm.errorMsg("借书失败！");
            }
        }else{
            return rm.errorMsg("该图书以借完");
        }
    }


    public void timer(String bookName,String emailAddress) {
        //线程池中初始化只放了2个线程去执行任务
        ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(2);
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("发送消息");
                MailUtil.sendEmail(bookName,30,emailAddress);
            }
        }, 1, 10000, TimeUnit.SECONDS);
        //initialDelay表示首次执行任务的延迟时间，period表示每次执行任务的间隔时间，TimeUnit.DAYS执行的时间间隔数值单位
    }

    /**
     * 图书归还(借阅记录表id)
     * @param brrId
     * @return
     */
    @GetMapping("/repay")
    @ResponseBody
    public RestMsg<Object> repayBook(String brrId){
        RestMsg<Object> rm = new RestMsg<>();
        int brrid = Integer.parseInt(brrId);
        //根据借阅记录表id查询对应的bookId
        int bid = bookService.selectByBid(brrid);
        //图书归还，将可借图书数量加1
        boolean b = bookService.updateByAddNumber(bid);
        //图书归还，根据借阅记录表id修改图书状态（0未还，1已还）
        boolean b1 = bookService.updateByState(brrid);
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
