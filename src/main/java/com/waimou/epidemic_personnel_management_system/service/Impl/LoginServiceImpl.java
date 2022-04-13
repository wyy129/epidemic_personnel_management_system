package com.waimou.epidemic_personnel_management_system.service.Impl;


import com.waimou.epidemic_personnel_management_system.mapper.UserMapper;
import com.waimou.epidemic_personnel_management_system.pojo.User;
import com.waimou.epidemic_personnel_management_system.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByPhone(String phone) {

        return userMapper.findByPhone(phone);
    }

    @Override
    public void creadUser(String phone) {
        userMapper.creadUser(phone);
    }
}
