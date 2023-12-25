package com.example.springboot.mapper;/*
 *ClassName:GradeMapper
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-24 19:54
 */

import com.example.springboot.entity.Grade;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GradeMapper {
    
    List<Grade> selectAll(Grade grade);

    @Insert("insert into grade (course_id,student_id,score,comment,feedback,)" +
            "values (#{courseId},#{studentId},#{score},#{comment},#{feedback})")
    void insert();

    /*
    * 根据条件查询
    * */
    @Select("select * from grade where id=#{id}")
    Grade selectByCondition(Grade grade);

    @Delete("delete from grade where id=#{id}")
    void deleteById(Integer id);

    @Update("update grade set score =#{score},comment=#{comment}," +
            "feedback=#{feedback} where id=#{id}")
    void updateById(Grade grade);
}
