package com.wonders.shixi.service.impl;

import com.wonders.shixi.mapper.ReaderMapper;
import com.wonders.shixi.pojo.Reader;
import com.wonders.shixi.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    ReaderMapper readerMapper;
    @Override
    public Reader getReaderById(int id) {

        return readerMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteReaderById(int id) {
        return false;
    }

    @Override
    public boolean updateReader(Reader reader) {
        return false;
    }

    @Override
    public boolean updatePassword(String management, String managementPassword, String readerPassword) {
        return false;
    }
}
