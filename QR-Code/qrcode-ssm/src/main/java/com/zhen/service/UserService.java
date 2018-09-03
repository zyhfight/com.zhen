package com.zhen.service;

import com.zhen.model.User;

import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */
public interface UserService {

    User selectUserByUserId(String userId);
    List<User> selectAllUser();
}
