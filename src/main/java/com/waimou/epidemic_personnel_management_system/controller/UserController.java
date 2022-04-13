package com.waimou.epidemic_personnel_management_system.controller;

import com.waimou.epidemic_personnel_management_system.pojo.User;
import com.waimou.epidemic_personnel_management_system.result.JsonResult;
import com.waimou.epidemic_personnel_management_system.service.Impl.LoginServiceImpl;
import com.waimou.epidemic_personnel_management_system.service.LoginService;

import com.waimou.epidemic_personnel_management_system.until.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//解决跨域
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/sendcode")
    public JsonResult sendCode(@RequestBody Map map) {
        JsonResult jsonResult = new JsonResult();
//        获取前端传输的phone
        String phone = map.get("phone").toString();
//        根据前端手机号 发送验证码
        return jsonResult.success(map);
    }

    @RequestMapping("/login")
    public JsonResult login(@RequestBody Map map) {
        JsonResult jsonResult = new JsonResult();
//        获取前端传过来的数据
        String phone = map.get("phone").toString();
//        先进行判断 手机号和验证码是否匹配
//        万能验证码
        String code = map.get("code").toString();
        if (code.equals("123456")) {
            //      如果匹配则先根据手机号寻找用户 如果没找到则创建用户
            User user = loginService.findByPhone(phone);
            if (user == null) {
//                如果未找到用户则创建用户
                loginService.creadUser(phone);
//                获取刚创建的用户并且创建token
                User user1 = loginService.findByPhone(phone);
                String token = JwtUtils.createToken(user1.getId(), user1.getPhone());
                return jsonResult.success(user1);
            } else {
                String token = JwtUtils.createToken(user.getId(), user.getPhone());
                return jsonResult.success(user);
            }
        } else return jsonResult.error(map);
    }
}
