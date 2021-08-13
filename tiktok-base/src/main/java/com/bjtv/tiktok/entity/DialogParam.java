package com.bjtv.tiktok.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/4 上午11:23
 * @desc 对话机器人请求入参
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DialogParam {
    @JSONField
    private final String version = "2.0";

    /**
     * 机器人ID，service_id 与skill_ids不能同时缺失，至少一个有值。
     */
    @JSONField(name = "service_id")
    private String serviceId;

    /**
     * 技能ID列表。我们允许开发者指定调起哪些技能。这个列表是有序的——排在越前面的技能，优先级越高。技能优先级体现在response的排序上
     */
    @JSONField(name = "skill_ids")
    private List<String> skillIds;

    /**
     * 开发者需要在客户端生成的唯一id，用来定位请求，响应中会返回该字段。对话中每轮请求都需要一个log_id
     */
    @JSONField(name = "log_id")
    private String logId;

    /**
     * session保存机器人的历史会话信息，由机器人创建，客户端从上轮应答中取出并直接传递，不需要了解其内容。如果为空，则表示清空session（开发者判断用户意图已经切换且下一轮会话不需要继承上一轮会话中的词槽信息时可以把session置空，从而进行新一轮的会话）。
     * session字段内容较多，开发者可以通过传送session_id的方式节约传输流量。
     */
    @JSONField(name = "session_id")
    private String sessionId;

    @JSONField(name = "session")
    private String session;

    /**
     * 本轮请求体。
     */
    @JSONField(name = "request")
    @NonNull
    private Request request;

    /**
     * 机器人对话状态
     */
    @JSONField(name = "dialog_state")
    private String dialogState;

}
