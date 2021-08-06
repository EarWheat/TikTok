package com.bjtv.tiktok.enums;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/18 下午12:06
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public enum RestResultEnum {
    SUCCESS(0,"SUCCESS"),
    FAIL(200,"FAIL"),
    EXCEPTION(201,"EXCEPTION");

    private int errno;
    private String errmsg;

    RestResultEnum(int errno, String errmsg) {
        this.errno = errno;
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
