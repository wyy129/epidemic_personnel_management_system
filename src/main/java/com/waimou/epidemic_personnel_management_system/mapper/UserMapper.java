package com.waimou.epidemic_personnel_management_system.mapper;

import com.waimou.epidemic_personnel_management_system.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * from user where phone = #{phone}")
    User findByPhone(String phone);

    @Insert("INSERT INTO test.user (phone) VALUES (#{phone})")
    void creadUser(String phone);

    // 给某个用户添加 毕设id UPDATE `test`.`user` SET `project_id` = 1 WHERE `id` = 1
    @Update("update test.user SET project_id = #{project_id} where `id` =#{user_id}")
    void updateUser_project_id(int project_id, int user_id);
}
