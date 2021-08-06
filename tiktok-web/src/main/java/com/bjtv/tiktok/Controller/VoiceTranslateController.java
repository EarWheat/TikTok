package com.bjtv.tiktok.Controller;

import com.alibaba.fastjson.JSONObject;
import com.bjtv.tiktok.entity.RestResult;
import com.bjtv.tiktok.enums.VoiceResultEnum;
import com.bjtv.tiktok.service.VoiceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/6 2:25 下午
 * @desc 语音翻译转文字
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@RequestMapping("/voice")
@RestController
public class VoiceTranslateController {

    @Resource
    private VoiceService voiceService;

    @RequestMapping("/translate")
    @ResponseBody
    public RestResult voiceTranslate(HttpServletRequest request, HttpServletResponse response, @RequestParam("voice") MultipartFile voice){
        try {
            if(Objects.isNull(voice)){
                return RestResult.buildFail(VoiceResultEnum.VOICE_FILE_EMPTY.getMessage());
            }
            voiceService.saveVoice(request, voice);
        } catch (Exception e){

        }
        return RestResult.buildFail();
    }
}
