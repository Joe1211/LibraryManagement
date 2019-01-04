package com.wonders.shixi.service.impl;

import com.wonders.shixi.mapper.LibraryMapper;
import com.wonders.shixi.pojo.Library;
import com.wonders.shixi.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("libraryService")
public class LibraryServiceImpl implements ILibraryService {

    @Autowired
    LibraryMapper libraryMapper;

    @Override
    public List<Library> selectAll() {
        List<Library> list=libraryMapper.selectAll();
        if(list==null||list.size()<=0){
            return null;
        }
        return list;
    }

    @Override
    public Library selectById(int libraryId) {
        return libraryMapper.selectByPrimaryKey(libraryId);
    }
}
