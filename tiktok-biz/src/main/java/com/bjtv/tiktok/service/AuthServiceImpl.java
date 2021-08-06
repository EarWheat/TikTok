package com.bjtv.tiktok.service;

import com.alibaba.fastjson.JSONObject;
import com.bjtv.tiktok.Client.HttpClient;
import com.bjtv.tiktok.Constants.BaiduConstants;
import com.bjtv.tiktok.enums.AuthEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/18 上午11:32
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Slf4j
@Service
public class AuthServiceImpl implements AuthService{

    @Override
    public JSONObject getAuthToken(AuthEnum authEnum) {
        String apiKey = authEnum.getApiKey();
        String secretKey = authEnum.getSecretKey();
        String getAccessTokenURL = BaiduConstants.BAIDU_GET_AUTH_TOKEN_URL + "?grant_type=" + BaiduConstants.BAIDU_GRANT_TYPE + "&client_id=" + apiKey + "&client_secret=" + secretKey;
        log.info("getAccessTokenURL: {}", getAccessTokenURL);
        JSONObject token = null;
        try {
            String accessResult = HttpClient.doGetHttp(getAccessTokenURL,10000,10000);
            token = JSONObject.parseObject(accessResult);
        } catch (Exception e){
            e.printStackTrace();
            log.error("getAccessToken Error, e:{}",e.toString());
        }
        return token;
    }
}
