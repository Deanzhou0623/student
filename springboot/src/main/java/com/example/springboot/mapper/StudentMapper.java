package com.example.springboot.mapper;/*
 *ClassName:StudentMapper
 *Description: student sql statement
 *@Author:deanzhou
 *@Date:2023-12-22 20:49
 */

import com.example.springboot.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {

    /*
    * 根据用户名查询
    * */
    @Select("select * from student where username =#{username}")
    Student selectByUsername(String username);

    /*
    * 插入学生信息
    * */
    @Insert("insert into student (username,password,name,phone,email,sex" +
            "birth,avatar,role) values (#{username},#{password},#{name},#{phone}" +
            ",#{email},#{sex},#{birth},#{avatar},#{role})")
    void insert(Student student);

    /*
    * 删除学生信息
    * */
    @Delete("delete from student where id ={id} ")
    void deleteById(Integer id);

    /*
    * 更新学生信息
    * */
    @Update("update student set username =#{username} ,password=#{password}," +
            "name =#{name},phone =#{phone},email=#{email},sex =#{sex},birth=#{birth}," +
            "avatar =#{avatar} where id =#{id}")
    void updateById(Student student);

    /*
    * 查询学生信息
    * */

    @Select("<script>" +
            "SELECT * FROM student" +
            "<where> " +
            "   <if test='username != null and username != \"\"'> " +
            "       AND username LIKE CONCAT('%', #{username}, '%') " +
            "   </if> " +
            "   <if test='name != null and name != \"\"'> " +
            "       AND name LIKE CONCAT('%', #{name}, '%') " +
            "   </if> " +
            "</where> " +
            "</script>")
    List<Student> selectAll(Student student);
}
