package com.bjtv.tiktok.entity;

import com.bjtv.tiktok.enums.RestResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/18 下午12:03
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResult<T> {
    private int errno;
    private String errmsg;
    private T data;

    public RestResult<T> withErrNo(int errno){
        this.errno = errno;
        return this;
    }

    public RestResult<T> withErrMsg(String msg){
        this.errmsg = msg;
        return this;
    }

    public RestResult<T> withData(T data){
        this.data = data;
        return this;
    }


    public static <T> RestResult<T> buildSuccess(T data){
        return new RestResult<T>()
                .withErrNo(RestResultEnum.SUCCESS.getErrno())
                .withErrMsg(RestResultEnum.SUCCESS.getErrmsg())
                .withData(data);
    }

    public static <T> RestResult<T> buildFail(T data){
        return new RestResult<T>()
                .withErrNo(RestResultEnum.FAIL.getErrno())
                .withErrMsg(RestResultEnum.FAIL.getErrmsg())
                .withData(data);
    }

    public static <T> RestResult<T> buildFail(){
        return new RestResult<T>()
                .withErrNo(RestResultEnum.FAIL.getErrno())
                .withErrMsg(RestResultEnum.FAIL.getErrmsg());
    }

}
