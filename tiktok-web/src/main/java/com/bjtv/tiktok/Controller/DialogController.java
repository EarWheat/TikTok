package com.bjtv.tiktok.Controller;

import com.alibaba.fastjson.JSONObject;
import com.bjtv.tiktok.entity.DialogParam;
import com.bjtv.tiktok.entity.DialogRequest;
import com.bjtv.tiktok.entity.Request;
import com.bjtv.tiktok.entity.RestResult;
import com.bjtv.tiktok.Enums.AuthEnum;
import com.bjtv.tiktok.service.DialogService;
import com.bjtv.tiktok.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/4 上午11:17
 * @desc 对话机器人
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@RequestMapping("/dialog")
@RestController
public class DialogController {

    private static final Logger logger = LoggerFactory.getLogger(DialogController.class);

    @Resource
    private AuthService authService;

    @Resource
    private DialogService dialogService;

    /**
     * 带详细参数，问谁什么问题
     * @param dialogParam
     * @return
     */
    @RequestMapping("/ask")
    public RestResult<JSONObject> askQuestion(@RequestBody DialogParam dialogParam){
        JSONObject token = authService.getAuthToken(AuthEnum.BAIDU);
        String accessToken = token.getString("access_token");
        JSONObject answer = dialogService.askQuestion(dialogParam, accessToken);
        return RestResult.buildSuccess(answer);
    }

    /**
     * 聊天问答
     * @param dialogRequest
     * @return
     */
    @RequestMapping("/chat")
    public RestResult<String> chat(HttpServletRequest httpServletRequest, @RequestBody @Validated DialogRequest dialogRequest){
        Request request = dialogRequest.getRequest();
        String answer = dialogService.chat(request, dialogRequest.getToken());
        return RestResult.buildSuccess(answer);
    }
}
