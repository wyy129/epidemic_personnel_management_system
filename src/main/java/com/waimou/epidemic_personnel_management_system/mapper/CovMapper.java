package com.waimou.epidemic_personnel_management_system.mapper;


import com.waimou.epidemic_personnel_management_system.pojo.Details;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CovMapper {
    @Select("select * from details where province = #{province}")
    List<Details> getDataByprovince(String province);
}
