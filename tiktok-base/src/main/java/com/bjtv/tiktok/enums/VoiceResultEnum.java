package com.bjtv.tiktok.enums;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/6 3:02 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public enum VoiceResultEnum {
    VOICE_FILE_EMPTY(-1,"VOICE_FILE_EMPTY");
    private int code;
    private String message;

    VoiceResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
