package com.wonders.shixi.service;

import com.wonders.shixi.util.RestMsg;

/**
 * @ClassName 图书标签控制器
 * @author 乔翰林
 * @date 2018.12.14
 */
public interface IBookLabelService {
    RestMsg<Object> findLabelAll();
}
