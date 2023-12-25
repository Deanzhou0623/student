package com.example.springboot.entity;/*
 *ClassName:Grade
 *Description: TODO
 *@Author:deanzhou
 *@Date:2023-12-24 19:50
 *@Param: $ $
 *@Param: $ $
 *@Return: $
 */

public class Grade {
    private Integer id;
    private Integer course_id;
    private Integer student_id;
    private Double score;
    private String comment;
    private String feedback;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
