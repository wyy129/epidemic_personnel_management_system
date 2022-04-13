package com.waimou.epidemic_personnel_management_system.mapper;

import com.waimou.epidemic_personnel_management_system.pojo.Details;
import com.waimou.epidemic_personnel_management_system.pojo.ProvinceData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wyy
 * @description 针对表【province_data】的数据库操作Mapper
 * @createDate 2022-04-09 16:39:19
 * @Entity generator.pojo.ProvinceData
 */
@Mapper
public interface ProvinceDataMapper {
    @Select("select * from province_data")
    List<ProvinceData> getALl();

    @Select("SELECT * FROM province_data ORDER BY `value` ASC")
    List<ProvinceData> getALl_low();
}




