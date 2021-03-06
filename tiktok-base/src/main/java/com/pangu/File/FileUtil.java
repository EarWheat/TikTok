package com.pangu.File;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


/*
 * @author:liuzhaolu
 * @createTime: 2020-03-01 12:44
 * @desc:
 */
public class FileUtil {

    static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static void main(String[] args){
        String filePath = "/Users/didi/Documents/br_war_0319.xlsx";
        JSONObject object = file2Json(filePath);
        System.out.println(object.toJSONString());
    }

    public static JSONObject file2Json(String filePath) {
        JSONObject result = new JSONObject();
        try {
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            // 获取sheet数
            int numberOfSheets = workbook.getNumberOfSheets();
            for(int i = 0; i < numberOfSheets;i ++){
                Sheet sheetAt = workbook.getSheetAt(i);
                //获取工作表名称
                String sheetName = sheetAt.getSheetName();
                System.out.println("工作表名称：" + sheetName);
                // 获取当前Sheet的总行数
                int rowsOfSheet = sheetAt.getPhysicalNumberOfRows();
                System.out.println("当前表格的总行数:" + rowsOfSheet);

                for (int r = 1; r < rowsOfSheet; r++) {
                    Row row = sheetAt.getRow(r);
                    if (row == null) {
                        continue;
                    } else {
                        int rowNum = row.getRowNum() + 1;
                        // 总列(格)
                        Cell cell0 = row.getCell(0);
                        Cell cell1 = row.getCell(1);
                        Cell cell2 = row.getCell(2);
                        String key = cell0.getStringCellValue();
                        Double value = cell2.getNumericCellValue();
                        result.put(key,value);
                    }
                }

            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return result;
    }
}
