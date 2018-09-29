package com.provider.demo.service;

import com.provider.demo.entity.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Description: 该类的功能描述
 * @author: zyh
 * @date: 2018-9-29
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    /**
     * 模拟两个账户：
     * ① 账号是user，密码是password1，角色是user-role
     * ② 账号是admin，密码是password2，角色是admin-role
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if("user".equals(userName)) {
            return new SecurityUser("user", "password1", "user-role");
        } else if ("admin".equals(userName)) {
            return new SecurityUser("admin", "password2", "admin-role");
        } else {
            return null;
        }
    }
}
