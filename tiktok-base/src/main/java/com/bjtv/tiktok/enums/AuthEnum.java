package com.bjtv.tiktok.enums;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/18 上午11:25
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public enum AuthEnum {

    TENCENT("Tencent","2"),
    BAIDU("Baidu","23632789","M8a1IxRLZPPyQLZ04izlpBRX","Goi2UQ0q9EyFZz5uNgT30lzmYsMEzNuA"),
    ALIBABA("Alibaba","1","2");

    private String name;
    private String appId;
    private String apiKey;
    private String secretKey;

    private AuthEnum(String name, String apiKey, String secretKey) {
        this.name = name;
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    private AuthEnum(String name, String secretKey) {
        this.name = name;
        this.secretKey = secretKey;
    }

    private AuthEnum(String name, String appId, String apiKey, String secretKey) {
        this.name = name;
        this.appId = appId;
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
