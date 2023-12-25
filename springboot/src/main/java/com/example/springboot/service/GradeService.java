package com.example.springboot.service;/*
 *ClassName:GradeService
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-24 19:53
 *@Param: $ $
 *@Param: $ $
 *@Return: $
 */

import com.example.springboot.entity.Grade;
import com.example.springboot.exception.CustomException;
import com.example.springboot.mapper.GradeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GradeService {

    @Resource
    private GradeMapper gradeMapper;

    public void add(Grade grade){
        //1. 是否已经打过分
        Grade studentGrade=gradeMapper.selectByCondition(grade);
        if (studentGrade!=null){
            throw new CustomException("已经打过分，请勿重复打分");
        }
        //2. 添加到成绩表
        gradeMapper.insert();
    }

    /*
    * 分页查询
    * */
    public PageInfo<Grade> selectPage(Integer pageNum, Integer pageSize, Grade grade) {
        PageHelper.startPage(pageNum,pageSize);
        List<Grade> list= gradeMapper.selectAll(grade);
        return PageInfo.of(list);
    }

    /*
    * 根据id删除
    * */
    public void deleteById(Integer id) {
        gradeMapper.deleteById(id);
    }

    public void update(Grade grade) {
        gradeMapper.updateById(grade);
    }
}
