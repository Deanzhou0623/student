package com.example.springboot.service;/*
 *ClassName:StudentService
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-22 20:49
 */

import cn.hutool.core.util.ObjectUtil;
import com.example.springboot.common.RoleEnum;
import com.example.springboot.entity.Account;
import com.example.springboot.entity.Student;
import com.example.springboot.exception.CustomException;
import com.example.springboot.mapper.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    /*
    * 登入
    * */
    public Account login(Account account){
        Account dbStudent = studentMapper.selectByUsername(account.getUsername());
        //1. 无该用户
        if (dbStudent ==null){
            //没有该用户
            throw new CustomException("用户名或者密码错误");
        }
        //2. 用户名或者密码错误
        if (!dbStudent.getPassword().equals(account.getPassword())){
            throw new CustomException("用户名或者密码错误");
        }
        //3. 登入成功
        return dbStudent;
    }

    
    /*
     * 学生注册
     * */
    @PostMapping("/signUp")
    public void signUp(@RequestBody Account account) {
        Student student = new Student();
        student.setUsername(account.getUsername());
        student.setPassword(account.getPassword());
        this.add(student);
    }

    /*
    * 添加
    * */
    private void add(Student student) {
        //1. 查询学生账号是否重复
        Student dbStudent= studentMapper.selectByUsername(student.getUsername());
        //2. 未查询到学生对象则添加
        if (dbStudent!=null){
            //2.1 已有对象
            throw new CustomException("账号已存在");
        }
        //3.无默认名字
        if (ObjectUtil.isEmpty(student.getName())){
            //username 作为默认名称
            student.setName(student.getUsername());
        }
        student.setRole(RoleEnum.STUDENT.name());
        //4. 插入数据库
        studentMapper.insert(student);
    }


}
