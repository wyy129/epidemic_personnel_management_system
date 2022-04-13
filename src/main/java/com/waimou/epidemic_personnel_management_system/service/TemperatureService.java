package com.waimou.epidemic_personnel_management_system.service;


/**
 * @author wyy
 * @description 针对表【temperature】的数据库操作Service
 * @createDate 2022-03-11 19:35:13
 */
public interface TemperatureService {
    void creadTemperature(String temperature, String datetime, Integer isRisk, int userId);

}
