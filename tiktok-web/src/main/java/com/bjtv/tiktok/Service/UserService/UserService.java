package com.bjtv.tiktok.Service.UserService;


import com.bjtv.tiktok.Entity.User.User;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/26 下午6:26
 * @desc 用户类Service
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */

public interface UserService {
    User getUserByUserName(String userName);
    User getUserByUserId(String userId);
    Boolean updateUserInfo(User user);
    Boolean addUser(User user);
}
