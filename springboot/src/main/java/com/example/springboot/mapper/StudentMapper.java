package com.example.springboot.mapper;/*
 *ClassName:StudentMapper
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-22 20:49
 */

import com.example.springboot.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {

    @Select("select * from student where username =#{username}")
    Student selectByUsername(String username);

    @Insert("insert into student (username,password,name,phone,email,sex" +
            "birth,avatar,role) values (#{username},#{password},#{name},#{phone}" +
            ",#{email},#{sex},#{birth},#{avatar},#{role})")
    void insert(Student student);
}
