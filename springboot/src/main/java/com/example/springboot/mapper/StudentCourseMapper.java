package com.example.springboot.mapper;/*
 *ClassName:StudentCourseMapper
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-24 18:18
 */

import com.example.springboot.entity.StudentCourse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentCourseMapper {

    
    /*
    * 插入数据
    * */
    @Insert("insert into student_course(name,no,student_id,course_id)" +
            "values(#{name},#{no},#{student_id},#{course_id})")
    void insert(StudentCourse studentCourse);

    /*
    * 根据条件查询数据
    * */
    @Select("select * from student_course where  student_id=#{student_id} " +
            "and course_id=#{course_id}")
    StudentCourse selectByCondition(StudentCourse studentCourse);


    /*
    * 查询所有 学生课程 数据
    * */
    @Select("<script>" +
            "SELECT * FROM student_course" +
            "<where> " +
            "   <if test='name != null and name != \"\"'> " +
            "       AND name like concat('%',#{name},'%') " +
            "   </if> " +
            "   <if test='no != null and no != \"\"'> " +
            "       AND no like concat('%',#{no},'%')  " +
            "   </if> " +
            "</where> " +
            "</script>")
    List<StudentCourse> selectByAll(StudentCourse studentCourse);

    /*
    * 删除课程
    * */
    @Delete("delete from student_course where id=#{id}")
    void deleteById(Integer id);
}
