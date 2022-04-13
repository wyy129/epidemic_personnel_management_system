package com.waimou.epidemic_personnel_management_system.service;

import com.waimou.epidemic_personnel_management_system.pojo.GraduationProject;

import java.util.List;

public interface GraduationProjectService {
     GraduationProject findByID(int id);
     List<GraduationProject> finALl();

    void addProject(String name, String description, String teacher);

    List<GraduationProject> getProjectByname(String name);

    void deleteByid(Integer id);
}

