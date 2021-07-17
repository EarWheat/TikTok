package com.tiktok.File;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-10 19:26
 * @desc 文件读取类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class FileReadUtil {
    private static final Logger logger = LoggerFactory.getLogger(FileReadUtil.class);

    private String filePath;
    private File file;
    public FileReadUtil(String filePath){
        this.filePath = filePath;
        this.file = new File(filePath);
    }

    public Object fileReadByte(FileProcessBytes dataProcess){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] content = new byte[1024];
            while (fileInputStream.read(content) != -1){
                dataProcess.read(content);
            }
            return dataProcess.process();
        } catch (FileNotFoundException e){
            logger.error("File Not Found,path:{}",filePath);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Object fileReadLine(FileProcessLine dataProcess){
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = reader.readLine()) != null){
                dataProcess.readLine(line);
            }
            Object result = dataProcess.process();
            return result;
        } catch (FileNotFoundException e){
            logger.error("File Not Found,path:{}",filePath);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
