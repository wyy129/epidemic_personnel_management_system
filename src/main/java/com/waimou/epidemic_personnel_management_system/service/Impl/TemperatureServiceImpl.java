package com.waimou.epidemic_personnel_management_system.service.Impl;

import com.waimou.epidemic_personnel_management_system.mapper.TemperatureMapper;
import com.waimou.epidemic_personnel_management_system.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wyy
 * @description 针对表【temperature】的数据库操作Service实现
 * @createDate 2022-03-11 19:35:13
 */
@Service
public class TemperatureServiceImpl implements TemperatureService {
    @Autowired
    private TemperatureMapper temperatureMapper;

    @Override
    public void creadTemperature(String temperature, String datetime, Integer isRisk, int userId) {
        temperatureMapper.creadTemperature(temperature, datetime, isRisk, userId);
    }
}




