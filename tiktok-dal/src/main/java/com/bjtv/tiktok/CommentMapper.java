package com.bjtv.tiktok;

import com.bjtv.tiktok.entity.Comment;
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
    /**
     * 发表评论
     * @param comment
     * @return
     */
    Boolean publicComment(Comment comment);

    /**
     * 获取评论列表
     * @param mediaId
     * @return
     */
    List<Comment> getCommentList(String mediaId);
}
