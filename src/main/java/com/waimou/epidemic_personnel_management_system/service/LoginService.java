package com.waimou.epidemic_personnel_management_system.service;

import com.waimou.epidemic_personnel_management_system.pojo.User;

public interface LoginService {
    User findByPhone(String phone);

    void creadUser(String phone);
}
