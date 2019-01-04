package com.wonders.shixi.controller;

import com.wonders.shixi.pojo.Library;
import com.wonders.shixi.service.impl.LibraryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Api("/api/library")
@Controller
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    LibraryServiceImpl libraryService;

    @RequestMapping("select")
    @ResponseBody
    @ApiOperation(value="通过id查询图书馆",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="libraryId",value="图书馆id",required=true,dataType="String",paramType = "query")
    })
    public Library select(int libraryId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Library library=libraryService.selectById(libraryId);
        return library;
    }

    @RequestMapping("selectAll")
    @ResponseBody
    @ApiOperation(value="查询所有图书馆信息",httpMethod = "GET")
    public List<Library> selectAll(){
        List<Library> libraryList = libraryService.selectAll();
        return libraryList;
    }

}
