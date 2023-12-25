package com.example.springboot.service;/*
 *ClassName:StudentCourseService
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-24 18:17
 */

import com.example.springboot.entity.StudentCourse;
import com.example.springboot.exception.CustomException;
import com.example.springboot.mapper.StudentCourseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentCourseService {

    @Resource
    private StudentCourseMapper studentCourseMapper;
    /*
    * 学生选课
    * */
    public void add(StudentCourse studentCourse){
        //1. 筛选课程是否重复
        StudentCourse course= studentCourseMapper.selectByCondition(studentCourse);
        if (course!=null){
            throw new CustomException("请勿重复选课");
        }
        //2. 未重复则添加
        studentCourseMapper.insert(studentCourse);
    }

    /*
    * 分页查询
    * */
    public PageInfo<StudentCourse> selectByPage(Integer pageNum, Integer pageSize, StudentCourse studentCourse) {
        PageHelper.startPage(pageNum,pageSize);
        List<StudentCourse> studentCourseList=studentCourseMapper.selectByAll(studentCourse);
        return PageInfo.of(studentCourseList);
    }

    /*
    * 删除选择课程
    * */
    public void deleteById(Integer id) {
        studentCourseMapper.deleteById(id);
    }
}
