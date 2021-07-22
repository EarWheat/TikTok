package com.bjtv.tiktok.Controller;

import com.bjtv.tiktok.entity.Media;
import com.bjtv.tiktok.entity.RestResult;
import com.bjtv.tiktok.service.MediaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.util.IOUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/25 下午4:30
 * @desc 设备控制类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@RestController
@RequestMapping("/media")
@Slf4j
public class MediaController {

    @Resource
    public MediaService mediaService;
    /**
     * 上传视频媒体
     * @param media
     * @return
     */
    @RequestMapping("/publicMedia")
    public RestResult publicMedia(@RequestBody @Validated Media media){
        return mediaService.publicMedia(media) ? RestResult.buildSuccess("public success") : RestResult.buildFail("public media error");
    }

    @RequestMapping("/getMediaList")
    public RestResult getMediaList(){
        return RestResult.buildSuccess(mediaService.getMediaList());
    }

    @RequestMapping("/getMediaRandom")
    public void getMediaRandom(HttpServletRequest request, HttpServletResponse response, @Param("id") int id) throws Exception{
        System.out.println("======创建流对象=======");
        String[] mediaList = new String[]{"https://mp4.vjshi.com/2020-03-13/575bf5e035a1c0b1c820b03f99e99ce6.mp4","https://mp4.vjshi.com/2019-12-10/5bcb45461c10a929ab0ddab665ba9ef5.mp4","https://mp4.vjshi.com/2019-12-09/5ef77dc687c0fb13e0fb6242b50074e1.mp4"};
        //创建连接对象
        URL url = new URL(mediaList[id]);
        URLConnection conn = url.openConnection();
        //设置超时
        conn.setConnectTimeout(20000);
        conn.setReadTimeout(5000);
        //发起连接
        conn.connect();
        //获取流
        InputStream inputStream = conn.getInputStream();

        //流转换
        IOUtils.copy(inputStream,response.getOutputStream());
        //设置返回类型
        response.addHeader("Content-Type", "audio/mpeg;charset=utf-8");

        response.flushBuffer();
    }

    @RequestMapping("getMediaById")
    public void getMediaById(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception{
        System.out.println("======创建流对象=======");
        Media media = mediaService.getMediaById(id);
        if(media.getResource() != null){
            //创建连接对象
            URL url = new URL(media.getResource());
            URLConnection conn = url.openConnection();
            //设置超时
            conn.setConnectTimeout(20000);
            conn.setReadTimeout(5000);
            //发起连接
            conn.connect();
            //获取流
            InputStream inputStream = conn.getInputStream();
            //流转换
            IOUtils.copy(inputStream,response.getOutputStream());
            //设置返回类型
            response.addHeader("Content-Type", "audio/mpeg;charset=utf-8");
            response.flushBuffer();
        }
    }

    /**
     * 视频直播
     * @param request
     * @param response
     */
    @RequestMapping("/live")
    public void live(HttpServletRequest request, HttpServletResponse response){
        try {
            URL url = new URL("rtmp://127.0.0.1:1935/live");
            URLConnection conn = url.openConnection();
            //设置超时
            conn.setConnectTimeout(20000);
            conn.setReadTimeout(5000);
            //发起连接
            conn.connect();
            //获取流
            InputStream inputStream = conn.getInputStream();
            //流转换
            IOUtils.copy(inputStream,response.getOutputStream());
            //设置返回类型
            response.addHeader("Content-Type", "audio/mpeg;charset=utf-8");
            response.flushBuffer();
        } catch (Exception e){
            log.error("live is not open");
        }
    }

}
