package com.bjtv.tiktok.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/24 下午5:44
 * @desc 评论请求
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Data
public class CommentRequest {
    @JSONField
    public String mediaId;

    @JSONField
    public String content;

    @JSONField
    public String userName;

}
