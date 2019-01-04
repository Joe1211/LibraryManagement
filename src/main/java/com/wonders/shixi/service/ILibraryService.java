package com.wonders.shixi.service;

import com.wonders.shixi.pojo.Library;

import java.util.List;


public interface ILibraryService {

    Library selectById( int LibraryId);
    List<Library> selectAll();
}
