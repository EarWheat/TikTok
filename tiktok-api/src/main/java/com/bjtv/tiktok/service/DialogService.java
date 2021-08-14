package com.bjtv.tiktok.service;

import com.alibaba.fastjson.JSONObject;
import com.bjtv.tiktok.entity.DialogParam;
import com.bjtv.tiktok.entity.DialogRequest;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/4 上午11:19
 * @desc 对话类Service
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public interface DialogService {
    /**
     * 提问问答
     * @param dialogParam
     * @param token
     * @return
     */
    JSONObject askQuestion(DialogParam dialogParam, String token);

    /**
     * 聊天
     * @param dialogRequest
     * @return
     */
    String chat(DialogRequest dialogRequest);

    /**
     * 语音聊天
     * @param dialogRequest
     * @return
     */
    String voiceChat(DialogRequest dialogRequest);
}
