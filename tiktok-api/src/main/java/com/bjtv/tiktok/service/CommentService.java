package com.bjtv.tiktok.service;


import com.bjtv.tiktok.entity.Comment;
import com.bjtv.tiktok.entity.CommentRequest;

import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/24 下午5:52
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public interface CommentService {
    /**
     * 发表评论
     * @param commentRequest
     * @return
     */
    Boolean publicCommentService(CommentRequest commentRequest);

    /**
     * 获取评论内容
     * @param mediaId
     * @return
     */
    List<Comment> getCommentList(String mediaId);
}
