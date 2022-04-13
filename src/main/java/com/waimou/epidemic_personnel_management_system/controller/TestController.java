package com.waimou.epidemic_personnel_management_system.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.waimou.epidemic_personnel_management_system.DTO.ChoosePaper;
import com.waimou.epidemic_personnel_management_system.im.zego.serverassistant.utils.TokenServerAssistant;
import com.waimou.epidemic_personnel_management_system.mapper.*;
import com.waimou.epidemic_personnel_management_system.pojo.*;
import com.waimou.epidemic_personnel_management_system.result.JsonResult;
import com.waimou.epidemic_personnel_management_system.until.JwtUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private Graduation_projectMapper graduation_projectMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CovMapper covMapper;
    @Autowired
    private ProvinceDataMapper provinceDataMapper;
    @Autowired
    private ChinatotalMapper chinatotalMapper;
    JsonResult jsonResult = new JsonResult();

//  已实现TemperatureController
//    @RequestMapping("/test")
//    public JsonResult sendtemperature(@RequestBody Temperature temperature) {
//        JsonResult jsonResult = new JsonResult();
//        System.out.println(temperature);
//        return jsonResult.success(temperature);
//
//    }

    @RequestMapping("/TestJwt")
    public JsonResult TestJwt() {
//        JsonResult jsonResult = new JsonResult();
//        配置token
        String jwtToken = JwtUtils.createToken(1, "18132108980");
//        检验token
        JwtUtils.verifyToken(jwtToken, "1");
        String audience = JwtUtils.getAudience(jwtToken);
        return jsonResult.success(audience);

    }
//  已经实现具体GraduationProjectController
//    @RequestMapping("/TestGraduation")
//    public JsonResult TestGraduation() {
//        List<GraduationProject> all = graduation_projectMapper.findAll();
////        System.out.println(all);
//        return jsonResult.success(all);
//    }

    //  学生根据毕业设计id 选择自己的毕业设计
    @RequestMapping("/TestchoosePaper")
    public JsonResult TestchoosePaper(@RequestBody ChoosePaper choosePaper) {
        int project_id = choosePaper.getProject_id();
        int user_id = choosePaper.getUser_id();
        System.out.println(choosePaper);
        userMapper.updateUser_project_id(project_id, user_id);
        return jsonResult.success("成功添加");
    }


    //    @RequestMapping("/TestToken04")
//    public JsonResult TestToken04(@RequestBody Map map) {
//
//        long appId = 1994355029;    // 由即构提供
//        String secretKey = "48d8e39fe1a3772e425115ecb5326633";  // 由即构提供
//        String userId = map.get("user_id").toString();
//        System.out.println(userId);
//        int effectiveTimeInSeconds = 3600*24;   // 有效时间，单位：秒
//
//        String payload = "{\"payload\":\"payload\"}";// 普通token，payload字段可传空
//        TokenServerAssistant.VERBOSE = true;    // 调试时，置为 true, 可在控制台输出更多信息；正式运行时，最好置为 false
//        TokenServerAssistant.TokenInfo token =
//                TokenServerAssistant.generateToken04(appId,
//                        userId, secretKey,
//                        effectiveTimeInSeconds,
//                        payload);
//        System.out.println(token);
//        return jsonResult.success(token);
//    }
    @RequestMapping("/TestToken04")
    public JsonResult TestToken04(@RequestBody Map map) {

        long appId = 1994355029;    // 由即构提供
        String secretKey = "48d8e39fe1a3772e425115ecb5326633";  // 由即构提供
        String userId = map.get("user_id").toString();
        System.out.println(userId);    // 用户 ID，同一 appId 下全网唯一
        int effectiveTimeInSeconds = 3600 * 24;   // 有效时间，单位：秒

        JSONObject payloadData = new JSONObject();
        payloadData.put("room_id", "0001"); // 房间id，限制用户只能登录特定房间
        JSONObject privilege = new JSONObject();
        //是否允许登录房间 1 允许 0关闭
        privilege.put(TokenServerAssistant.PrivilegeKeyLogin, TokenServerAssistant.PrivilegeEnable);
        //是否允许推流    1 允许 0关闭
        privilege.put(TokenServerAssistant.PrivilegeKeyPublish, TokenServerAssistant.PrivilegeEnable);
        payloadData.put("privilege", privilege);
        payloadData.put("stream_id_list", null);
        String payload = payloadData.toJSONString();

        TokenServerAssistant.VERBOSE = false;    // 调试时，置为 true, 可在控制台输出更多信息；正式运行时，最好置为 false
        TokenServerAssistant.TokenInfo token = TokenServerAssistant.generateToken04(appId, userId, secretKey, effectiveTimeInSeconds, payload);
        System.out.println(token.data);
        return jsonResult.success(token.data);
    }

    // 根据省份获取省份下市级疫情信息用于 echarts地图展示
    @RequestMapping("/getDataByprovince")
    public JsonResult getDataByprovince(@RequestBody Map map) {
//        System.out.println(map);
        String province = map.get("province").toString();
        System.out.println(province);
        List<Details> dataByprovince = covMapper.getDataByprovince(province);
//        System.out.println(dataByprovince);
        return jsonResult.success(dataByprovince);

    }

    //    获取省份数据
    @RequestMapping("/get_provinceData")
    public JsonResult get_provinceData() {
        List<ProvinceData> dataList = provinceDataMapper.getALl();
        return jsonResult.success(dataList);

    }

    //    获取省份数据 以value 升序获取省份数据列表
    @RequestMapping("/get_provinceData_low")
    public JsonResult get_provinceData_low() {
        List<ProvinceData> dataList = provinceDataMapper.getALl_low();
        return jsonResult.success(dataList);

    }

    //    获取全国整体大数据
    @RequestMapping("/getChina")
    public JsonResult getChina() {
        List<Chinatotal> chinatotal = chinatotalMapper.getData();
        return jsonResult.success(chinatotal.get(0));

    }
}
