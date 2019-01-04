package com.wonders.shixi.service;

import com.wonders.shixi.pojo.BookType;
import com.wonders.shixi.pojo.TypeOne;

import java.util.List;

/**
 * @Auther: 乔翰林
 * @Date: 2018/12/18 09:07
 * @Description: 中图法一级分类
 */
public interface ITypeOneService {
    /**
     * 根据部类id查找所有中图法一级分类
     * @return
     */
    List<TypeOne> selectByBId(int bid);
}
