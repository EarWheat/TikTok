package com.pangu.Http.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-26 10:18
 * @desc:
 */
public class RestResult<T> implements Serializable {
    private static final long serialVersionUID = 8731622331306688357L;

    @JSONField(name = "errno")
    private Integer errNo;
    @JSONField(name = "errMsg")
    private String errMsg;
    @JSONField(name = "data")
    private T data;

    public RestResult(int errNo, String errMsg, T data) {
        this.errNo = errNo;
        this.errMsg = errMsg;
        this.data = data;
    }

    public RestResult(int errNo, String errMsg) {
        this.errNo = errNo;
        this.errMsg = errMsg;
    }

    public RestResult(){

    }

    public Integer getErrNo() {
        return errNo;
    }

    public void setErrNo(Integer errNo) {
        this.errNo = errNo;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static <T> RestResult<T> successResult(T data) {
        if(data instanceof ResultEnum){
            String dataInfo = "";
            if(data == ResultEnum.USER_ONLINE){
                dataInfo = RestErrorMsg.USER_ONLINE;
            } else if(data == ResultEnum.LOGIN_SUCCESS){
                dataInfo = RestErrorMsg.LOGIN_SUCCESS;
            }
            return new RestResult(0,"success",  dataInfo);
        }
        return new RestResult<>(0, "success", data);
    }

    public static <T> RestResult<T> successResult(){
        return new RestResult<>(0, "success");
    }

    public static <T> RestResult<T> failResult(int errNo, String errMsg, T data) {
        return new RestResult<>(errNo, errMsg, data);
    }

    public static <T> RestResult<T> failResult(T data){
        return new RestResult<>(-1,"error",data);
    }

    public static <T> RestResult<T> failResult(ResultEnum resultEnum) {
        int errNo = -1;
        String errMsg = "";
        if(resultEnum == ResultEnum.PARAM_ERROR){
            errNo = -1;
            errMsg = RestErrorMsg.PARAM_ERROR;
        } else if(resultEnum == ResultEnum.EXCEPTION){
            errNo = 999;
            errMsg = RestErrorMsg.EXCEPTION;
        } else if(resultEnum == ResultEnum.PARAM_EMPTY){
            errNo = 1;
            errMsg = RestErrorMsg.PARAM_EMPTY;
        } else if(resultEnum == ResultEnum.LOGIN_ERROR){
            errMsg = RestErrorMsg.LOGIN_ERROR;
        }
        return new RestResult<>(errNo, errMsg);
    }
}
