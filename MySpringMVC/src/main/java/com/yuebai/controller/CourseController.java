package com.yuebai.controller;

import com.yuebai.domain.Course;
import com.yuebai.imgPath.imgPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.yuebai.service.CourseService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author:YueBai
 * @Date:2022/4/21 21:22
 * @Version 1.0
 */

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/list")
    public ModelAndView allCourAndAmyName() {
        List<Map<String,Object>> res= courseService.allCourAndAmyName();
        ModelAndView modelAndView = new ModelAndView();
        List<Object> coursesAndAmyName=new ArrayList<>();
        for(Map<String,Object> course:res)
            coursesAndAmyName.add(course);
        modelAndView.setViewName("course");
        modelAndView.addObject("courseList",coursesAndAmyName);
        return modelAndView;
    }


    @RequestMapping("/findCourAndAmyNameByID")
    public ModelAndView findCourAndAmyNameByID(Integer courseID) {
        List<Map<String,Object>> res= courseService.findCourAndAmyNameByID(courseID);
        ModelAndView modelAndView = new ModelAndView();
        List<Object> coursesAndAmyName=new ArrayList<>();
        for(Map<String,Object> course:res)
            coursesAndAmyName.add(course);
        modelAndView.setViewName("course");
        modelAndView.addObject("courseList",coursesAndAmyName);
        return modelAndView;
    }
    @RequestMapping("/findCourAndAmyNameByName")
    public ModelAndView findCourAndAmyNameByID(String courseName) {
        List<Map<String,Object>> res= courseService.findCourAndAmyNameByName(courseName);
        ModelAndView modelAndView = new ModelAndView();
        List<Object> coursesAndAmyName=new ArrayList<>();
        for(Map<String,Object> course : res)
        {
            System.out.println("hahaha");
            coursesAndAmyName.add(course);
            System.out.println(course.get("name"));
        }

        modelAndView.setViewName("course");
        modelAndView.addObject("courseList",coursesAndAmyName);
        return modelAndView;
    }


    @RequestMapping("/findCourByID")
    public ModelAndView findCourByID(Integer courseID) {
        Course course = courseService.findCourByID(courseID);
        ModelAndView modelAndView = new ModelAndView();
        List<Course> courses = new ArrayList<Course>();
        courses.add(course);
        modelAndView.setViewName("course");
        modelAndView.addObject("courseList",courses);
        return modelAndView;
    }
    @RequestMapping("/findCourByName")
    public ModelAndView findCourByName(String courseName) {
        List<Course>  courses = courseService.findCourByName(courseName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("course");
        modelAndView.addObject("courseList", courses);
        return modelAndView;
    }


    @RequestMapping("/toAdd")
    public String toAddCourseInfo() {
        return "courseAdd";
    }
    @ResponseBody
    @RequestMapping("/AddCourInfo")
    public String addCourseInfo(@RequestParam("courPic") MultipartFile courPic,String name,Integer hours,Integer aid) {
        Course course=new Course();
        if(name==""||hours==null||aid==null)
            return "dataError";
        if(courseService.findCourByName(name).size()>0)
            return "exist";
        course.setName(name);
        course.setHours(hours);
        course.setAid(aid);
        courseService.addCourInfo(course,courPic);
        return "success";
    }


    @RequestMapping("/toUpdate")
    public ModelAndView toUpdateCourse(Integer courseID) {
        Course course = courseService.findCourByID(courseID);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("courseUpdate");
        modelAndView.addObject("course",course);
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping("/UpdateCourInfo")
    public String UpdateCourInfo(@RequestParam("courPic") MultipartFile courPic,@RequestParam("oldImgPath") String oldImgPath
            ,Integer id,String name,Integer hours,Integer aid) {
        //删除原图片
        File oldimg=new File(imgPath.ABUSOLUTE_IMG_PATH+oldImgPath.substring(6,oldImgPath.length()));
        oldimg.delete();

        Course course=new Course();
        if(id==null||name==""|| hours==null||aid==null)
            return "dataError";
        Course oldcourse=courseService.findCourByID(id);
        if(!name.equals(oldcourse.getName())&&!oldcourse.getName().contains(name)
                &&courseService.findCourByName(name).size()>0)
            return "exist";
        course.setId(id);
        course.setName(name);
        course.setHours(hours);
        course.setAid(aid);
        courseService.changeCourInfo(course,courPic);
        return "success";
    }


    @RequestMapping("/deleteCourByID")
    public String findCourByName(Integer courseID) {
        courseService.deleteCourInfoByID(courseID);
        return "redirect:/course/list";
    }

}
