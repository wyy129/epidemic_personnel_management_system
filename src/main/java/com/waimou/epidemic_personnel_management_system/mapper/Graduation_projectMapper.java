package com.waimou.epidemic_personnel_management_system.mapper;

import com.waimou.epidemic_personnel_management_system.pojo.GraduationProject;
import com.waimou.epidemic_personnel_management_system.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Graduation_projectMapper {
    @Select("select * from Graduation_project")
    List<GraduationProject> findAll();

    @Select("select * from Graduation_project where id = #{id}")
    GraduationProject findById(int id);

    //INSERT INTO `test`.`Graduation_project` (`name`, `teacher`, `description`) VALUES ('职业核心', '天边云', '职业核心作业')
    @Insert("INSERT INTO test.Graduation_project ( name, teacher, description) values (#{name},#{teacher},#{description})")
    void addProject(String name, String teacher, String description);

    @Select("select * from Graduation_project where teacher = #{name}")
    List<GraduationProject> getProjectByname(String name);

    //    //DELETE FROM `test`.`Graduation_project` WHERE `id` = 17
    @Delete("DELETE FROM Graduation_project where id = #{id}")
    void deleteByid(Integer id);
}
