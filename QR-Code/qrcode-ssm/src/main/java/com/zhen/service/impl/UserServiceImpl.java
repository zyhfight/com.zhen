package com.zhen.service.impl;

import com.zhen.dao.UserDao;
import com.zhen.model.User;
import com.zhen.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserDao userDao;

    public User selectUserByUserId(String userId) {
        return userDao.selectUserByUserId(userId);
    }

    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

}
