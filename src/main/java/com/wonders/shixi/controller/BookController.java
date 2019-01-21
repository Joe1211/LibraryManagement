package com.wonders.shixi.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wonders.shixi.pojo.*;
import com.wonders.shixi.pojo.Reader;
import com.wonders.shixi.service.IBookPeriodicalsService;
import com.wonders.shixi.service.ReaderService;
import com.wonders.shixi.service.impl.BookCommentServiceImpl;
import com.wonders.shixi.util.*;
import com.wonders.shixi.service.IBookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.*;
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

    @Autowired
    IBookPeriodicalsService bookPeriodicalsService;
        /**
     * 图书添加（基于form表单上传）
     * @param request
     * @param
     */
        @PostMapping("/add")
        @ResponseBody
        public RestMsg<Object> addBook(HttpServletRequest request, @RequestParam("bookCover") CommonsMultipartFile bookCover){
            RestMsg<Object> rm =new RestMsg<Object>();
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
            String bookNumber = request.getParameter("bookNumber");

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
//            System.out.println(b);

            /**
             * 商品图片表
             */
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

            //通过ISBN检查图书是否已存在
            Integer isbn = bookService.findISBN(bookPeriodicals);
            if (isbn != null){
                return rm.errorMsg("该书以存在！");
            }

            //添加图书信息，返回bookId
            int num=bookService.insertBook(b);
            int bookId = b.getBookId();
            //将图书标签添加到book_label_relation表中
            String bookLabelId = request.getParameter("bookLabel");
            BookLabelRelation br = new BookLabelRelation(bookId,Integer.parseInt(bookLabelId));
            bookService.bookLabelAdd(br);
            //将ISBN添加到book_periodicals表中
            BookPeriodicals bp = new BookPeriodicals();
            bp.setBookPeriodicals(bookPeriodicals);
            bp.setBookNumber(Integer.parseInt(bookNumber));
            bp.setBookId(bookId);
            bookPeriodicalsService.insertISBN(bp);
            if(num>0){
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
        bookPeriodicalsService.updateClick(bookId);

        request.getSession().setAttribute("msg",book);
        response.sendRedirect("../../bookdetail.jsp");
    }
    /**
     * 根据书id查询
     * 查询一本书的详细内容
     * @param
     * @return
     */
    @RequestMapping("/selectByIdMin")
    @ResponseBody
    public void selcetByIdMin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("bookId");
        int bookId=Integer.parseInt(id);
        Book book=bookService.selectByPrimaryKey(bookId);
        request.getSession().setAttribute("msg",book);
        response.sendRedirect("../../bookdetailmin.jsp");
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

    /**
     * 根据图书id查询该书的所有评论
     * @param bookId
     * @param pn
     * @return
     */
    @GetMapping("/comments")
    @ResponseBody
    public RestMsg<Object> selectCommentAll(String bookId, @RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn, HttpSession session){
        RestMsg<Object> rm = new RestMsg<>();
        Reader reader = (Reader) session.getAttribute("reader");
        int readerId = reader.getReaderId();
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn,5);
        //startPage后紧跟的这个查询就是分页查询
        List<BookCommentModel> list=bookCommentService.selectAllById(Integer.parseInt(bookId),readerId);
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(list,5);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        if(pageInfo.getList().size()!=0){
            rm.setResult(pageInfo);
            return rm.successMsg();
        }else {
            return rm.errorMsg("该书目前还没有评论！");
        }
    }

    /**
     * 图书借阅，根据图书id和读者id
     * @param bookId
     * @param readerId
     * @return
     */
    @GetMapping("/borrow")
    @ResponseBody
    public RestMsg<Object> borrowBook(String bookId,String readerId){
        RestMsg<Object> rm = new RestMsg<>();
//        System.out.println(bookId+"--->"+readerId);
        if(bookId==null){
            System.out.println("没登陆");
        }
        int id = Integer.parseInt(bookId);
        int rid = Integer.parseInt(readerId);
        int num = bookService.selectNum(id);
//        System.out.println("图书数量为："+num);
//        图书可借数量>=1为可借
        if(num>=1){
            //根据图书id获取书刊号，再将书刊信息表(book_periodicals)里可借图书数量减1
            int n = bookService.updataByNumber(id);
//            System.out.println("图书减1：");
            //将减借书记录存放到以借书目表中(book_reader_record)并返回id
            int brrId = bookService.addBookRecord(id,rid);
//            System.out.println("成功");
            //查询借图书的书名
            Book book = bookService.selectByPrimaryKey(id);
            String bookName = book.getBookName();
            //查询用户邮箱，用于发邮件
            Reader reader = readerService.getReaderById(rid);
            String email = reader.getReaderEmail();
            MailUtil.sendEmail(bookName,30,email);
            //借阅成功，借阅次数加1
            bookPeriodicalsService.updateBorrow(id);
            return rm.successMsg("借书成功，免费借书时间为一个月，请按时归还！");
        }else{
            return rm.errorMsg("该图书以借完");
        }
    }


    /**
     * Quartz
     * 定时任务，查询数据库借书时间，借书25天未还书则提醒,超出时间则提醒应缴纳费用
     * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次，类似于Servlet的inti()方法。被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行。
     * 被@PreDestroy修饰的方法会在服务器卸载Servlet的时候运行，并且只会被服务器调用一次，类似于Servlet的destroy()方法。被@PreDestroy修饰的方法会在destroy()方法之后运行，在Servlet被彻底卸载之前。
     */
    @PostConstruct
    public void timer() throws SchedulerException {
        //创建一个jobDetail的实例，将该实例与EmailJob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(EmailJob.class).withIdentity("cronJob").build();
        //创建一个Trigger触发器的实例，定义该job每天中午12执行
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("cronTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 * * ?"))
                .build();
        //创建Scheduler实例
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,cronTrigger);
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
        PageHelper.startPage(pn,10);
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

    /**
     * Quartz
     * 定时任务，每日推荐，0点更新，放入redis中
     * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次，类似于Servlet的inti()方法。被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行。
     * 被@PreDestroy修饰的方法会在服务器卸载Servlet的时候运行，并且只会被服务器调用一次，类似于Servlet的destroy()方法。被@PreDestroy修饰的方法会在destroy()方法之后运行，在Servlet被彻底卸载之前。
     */
    @PostConstruct
    public void timer1() throws SchedulerException {
        //创建一个jobDetail的实例，将该实例与EmailJob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(RecommendJob.class).withIdentity("cronJob1").build();
        //创建一个Trigger触发器的实例，定义该job每天0点执行
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("cronTrigger1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 10 11 * * ?"))
                .build();
        //创建Scheduler实例
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

    /**
     * 首页每日推荐图书
     * @return
     */
    @GetMapping("indexbook")
    @ResponseBody
    public RestMsg<Object> randomBook(){
        RestMsg<Object> rm = new RestMsg<>();
        Jedis jedis = RedisPool.getJedis();
        String k = "tushu";
        byte[] key = k.getBytes();
        byte[] b = jedis.get(key);
        List<Book> book = (List<Book>) SerialoizebleUtil.unserializeList(b);
        rm.setResult(book);
        return rm.successMsg();
    }

    /**
     * 图书借阅排行榜
     * @return
     */
    @GetMapping("borrowtop")
    @ResponseBody
    public RestMsg<Object> borrowTop(){
        return bookService.borrowTop();
    }
}
