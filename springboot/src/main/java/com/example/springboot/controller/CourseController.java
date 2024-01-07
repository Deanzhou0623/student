package com.example.springboot.controller;/*
 *ClassName:CourseController
 *Description: course contrtoller
 *@Author:deanzhou
 *@Date:2023-12-21 14:09
 */

import com.example.springboot.common.Result;
import com.example.springboot.entity.Course;
import com.example.springboot.service.CourseService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Resource
    private CourseService courseService;

    /*
    * 分页条件查询
    * */
    @PostMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "5")  Integer pageSize,
                             @RequestBody Course course){
        //返回课程和总数
        PageInfo<Course> coursePageInfo = courseService.selectPage(pageNum, pageSize,course);
        return Result.success(coursePageInfo);
    }

    /*
    * 添加课程
    * */
    @PostMapping("/add")
    public Result add(@RequestBody Course course){
        courseService.add(course);
        return Result.success();
    }

    /*
     * 编辑课程
     * */
    @PutMapping("/update")
    public Result update(@RequestBody Course course){
        courseService.updateById(course);
        return Result.success();
    }

    /*
    * 删除课程
    * */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        courseService.deleteById(id);
        return Result.success();
    }
}
