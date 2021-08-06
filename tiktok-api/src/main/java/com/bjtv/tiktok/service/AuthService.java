package com.bjtv.tiktok.service;

import com.alibaba.fastjson.JSONObject;
import com.bjtv.tiktok.enums.AuthEnum;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/7/18 上午11:19
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public interface AuthService {
    JSONObject getAuthToken(AuthEnum authEnum);
}
