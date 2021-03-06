package com.bjtv.tiktok.Controller;

import com.alibaba.fastjson.JSONObject;
import com.pangu.Http.response.RestResult;
import com.bjtv.tiktok.Entity.Auth.AuthEnum;
import com.bjtv.tiktok.Service.AuthService.AuthService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/4 δΈε10:30
 * @desc ι΄ζ
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@RequestMapping("/auth")
@RestController
public class AuthController {
    @Resource
    AuthService authService;

    @RequestMapping("/getToken")
    public RestResult<JSONObject> getToken(@RequestParam(value = "product") String product){
        AuthEnum authEnum;
        if(product.equals(AuthEnum.Baidu.getName())){
            authEnum = AuthEnum.Baidu;
        } else if(product.equals(AuthEnum.Tencent.getName())){
            authEnum = AuthEnum.Tencent;
        } else {
            authEnum = AuthEnum.Alibaba;
        }
        JSONObject token = authService.getAuthToken(authEnum);
        return RestResult.successResult(token);
    }
}
