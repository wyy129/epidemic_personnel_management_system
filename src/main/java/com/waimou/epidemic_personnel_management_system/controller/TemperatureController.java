package com.waimou.epidemic_personnel_management_system.controller;

import com.waimou.epidemic_personnel_management_system.pojo.Temperature;
import com.waimou.epidemic_personnel_management_system.result.JsonResult;
import com.waimou.epidemic_personnel_management_system.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RestController
@RequestMapping("/temperature")
public class TemperatureController {
    @Autowired
    private TemperatureService temperatureService;

    @RequestMapping("/sendtemperature")
    public JsonResult sendtemperature(@RequestBody Temperature temperature) {
        JsonResult jsonResult = new JsonResult();
        Integer isRisk = temperature.getIsRisk();
        String temperature1 = temperature.getTemperature();
        String datetime = temperature.getDatetime();
        Integer userId = temperature.getUserId();
        temperatureService.creadTemperature(temperature1,datetime,isRisk,userId);
        return jsonResult.success(temperature);

    }

}
