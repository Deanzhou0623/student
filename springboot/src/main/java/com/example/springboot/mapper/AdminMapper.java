package com.example.springboot.mapper;/*
 *ClassName:AdminMapper
 *Description: select admin from database
 *@Author:deanzhou
 *@Date:2023-12-21 00:14
 */

import com.example.springboot.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {

    /*
    *  根据用户名查询用户信息
    * */
    @Select("select * from admin where username=#{username}")
   Admin selectByUsername(@Param("username") String username);
}
