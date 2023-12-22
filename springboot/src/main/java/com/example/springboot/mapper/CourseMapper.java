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
    @Select("select * from course where name like concat('%',#{name},'%') " +
            "and no like concat('%',#{no},'%') and teacher like  concat('%',#{teacher},'%') order by id DESC ")
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
