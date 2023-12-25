package com.example.springboot.controller;/*
 *ClassName:StudentCourseController
 *Description: student enroll courses
 *@Author:deanzhou
 *@Date:2023-12-24 18:14
 */

import com.example.springboot.common.Result;
import com.example.springboot.entity.StudentCourse;
import com.example.springboot.service.StudentCourseService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/StudentCourse")
public class StudentCourseController {
    @Resource
    private StudentCourseService studentCourseService;

    /*
    * student enroll courses
    * */
    @PostMapping("/add")
    public Result add(StudentCourse studentCourse){
         studentCourseService.add(studentCourse);
        return Result.success();
    }

    /*
    *  分页查询(学生选课情况)
    * */
    @GetMapping("/selectByPage")
    public Result selectByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "5") Integer pageSize,
                               StudentCourse studentCourse){
        PageInfo<StudentCourse> pageInfo=studentCourseService.selectByPage(pageNum,pageSize,studentCourse);
        return Result.success(pageInfo);
    }

    /*
     * 删除课程
     * */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        studentCourseService.deleteById(id);
        return Result.success();
    }
}
