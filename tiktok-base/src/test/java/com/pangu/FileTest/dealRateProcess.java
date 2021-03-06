package com.pangu.FileTest;

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
            json.put("completion_rate_control_switch",1);
            json.put("level_one_ban_time",1);
            json.put("level_two_ban_time",2);
            json.put("level_three_ban_time",3);
            json.put("level_four_ban_time",7);
            json.put("min_completion_rate",percent2Double(kv[1]));
            result.put(kv[0], json);
        }
        return result;
    }

    public Double percent2Double(String percent){
        String result = "0.".concat(percent.substring(0,2));
        return Double.parseDouble(result);
    }
}
