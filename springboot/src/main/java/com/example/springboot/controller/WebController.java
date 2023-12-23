package com.example.springboot.controller;


import cn.hutool.core.util.ObjectUtil;
import com.example.springboot.common.Result;
import com.example.springboot.common.RoleEnum;
import com.example.springboot.entity.Account;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.Student;
import com.example.springboot.service.AdminService;
import com.example.springboot.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class WebController {

    @Resource
    private AdminService adminService;

    @Resource
    private StudentService studentService;
    /**
     * 默认请求接口
     */
    @GetMapping("/")
    public Result hello() {
        return Result.success();
    }

    /*
    * 登入接口
    * */
    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        //1. 判断是否是 admin
        Account loginRole;
        if (RoleEnum.ADMIN.name().equals(account.getRole())){
            //1.1 管理员登入
            loginRole = adminService.login(account);
        }
        //2. 判断是否是 student
        else if (RoleEnum.STUDENT.name().equals(account.getRole())){
            //2.1 学生登入
            loginRole = studentService.login(account);
        } else {
            return Result.error("角色获取错误");
        }

        return Result.success(loginRole);
    }

    /*
     * 注册接口
     * */
    @PostMapping("/signUp")
    public Result signUp(@RequestBody Account account) {
        //1. 输入校验
        if (ObjectUtil.isEmpty(account.getUsername())||
        ObjectUtil.isEmpty(account.getPassword())) {
            return Result.error("账号密码不能为空");
        }
        studentService.signUp(account);
        return Result.success();
    }
    /*
    * 添加注册信息到数据库
    * */

}
