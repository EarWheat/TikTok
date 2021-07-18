package com.bjtv.tiktok.Entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/18 上午11:46
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Data
public class Media implements Serializable {
    private static final long serialVersionUID = -5278733077963686478L;

    @JSONField(name = "use_id")
    public String userId;
    @JSONField(name = "media_id")
    public String mediaId;
    @JSONField(name = "resource")
    public String resource;
    @JSONField(name = "create_time")
    private String createTime;
    @JSONField(name = "update_time")
    private String updateTime;
}
