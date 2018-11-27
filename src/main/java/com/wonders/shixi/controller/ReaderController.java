package com.wonders.shixi.controller;

import com.wonders.shixi.controller.vo.Massage;
import com.wonders.shixi.controller.vo.ReaderModel;
import com.wonders.shixi.service.ReaderService;
import com.wonders.shixi.util.MassageUtil;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "读者管理")
@Controller
public class ReaderController {
    @Autowired
    ReaderService readerService;

    private static final Logger log = LogManager.getLogger(ReaderController.class.getName());

    /**
     * 通过id获取读者信息
     * @param id 读者id
     * @return
     */
    @RequestMapping(value = "/api/readermanagement/getReaderById.do",method = RequestMethod.GET)
    @ResponseBody
    public ReaderModel getReaderById(int id){
        return new ReaderModel(readerService.getReaderById(id));
    }

    /**
     * 通过id删除读者（改变激活状态）
     * @param id 读者id
     * @return Massage json
     */

    @RequestMapping(value = "/api/readermanagement/deleteReaderById.do",method = RequestMethod.GET)
    @ResponseBody
    public Massage deleteReaderById(int id){

        return MassageUtil.boolMassage(readerService.deleteReaderById(id));
    }

    /**
     *通过json转换 Reader对象改更新读者信息
     * @param reader json转换的Reader对象
     * @return Massage massage转换的json
     */
    @RequestMapping(value = "/api/readermanagement/updataReader.do",method = RequestMethod.POST)
    public @ResponseBody Massage updataReader(@RequestBody Reader reader ){
        return MassageUtil.boolMassage(readerService.updateReader(reader));

    }















}
