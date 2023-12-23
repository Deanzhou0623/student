package com.example.springboot.mapper;/*
 *ClassName:StudentMapper
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-22 20:49
 */

import com.example.springboot.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {

    @Select("select * from student where username =#{username}")
    Student selectByUsername(@Param("username")String username);
}
