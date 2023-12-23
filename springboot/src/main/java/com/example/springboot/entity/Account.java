package com.example.springboot.entity;/*
 *ClassName:Account
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-22 20:41
 *@Param: $ $
 *@Param: $ $
 *@Return: $
 */

public class Account {
    private String username;
    private String password;
    private String name;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
