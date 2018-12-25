package com.wonders.shixi.controller;

import com.sun.deploy.net.HttpResponse;
import com.wonders.shixi.controller.vo.Massage;
import com.wonders.shixi.controller.vo.ReaderCondition;
import com.wonders.shixi.controller.vo.ReaderModel;
import com.wonders.shixi.pojo.Reader;
import com.wonders.shixi.service.ReaderService;
import com.wonders.shixi.util.MassageUtil;
import com.wonders.shixi.util.RestMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 读者管理前端控制器
 *
 * @author 吴建良
 */
@Api(value = "api/readermanagement")
@RequestMapping(value = "api/readermanagement")
@Controller
public class ReaderController {
    @Autowired
    ReaderService readerService;

    private static final Logger log = LogManager.getLogger(ReaderController.class.getName());

    /**
     * 通过id获取读者信息
     *
     * @param id 读者id
     * @return
     */
    @ApiOperation(value = "通过id获取读者信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="用户id",required=true,dataType="String",paramType = "query")
    })
    @RequestMapping(value = "/getReaderById.do", method = RequestMethod.GET)
    @ResponseBody
    public ReaderModel getReaderById(int id) {
        return new ReaderModel(readerService.getReaderById(id));
    }

    /**
     * 通过id删除读者（改变激活状态）
     *
     * @param id 读者id
     * @return Massage json
     */
    @ApiOperation(value = "通过id删除读者（改变激活状态）", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="用户姓名",required=true,dataType="String",paramType = "query")
    })
    @RequestMapping(value = "/deleteReaderById.do", method = RequestMethod.GET)
    @ResponseBody
    public Massage deleteReaderById( int id) {
        return MassageUtil.boolMassage(readerService.deleteReaderById(id));
    }

    /**
     * 通过json转换 Reader对象改更新读者信息
     *
     * @param reader json转换的Reader对象
     * @return Massage massage转换的json
     */
    @ApiOperation(value = "通过读者json更新读者信息", httpMethod = "POST")
    @RequestMapping(value = "/updataReader.do", method = RequestMethod.POST)
    public @ResponseBody
    Massage updataReader(@RequestBody Reader reader) {
        reader.setReaderPassword(null);
        return MassageUtil.boolMassage(readerService.updateReader(reader));

    }

    /**
     * 通过管理员账号密码获取读者信息
     *
     * @return List<Reader>     返回的是List<Reader>的json
     */
    @ApiOperation(value = "通过管理员账号密码获取读者信息", httpMethod = "POST")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "a"), @ApiImplicitParam(paramType = "body", name = "b")})
    @RequestMapping(value = "/getReadersList.do", method = RequestMethod.POST)
    public @ResponseBody
    List<Reader> getReadersList() {
        List<Reader> list = new ArrayList<>();
        Reader reader1 = new Reader();
        reader1.setReaderName("wjl");
        list.add(reader1);
        return list;
    }

    /**
     * 建立读者对象
     *
     * @param reader json转成的读者对象
     * @return Massage  操作返回的结果
     */
    @ApiOperation(value = "新建读者对象", httpMethod = "POST")
    @RequestMapping(value = "/creatReader.do", method = RequestMethod.POST)
    public @ResponseBody
    Massage creatReader(@RequestBody Reader reader) {

        return MassageUtil.boolMassage(readerService.creatReader(reader));
    }


    @ApiOperation(value = "按条件查询读者", httpMethod = "POST")
    @RequestMapping(value = "/getReaderList.do", method = RequestMethod.POST)
    public @ResponseBody
    List<Reader> getReaderList(@RequestBody ReaderCondition readerCondition) {
        List<Reader> readers = null;
        if (readerCondition != null) {
            readers = readerService.selectReadersByCondition(readerCondition);
        }
        //日志写入
        if(readers!=null){
            log.info("成功新建读者记录！");
        }else {
            log.info("失败");
        }
        return readers;
    }

    /**
     * 读者登陆
     * @param request
     * @return
     */
    @GetMapping("/login")
    @ResponseBody
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String phone = request.getParameter("readerPhone");
        String password = request.getParameter("readerPassword");
        RestMsg<Object> rm = readerService.login(phone,password);
        request.getSession().setAttribute("reader",rm.getResult());
        System.out.println(rm.getCode());
        if(rm.getCode()==1){
            response.sendRedirect("../../search.jsp");
        }
    }

    /**
     * 修改密码
     * @param request
     * @return
     */
    @GetMapping("/upPassword")
    @ResponseBody
    public RestMsg<Object> updataPassword(HttpServletRequest request){
        RestMsg<Object> rm = new RestMsg<>();
        String phone = request.getParameter("readerPhone");
        String pwd = request.getParameter("readerPassword");
        String newPwd = request.getParameter("readerPassword1");
        rm = readerService.login(phone,pwd);
//        原始密码为真
        if(rm.getCode()==1){
//           修改密码是否成功
           boolean b = readerService.updataByPassword(phone,newPwd);
           if(b){
               return rm.successMsg("修改密码成功，请重新登陆！");
           }else {
               return rm.errorMsg("修改密码失败");
           }
        }else {
            return rm.errorMsg("原始密码错误");
        }
    }

    @GetMapping("/outReader")
    public void outReader(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //防止创建Session
        HttpSession session = request.getSession(false);
        session.removeAttribute("reader");
        response.sendRedirect("../../login.jsp");
    }

}
