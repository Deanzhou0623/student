package com.example.springboot.controller;/*
 *ClassName:GradeController
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-24 19:48
 *@Param: $ $
 *@Param: $ $
 *@Return: $
 */

import com.example.springboot.common.Result;
import com.example.springboot.entity.Grade;
import com.example.springboot.service.GradeService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Resource
    private GradeService gradeService;
    /*
    * add
    */
    @PostMapping("/add")
    public Result add(@RequestBody Grade grade){
         gradeService.add(grade);
         return Result.success();

    }
    /*
    * 分页查询
    * */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue ="1") Integer pageNum,
                             @RequestParam(defaultValue ="5") Integer pageSize,
                             Grade grade){
         PageInfo<Grade> gradeInfo=gradeService.selectPage(pageNum,pageSize,grade);
        return Result.success(gradeInfo);
    }

    /*
    * 删除
    * */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        gradeService.deleteById(id);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Grade grade) {
        gradeService.update(grade);
        return Result.success();
    }
}
