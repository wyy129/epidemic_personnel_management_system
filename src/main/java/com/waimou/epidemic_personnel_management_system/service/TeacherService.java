package com.waimou.epidemic_personnel_management_system.service;

import com.waimou.epidemic_personnel_management_system.pojo.Teacher;

/**
 * @author wyy
 * @description 针对表【teacher】的数据库操作Service
 * @createDate 2022-03-22 20:57:22
 */
public interface TeacherService {
    public Teacher findAllByUsername(String username);
}
