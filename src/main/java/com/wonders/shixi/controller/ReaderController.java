package com.wonders.shixi.controller;


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
     * @return ReaderModel
     */
    @ApiOperation(value = "通过id获取读者信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String", paramType = "query")
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
            @ApiImplicitParam(name = "id", value = "用户姓名", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/deleteReaderById.do", method = RequestMethod.GET)
    @ResponseBody
    public Massage deleteReaderById(int id) {
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
    @RequestMapping(value = "createReader", method = RequestMethod.POST)
    @ResponseBody
    public RestMsg<Reader> createReader(Reader reader) {
        System.out.println(reader);
        RestMsg<Reader> msg=new RestMsg<Reader>();
        return readerService.creatReader(reader)?msg.successMsg("注册成功,跳转到登录界面"):msg.successMsg("注册失败，请检查注册信息");
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
        if (readers != null) {
            log.info("成功新建读者记录！");
        } else {
            log.info("失败");
        }
        return readers;
    }

    /**
     * 登录
     *
     * @param phone 手机号
     * @param password 密码
     * @param role 角色
     * @param session session对象
     * @return RestMsg<Object>
     */
    @GetMapping("/login")
    @ResponseBody
    public RestMsg<Object> login(@RequestParam("readerPhone") String phone, @RequestParam("readerPassword") String password, int role, HttpSession session){
        RestMsg<Object> rm = null;
        switch (role) {
            case 0:
                //读者登录
                rm = readerService.readerLogin(phone, password);
                break;
            case 1:
                //管理员登录
                rm = readerService.adminLogin(phone, password);
                break;
        }
//        System.out.println(rm.getCode());
        if (rm.getCode() == 1) {
            session.setAttribute("reader", rm.getResult());
        }
        return rm;
    }

    /**
     * 修改密码
     *
     * @param phone 手机号
     * @param pwd 旧密码
     * @param newPwd 新密码
     * @param session session对象
     * @return RestMsg<Object>
     */
    @GetMapping("/upPassword")
    @ResponseBody
    public RestMsg<Object> updataPassword(@RequestParam("readerPhone") String phone, @RequestParam("readerPassword") String pwd, @RequestParam("readerPassword1") String newPwd, HttpSession session) {
        RestMsg<Object> rm = new RestMsg<>();
        Reader curUser = (Reader) session.getAttribute("reader");
        switch (curUser.getRole()) {
            case 2:
            case 0:
                rm = readerService.readerLogin(phone, pwd);
                break;
            case 1:
                rm = readerService.adminLogin(phone, pwd);
                break;
        }
//        原始密码为真
        if (rm.getCode() == 1) {
//           修改密码是否成功
            boolean b = readerService.updataByPassword(phone, newPwd);
            if (b) {
                return rm.successMsg("修改密码成功，请重新登陆！");
            } else {
                return rm.errorMsg("修改密码失败");
            }
        } else {
            return rm.errorMsg("原始密码错误");
        }
    }

    /**
     * 手机号是否已注册
     * @param phone 手机号
     * @return 是否已注册
     */
    @ApiOperation(value="isPhoneRegistered",httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "String", paramType = "query")})
    @GetMapping("isPhoneRegistered")
    @ResponseBody
    public boolean isPhoneRegistered(@RequestParam("readerPhone") String phone){
        return readerService.isPhoneRegistered(phone);
    }

    /**
     * 邮箱是否已注册
     * @param email 手机号
     * @return 是否已注册
     */
    @ApiOperation(value="isEmailRegistered",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping("isEmailRegistered")
    @ResponseBody
    public boolean isEmailRegistered(@RequestParam("readerEmail") String email){
        return readerService.isEmailRegistered(email);
    }

    /**
     * 管理员成为读者
     * @param reader 读者
     * @return RestMsg<Object>
     */
    @ApiOperation(value="adminToReader",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping("adminToReader")
    @ResponseBody
    public RestMsg<Object> adminToReader(Reader reader,HttpSession session){
        return readerService.adminToReader(reader,session);
    }

    /**
     * 注销登陆并跳回登陆页面
     *
     * @param session session对象
     * @param response 响应对象
     * @throws IOException IO异常
     */
    @GetMapping("/outReader")
    public void outReader(HttpSession session, HttpServletResponse response)
            throws IOException {
        //销毁session
        session.invalidate();
        response.sendRedirect("../../login.jsp");
    }
}
