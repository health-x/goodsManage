package com.health.service.impl;

import com.health.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailServiceImpl implements UserDetailsService {

    private UserService userService;

    //set方式注入
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //构建权限集合
        List<GrantedAuthority> roles = new ArrayList();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        //获取商家
        com.health.pojo.User user = userService.findOne(username);
        if (null!=user){
            return new User(username,user.getPassword(),roles);
        }
        return null;
    }
}
