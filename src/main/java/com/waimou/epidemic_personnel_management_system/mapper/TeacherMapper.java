package com.waimou.epidemic_personnel_management_system.mapper;

import com.waimou.epidemic_personnel_management_system.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author wyy
 * @description 针对表【teacher】的数据库操作Mapper
 * @createDate 2022-03-22 20:57:22
 * @Entity com.waimou.epidemic_personnel_management_system.pojo.Teacher
 */
@Mapper
public interface TeacherMapper {
    @Select("select * from teacher where username = #{username}")
    public Teacher findAllByUsername(String username);
}




