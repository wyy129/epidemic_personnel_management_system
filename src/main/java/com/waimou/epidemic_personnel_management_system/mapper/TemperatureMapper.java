package com.waimou.epidemic_personnel_management_system.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wyy
 * @description 针对表【temperature】的数据库操作Mapper
 * @createDate 2022-03-11 19:35:13
 * @Entity generator.pojo.Temperature
 */
@Mapper
public interface TemperatureMapper {
    @Insert("INSERT INTO test.temperature (is_risk, temperature, datetime, user_id)  VALUES (#{isRisk},#{temperature},#{datetime},#{userId})")
    public void creadTemperature(String temperature, String datetime, Integer isRisk, int userId);
}




