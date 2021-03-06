package com.tiktok.Service.DialogService;

import com.alibaba.fastjson.JSONObject;
import com.tiktok.Entity.Dialog.DialogParam;
import com.tiktok.Entity.Dialog.Request;

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
