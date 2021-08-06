package com.bjtv.tiktok.service;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/6 2:38 下午
 * @desc 语音处理类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Service
public class VoiceServiceImpl implements VoiceService{

    @Value("${project.root}")
    private String fileRoot;

    @Override
    public void saveVoice(HttpServletRequest request, MultipartFile voice) {
        String voiceName = voice.getOriginalFilename();
        String path = request.getServletContext().getContextPath().concat("/voice");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(fileRoot + path + "/" + voiceName));
            IOUtils.copy(voice.getInputStream(), fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String translateVoice(String filePath) {
        return null;
    }
}
