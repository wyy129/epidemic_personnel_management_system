package com.waimou.epidemic_personnel_management_system.mapper;


import com.waimou.epidemic_personnel_management_system.pojo.Chinatotal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wyy
 * @description 针对表【chinaTotal】的数据库操作Mapper
 * @createDate 2022-04-13 09:30:45
 * @Entity generator.pojo.Chinatotal
 */
@Mapper
public interface ChinatotalMapper {
    @Select("select * from chinaTotal")
    List<Chinatotal> getData();
}




