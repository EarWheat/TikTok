package com.bjtv.tiktok.Dao;

import com.bjtv.tiktok.Entity.Comment.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/24 下午5:53
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Mapper
public interface CommentMapper {
    Boolean publicComment(Comment comment);
    List<Comment> getCommentList(String mediaId);
}
