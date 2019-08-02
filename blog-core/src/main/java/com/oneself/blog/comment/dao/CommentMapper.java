package com.oneself.blog.comment.dao;

import com.oneself.blog.comment.entity.pojo.Comment;
import java.util.List;

public interface CommentMapper {

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/8/2 10:27
     * @Param [comment]
     * @return void
     **/
    void insert(Comment comment);

    /**
     * @Author liangjiayao
     * @Description 
     * @Date 2019/8/2 10:27
     * @Param [commentId]
     * @return void
     **/
    void deleteById(Integer commentId);

    /**
     * @Author liangjiayao
     * @Description
     * @Date 2019/8/2 10:39
     * @Param [comment]
     * @return void
     **/
    void updateById(Comment comment);
}