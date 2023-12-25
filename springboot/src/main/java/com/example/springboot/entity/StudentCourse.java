package com.example.springboot.entity;/*
 *ClassName:StudentCourse
 *Description: 学生选课
 *@Author:deanzhou
 *@Date:2023-12-24 18:11
 */

public class StudentCourse {
    private Integer id;
    private String name;
    private String no;
    private Integer studentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
