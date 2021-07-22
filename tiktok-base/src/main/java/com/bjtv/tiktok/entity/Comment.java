package com.bjtv.tiktok.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/24 下午5:54
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = -8817472561955051311L;

    @JSONField
    public String userId;
    @JSONField
    public String commentId;
    @JSONField
    public String mediaId;
    @JSONField
    public String content;
    @JSONField
    public String avatar;
    @JSONField
    private String createTime;
    @JSONField
    private String updateTime;
}
