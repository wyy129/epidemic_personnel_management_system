package com.waimou.epidemic_personnel_management_system.controller;

import com.waimou.epidemic_personnel_management_system.pojo.Teacher;
import com.waimou.epidemic_personnel_management_system.result.JsonResult;
import com.waimou.epidemic_personnel_management_system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

//解决跨域
@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    JsonResult jsonResult = new JsonResult();


    @RequestMapping("/login")
    public JsonResult login(@RequestBody Map map) {
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        Teacher teacher = teacherService.findAllByUsername(username);
        if (teacher != null) {
            String password1 = teacher.getPassword();
            if (!Objects.equals(password, password1)) {
                return jsonResult.error("登录失败");
            } else return jsonResult.success(teacher);
        } else return jsonResult.error("用户不存在");
    }

}
