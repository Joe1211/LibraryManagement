package com.wonders.shixi.mapper;

import com.wonders.shixi.pojo.BookComment;
import com.wonders.shixi.pojo.BookCommentModel;
import com.wonders.shixi.pojo.Model;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookCommentMapper {
    /**
     * 根据评论id删除评论
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    int insert(BookComment record);

    int insertSelective(BookComment record);

    BookComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookComment record);

    int updateByPrimaryKey(BookComment record);

    /**
     * 根据bookId查询
     * @param bookId
     * @return
     */
    List<BookComment> selectByBookId(Integer bookId);

    List<BookCommentModel> selectAllByBookId(Integer bookId);

    List<BookComment> selectCommentAll();

    Integer findIsComment(@Param("id")int id,@Param("readerId") int readerId);
}