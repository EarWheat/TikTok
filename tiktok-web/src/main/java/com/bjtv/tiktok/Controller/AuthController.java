package com.bjtv.tiktok.Controller;

import com.alibaba.fastjson.JSONObject;
import com.bjtv.tiktok.Entity.RestResult;
import com.bjtv.tiktok.Enums.AuthEnum;
import com.bjtv.tiktok.service.AuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/4 上午10:30
 * @desc 鉴权
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@RequestMapping("/auth")
@RestController
public class AuthController {
    @Resource
    public AuthService authService;

    @RequestMapping("/getToken")
    public RestResult<JSONObject> getToken(@RequestParam(value = "product") String product){
        AuthEnum authEnum;
        if(product.equals(AuthEnum.BAIDU.getName())){
            authEnum = AuthEnum.BAIDU;
        } else if(product.equals(AuthEnum.TENCENT.getName())){
            authEnum = AuthEnum.TENCENT;
        } else {
            authEnum = AuthEnum.ALIBABA;
        }
        JSONObject token = authService.getAuthToken(authEnum);
        return RestResult.buildSuccess(token);
    }
}
