package com.wonders.shixi.controller;

import com.wonders.shixi.pojo.Library;
import com.wonders.shixi.service.impl.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    LibraryServiceImpl libraryService;

    @RequestMapping("select")
    @ResponseBody
    public Library select(int libraryId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Library library=libraryService.selectById(libraryId);
        return library;
    }

}
