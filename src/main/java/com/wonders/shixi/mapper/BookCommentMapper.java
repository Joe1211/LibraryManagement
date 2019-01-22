package com.wonders.shixi.mapper;

import com.wonders.shixi.pojo.BookComment;
import com.wonders.shixi.pojo.BookCommentLike;
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

    /**
     * 根据图书id查询评论和评论点赞数量
     * @param id
     * @param readerId
     * @return
     */
    Integer findIsComment(@Param("id")int id,@Param("readerId") int readerId);

    /**
     * 给评论点赞
     * @param bcl
     * @return
     */
    int addLike(BookCommentLike bcl);

    /**
     * 取消点赞
     * @param bookCommentId
     * @param readerId
     * @return
     */
    int deleteLike(@Param("bookCommentId")int bookCommentId,@Param("readerId") int readerId);

    List<BookCommentModel> likeSort(Integer bookId);
}