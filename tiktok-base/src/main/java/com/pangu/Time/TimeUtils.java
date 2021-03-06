package com.pangu.Time;

import com.alibaba.fastjson.JSONArray;
import org.springframework.util.StringUtils;

import java.util.*;

/*
 * @author:liuzhaolu
 * @createTime: 2019-12-20 18:11
 * @desc:
 */
public class TimeUtils {
    private static final Long Hour = 60L * 60L * 1000;

    public static void main(String[] args) {
        System.out.println(timeArrayList("2019-09-16 15:02:30", "2020-03-16 07:01:35"));
    }

    /**
     * 获取当前时间的整点小时时间
     *
     * @return
     */
    public Long getNextHourTime() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        Date date = ca.getTime();
        return date.getTime() + Hour;
    }

    /**
     * 获取当前毫秒级时间
     *
     * @return
     */
    public Long getCurrTime() {
        Date date = new Date();
        return date.getTime();
    }

    public static String timeArrayList(String s1, String s2) {
        if (StringUtils.isEmpty(s1) || StringUtils.isEmpty(s2)) {
            return null;
        }
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(s1);
        jsonArray.add(s2);
        return jsonArray.toString();
    }
}
