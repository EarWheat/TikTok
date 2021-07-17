package com.tiktok.File.Demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tiktok.File.FileReadUtil;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020/12/30 上午11:22
 * @desc 文件辅助读取类（测试）
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class FileTest {
    public static void main(String[] args) {
        FileReadUtil fileReadUtil = new FileReadUtil("/Users/didi/IdeaProjects/Pangu/src/test/java/com/pangu/FileTest/Test");
        String newJson = JSONObject.toJSONString(fileReadUtil.fileReadLine(new dealRateProcess()));
        System.out.println(newJson);
    }
}
