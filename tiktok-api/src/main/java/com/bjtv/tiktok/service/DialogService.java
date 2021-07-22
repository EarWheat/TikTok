package com.bjtv.tiktok.service;

import com.alibaba.fastjson.JSONObject;
import com.bjtv.tiktok.entity.DialogParam;
import com.bjtv.tiktok.entity.Request;

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
    JSONObject askQuestion(DialogParam dialogParam, String token);
    String chat(Request chatRequest, String token);
}
