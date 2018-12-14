package com.wonders.shixi.service.impl;



import com.wonders.shixi.mapper.BookMapper;
import com.wonders.shixi.pojo.Book;
import com.wonders.shixi.util.RestMsg;
import com.wonders.shixi.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @ClassName 图书查询控制器
 * @author 乔翰林
 * @date 2018.12.14
 */
@Service("bookService")
public class BookServiceImpl implements IBookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public Book selectByPrimaryKey(int id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    /**
     * 图书入库
     * @param book
     * @return
     */
    @Override
    public RestMsg<Object> addBook(Book book) {
        RestMsg<Object> rm = new RestMsg<>();
        int i = bookMapper.insert(book);
        if (i != 0){
            rm.setResult(book);
            rm.successMsg("添加图书成功");
            return rm;
        }else{
            rm.errorMsg("添加图书失败");
            return rm;
        }
    }

    /**
     * 图书出库
     * @param id
     * @return
     */
    @Override
    public RestMsg<Object> deleteBook(int id) {
        RestMsg<Object> rm = new RestMsg<>();
        int i = bookMapper.deleteByPrimaryKey(id);
        if(i != 0){
            return rm.successMsg("图书删除成功");
        }else{
            return rm.errorMsg("图书删除失败");
        }
    }

    /**
     * 根据图书名模糊查询图书
     * @param s
     * @return
     */
    @Override
    public List<Book> findDimBook(String s) {
       return bookMapper.selectDimBook(s);
    }

    /**
     * 根据标签查询图书
     * @param arr
     * @return
     */
    @Override
    public RestMsg<Object> findLabelBook(String[] arr) {
        RestMsg<Object> rm = new RestMsg<>();
        List<Book> list = bookMapper.selectLabelBook(arr);
        if (list.size() != 0){
            rm.setResult(list);
            return rm.successMsg();
        }else {
            return rm.errorMsg("图书未找到");
        }
    }

    @Override
    public List<Book> findTypeBook(String... arr) {
        return null;
    }


}
