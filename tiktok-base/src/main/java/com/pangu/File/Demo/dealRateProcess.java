package com.pangu.File.Demo;

import com.pangu.File.FileProcessLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020/12/30 上午10:30
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class dealRateProcess extends FileProcessLine {

    public List<String> data = new ArrayList<>();

    @Override
    public void readLine(String line) {
        data.add(line);
    }

    @Override
    public Object process() {
        Map<String, Map<String,Object>> result = new HashMap<>();
        for(String str : data){
            Map<String, Object> json = new HashMap<>();
            String[] kv = str.split(",");
            json.put("value",percent2Double(kv[1]));
            result.put(kv[0], json);
        }
        return result;
    }

    public Double percent2Double(String percent){
        String result = "0.".concat(percent.substring(0,1));
        return Double.parseDouble(result);
    }
}
