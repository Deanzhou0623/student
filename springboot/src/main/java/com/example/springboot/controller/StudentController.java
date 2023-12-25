package com.example.springboot.controller;/*
 *ClassName:StudentController
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-23 14:14
 */

import com.example.springboot.common.Result;
import com.example.springboot.entity.Student;
import com.example.springboot.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    /*
    * 添加学生(管理员权限)
    * */
    @PostMapping("/add")
    public Result add(@RequestBody Student student){
        studentService.add(student);
        return Result.success();
    }

    /*
    * 删除学生(管理员权限)
    * */
    @DeleteMapping("/delete/{id}")
     public Result delete(@PathVariable Integer id){
       studentService.deleteById(id);
       return Result.success();
     }
    /*
     * 修改学生信息(管理员权限)
     * */
    @PutMapping("/update/{id}")
    public Result update(@RequestBody Student student){
        studentService.updateById(student);
        return Result.success();
    }
    /*
     * 查询学生信息(管理员权限)
     * */

    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             Student student){
         PageInfo<Student> pageInfo = studentService.selectPage(pageNum,pageSize,student);
        return Result.success(pageInfo);
    }
}
