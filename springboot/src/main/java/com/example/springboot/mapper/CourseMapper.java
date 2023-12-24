package com.example.springboot.mapper;/*
 *ClassName:CourseMapper
 *Description: 查询课程信息接口
 *@Author:deanzhou
 *@Date:2023-12-21 14:14
 */

import com.example.springboot.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseMapper {

    /*
    * 查询所有数据
    * */
    @Select("<script>" +
            "SELECT * FROM course " +
            "<where> " +
            "   <if test='name != null and name != \"\"'> " +
            "       AND name LIKE CONCAT('%', #{name}, '%') " +
            "   </if> " +
            "   <if test='no != null and no != \"\"'> " +
            "       AND no LIKE CONCAT('%', #{no}, '%') " +
            "   </if> " +
            "   <if test='teacher != null and teacher != \"\"'> " +
            "       AND teacher LIKE CONCAT('%', #{teacher}, '%') " +
            "   </if> " +
            "</where> " +
            "ORDER BY id DESC " +
            "</script>")
    List<Course> selectAll(Course course);

    /*
    * 添加数据
    * */
    @Insert("insert into course(name,no,description,times,teacher) " +
            "values(#{name},#{no},#{description},#{times},#{teacher}) ")
    void insert(Course course);

    /*
    * 根据id更新数据
    * */
    @Update("update course set name =#{name},no =#{no},description =#{description}," +
            "times =#{times},teacher =#{teacher} where id=#{id}")
    void updateById(Course course);

    /*
     * 根据id删除数据
     * */
    @Delete("delete from course where id=#{id}")
    void deleteById(Integer id);
}
