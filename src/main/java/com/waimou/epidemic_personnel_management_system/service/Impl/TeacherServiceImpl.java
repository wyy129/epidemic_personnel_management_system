package com.waimou.epidemic_personnel_management_system.service.Impl;


import com.waimou.epidemic_personnel_management_system.mapper.TeacherMapper;
import com.waimou.epidemic_personnel_management_system.pojo.Teacher;
import com.waimou.epidemic_personnel_management_system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wyy
 * @description 针对表【teacher】的数据库操作Service实现
 * @createDate 2022-03-22 20:57:22
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher findAllByUsername(String username) {

        return teacherMapper.findAllByUsername(username);
    }
}




