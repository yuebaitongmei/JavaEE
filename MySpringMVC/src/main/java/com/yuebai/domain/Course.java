package com.yuebai.domain;

/**
*@Description:课程实体类
*@Author:YueBai
*@Date:2022/4/21 21:03
*@Version 1.0
*
*/
public class Course {
    private Integer id;
    private String name;
    private Integer hours;
    private Integer aid;
    private String imgpath;




    public Course(){};

    public Course(int id,String name,int hours,int aid){
        this.id=id;
        this.name=name;
        this.hours=hours;
        this.aid=aid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
}
