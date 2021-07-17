package com.bjtv.tiktok.Service.AuthService;

import com.alibaba.fastjson.JSONObject;
import com.bjtv.tiktok.Entity.Auth.AuthEnum;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/3 下午7:55
 * @desc 获取鉴权token
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public interface AuthService {
    JSONObject getAuthToken(AuthEnum authEnum);
}
