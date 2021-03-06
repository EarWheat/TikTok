package com.pangu.Entity;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-14 17:07
 * @desc:
 */
public class RestEntity {

    private String RemoteAddr;
    private String RequestURL;
    private String Method;
    private String extra;

    public String getRemoteAddr() {
        return RemoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        RemoteAddr = remoteAddr;
    }

    public String getRequestURL() {
        return RequestURL;
    }

    public void setRequestURL(String requestURL) {
        RequestURL = requestURL;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String method) {
        Method = method;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
