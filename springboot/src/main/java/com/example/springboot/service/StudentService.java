package com.example.springboot.service;/*
 *ClassName:StudentService
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-22 20:49
 */

import com.example.springboot.entity.Account;
import com.example.springboot.entity.Student;
import com.example.springboot.exception.CustomException;
import com.example.springboot.mapper.StudentMapper;
import org.springframework.stereotype.Service;

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
}
