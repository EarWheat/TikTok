package com.bjtv.tiktok.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/4 下午4:12
 * @desc 聊天请求
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DialogRequest {
    @JSONField(name = "query")
    @NotNull(message = "tell me you question")
    private String query;

    @JSONField(name = "user_id")
    private String userId;

    @JSONField(name = "token")
    private String token;

}
