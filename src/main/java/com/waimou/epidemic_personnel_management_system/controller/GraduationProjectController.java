package com.waimou.epidemic_personnel_management_system.controller;

import com.waimou.epidemic_personnel_management_system.pojo.GraduationProject;
import com.waimou.epidemic_personnel_management_system.result.JsonResult;
import com.waimou.epidemic_personnel_management_system.service.GraduationProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//解决跨域
@CrossOrigin
@RestController
@RequestMapping("/GraduationProject")
public class GraduationProjectController {
    JsonResult jsonResult = new JsonResult();
    @Autowired
    private GraduationProjectService graduationProjectService;

    @RequestMapping("/GetProject")
    public JsonResult GetProject(@RequestBody Map map) {
        int id = (int) map.get("id");
        GraduationProject project = graduationProjectService.findByID(id);
        return jsonResult.success(project);
    }

    //获取所有毕设信息
    @RequestMapping("/GetAllProject")
    public JsonResult TestGraduation() {
        List<GraduationProject> all = graduationProjectService.finALl();
        System.out.println(all);
        return jsonResult.success(all);
    }

    //老师发布毕设
    @RequestMapping("/addProject")
    public JsonResult addProject(@RequestBody GraduationProject graduationProject) {
        String name = graduationProject.getName();
        String description = graduationProject.getDescription();
        String teacher = graduationProject.getTeacher();
        graduationProjectService.addProject(name, teacher, description);
        return jsonResult.success("添加成功");
    }

    //    老师获取，自己发布的毕设
    @RequestMapping("/getProjectByname")
    public JsonResult getProjectByname(@RequestBody Map map) {
        String name = map.get("name").toString();
        List<GraduationProject> list = graduationProjectService.getProjectByname(name);
        return jsonResult.success(list);
    }

    @RequestMapping("/deleteByid")
    public JsonResult deleteByid(@RequestBody Map map) {
        Integer id = (Integer) map.get("id");
        graduationProjectService.deleteByid(id);
        return jsonResult.success("删除成功");
    }

}
