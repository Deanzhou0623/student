package com.example.springboot.entity;/*
 *ClassName:Admin
 *Description: admin entity
 *@Author:deanzhou
 *@Date:2023-12-21 00:10
 */

public class Admin extends Account{
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
