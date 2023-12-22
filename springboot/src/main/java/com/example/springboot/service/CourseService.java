package com.example.springboot.service;/*
 *ClassName:CourseService
 *Description: course 的业务逻辑
 *@Author:deanzhou
 *@Date:2023-12-21 14:11
 *

 */

import com.example.springboot.entity.Course;
import com.example.springboot.mapper.CourseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseService {

    @Resource
    private CourseMapper courseMapper;

    //total 查询总数 list 查询列表
    public PageInfo<Course> selectPage(Integer pageNum,Integer pageSize,Course course){
        //分页查询  pageNum 当前页码，pageSize每页个数
        PageHelper.startPage(pageNum,pageSize);
        //所以课程对象
        List<Course> courses = courseMapper.selectAll(course);
        return PageInfo.of(courses);
    }

    /*
    * 添加 课程
    * */
    public void add(Course course) {
        courseMapper.insert(course);
    }


    /*
    * 根据id更新数据
    * */
    public void updateById(Course course) {
        courseMapper.updateById(course);
    }

    /*
     * 根据id删除数据
     * */
    public void deleteById(Integer id) {
        courseMapper.deleteById(id);
    }
}
