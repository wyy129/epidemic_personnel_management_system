package com.waimou.epidemic_personnel_management_system.service.Impl;

import com.waimou.epidemic_personnel_management_system.mapper.Graduation_projectMapper;
import com.waimou.epidemic_personnel_management_system.pojo.GraduationProject;
import com.waimou.epidemic_personnel_management_system.service.GraduationProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraduationProjectImpl implements GraduationProjectService {
    @Autowired
    private Graduation_projectMapper graduation_projectMapper;

    @Override
    public GraduationProject findByID(int id) {
        return graduation_projectMapper.findById(id);
    }

    @Override
    public List<GraduationProject> finALl() {
        return graduation_projectMapper.findAll();
    }

    @Override
    public void addProject(String name, String teacher, String description) {
        graduation_projectMapper.addProject(name, teacher, description);
    }

    @Override
    public List<GraduationProject> getProjectByname(String name) {
        return graduation_projectMapper.getProjectByname(name);
    }

    @Override
    public void deleteByid(Integer id) {
        graduation_projectMapper.deleteByid(id);
    }
}
