package com.bjtv.tiktok.Service.CommentService;


import com.bjtv.tiktok.Entity.Comment.Comment;
import com.bjtv.tiktok.Entity.Comment.CommentRequest;

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
    Boolean publicCommentService(CommentRequest commentRequest);
    List<Comment> getCommentList(String mediaId);
}
