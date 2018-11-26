package com.wonders.shixi.service;

import com.wonders.shixi.pojo.Reader;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;


public interface ReaderService {
    /**
     * 通过id获取读者信息
     *
     * @param id
     * @return
     */
    Reader getReaderById(int id);

    /**
     * 通过id删除读者信息（改变信息）
     *
     * @param id
     * @return
     */
    boolean deleteReaderById(int id);

    /**
     * 通过Reader对象更新该对象信息
     * @param reader
     * @return
     */
    boolean updateReader(Reader reader);


    boolean updatePasswordByAdmin(String adminId ,String adminPassword,String readerPassword);

}
