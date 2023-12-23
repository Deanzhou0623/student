package com.example.springboot.service;/*
 *ClassName:AdminService
 *Description: login verification
 *@Author:deanzhou
 *@Date:2023-12-21 00:12
 */

import com.example.springboot.entity.Account;
import com.example.springboot.entity.Admin;
import com.example.springboot.exception.CustomException;
import com.example.springboot.mapper.AdminMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
* service 里面写逻辑
* */
@Service
public class AdminService {
    @Resource
    private AdminMapper adminMapper;

    /*
    * 登入功能
    * */
    public Account login(Account account){
        //1. 从数据库得到dbAdmin对象
        Account dbAdmin = adminMapper.selectByUsername(account.getUsername());
        //2.1 dbAdmin 为空 ，则不存在用户
        if (dbAdmin==null){
            //返回错误信息
            throw new CustomException("账号或密码错误");
        }
        //2. 有用户，密码不正确
        if (!dbAdmin.getPassword().equals(account.getPassword())){
            throw new CustomException("账号或密码错误");
        }
        return dbAdmin;
    }
}
