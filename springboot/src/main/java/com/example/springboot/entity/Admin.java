package com.example.springboot.entity;/*
 *ClassName:Admin
 *Description: admin entity
 *@Author:deanzhou
 *@Date:2023-12-21 00:10
 */

public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Admin() {
    }

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
}
