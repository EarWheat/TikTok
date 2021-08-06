package com.bjtv.tiktok.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/6 2:36 下午
 * @desc 语音接口
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public interface VoiceService {
    /**
     * 保存音频文件
     * @param request
     * @param voice
     */
    public void saveVoice(HttpServletRequest request, MultipartFile voice);

    /**
     * 音频文件翻译
     * @param filePath
     * @return
     */
    public String translateVoice(String filePath);
}
