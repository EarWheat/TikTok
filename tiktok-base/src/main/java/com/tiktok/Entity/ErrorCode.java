package com.tiktok.Entity;

/*
 * @author:liuzhaolu
 * @createTime: 2019-12-19 16:07
 * @desc:
 */
public enum ErrorCode {
    SUCCESS("SUCCESS",0),
    ERROR("error",-1);
    // 成员变量
    private String info;
    private int code;

    private ErrorCode(String info, int code){
        this.info = info;
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
