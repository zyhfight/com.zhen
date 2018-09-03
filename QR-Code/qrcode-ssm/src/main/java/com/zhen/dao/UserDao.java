package com.zhen.dao;

import com.zhen.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Repository
public interface UserDao {

    User selectUserByUserId(@Param("userId") String userId);
    List<User> selectAllUser();

}
