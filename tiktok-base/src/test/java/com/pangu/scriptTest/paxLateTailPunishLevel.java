package com.pangu.scriptTest;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-09-11 11:09
 * @desc
 * @prd Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class paxLateTailPunishLevel {
    public static Long paxLateTailPunishLevel(Long lateScore, String threshold){
        if(lateScore == null || StringUtils.isBlank(threshold)){
            return 0L;
        }
        JSONObject jsonObject = JSONObject.parseObject(threshold);
        if(jsonObject.containsKey("level3")){
            if(lateScore > jsonObject.getLongValue("level3")){
                return 3L;
            }
        }
        if(jsonObject.containsKey("level2")){
            if(lateScore > jsonObject.getLongValue("level2")){
                return 2L;
            }
        }
        return 0L;
    }

    public static void main(String[] args) {
        System.out.println(paxLateTailPunishLevel(4L,"{\"level2\":2,\"level3\":3}"));
    }
}
