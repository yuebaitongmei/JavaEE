package com.yuebai.service.impl;

import com.yuebai.dao.CourseMapper;
import com.yuebai.domain.Course;
import com.yuebai.imgPath.imgPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuebai.service.CourseService;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
*@Description:课程业务层接口实现类
*@Author:YueBai
*@Date:2022/4/21 20:55
*@Version 1.0
*
*/

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Map<String,Object>> findCourAndAmyNameByID(Integer id) {
        return courseMapper.findCourAndAmyNameByID(id);
    }

    @Override
    public List<Map<String,Object>> findCourAndAmyNameByName(String name) {
        return courseMapper.findCourAndAmyNameByName(name);
    }

    @Override
    public List<Map<String,Object>> allCourAndAmyName() {
        return courseMapper.allCourAndAmyName();
    }

    @Override
    public Course findCourByID(Integer id) {
        return  courseMapper.findCourByID(id);  //基于xml
        //return  courseMapper.findCourByID2(id);  //基于注解
    }

    @Override
    public List<Course> findCourByName(String name){
        return courseMapper.findCourByName(name);  //基于xml
        //return courseMapper.findCourByName02(name);  //基于注解
    }

    @Override
    public List<Course> findCourByAID(Integer aid){
        return courseMapper.findCourByAID(aid);  //基于xml
        //return courseMapper.findCourByAID02(aid);  //基于注解
    }

    @Override
    public void addCourInfo(Course course,MultipartFile file){
        if (file != null){
            // 原始文件名
            String originalFileName = file.getOriginalFilename();
            // 获取图片后缀
            String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
            // 生成图片存储的名称，UUID 避免相同图片名冲突，并加上图片后缀
            String fileName = UUID.randomUUID().toString() + suffix;
            // 图片存储路径
            String filePath = imgPath.ABUSOLUTE_IMG_PATH + fileName;
            File saveFile = new File(filePath);
            // 设置课程的图片文件路径
            course.setImgpath(imgPath.RELATIVE_IMG_PATH + fileName);
            try {
                // 将上传的文件保存到项目目录
                file.transferTo(saveFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
            course.setImgpath(imgPath.RELATIVE_IMG_PATH +"default.png");
        courseMapper.addCourInfo(course);  //基于xml
        //courseMapper.addCourInfo02(course);  //基于注解
    }

    @Override
    public void changeCourInfo(Course course,MultipartFile file){
        if (file != null){
            // 原始文件名
            String originalFileName = file.getOriginalFilename();
            // 获取图片后缀
            String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
            // 生成图片存储的名称，UUID 避免相同图片名冲突，并加上图片后缀
            String fileName = UUID.randomUUID().toString() + suffix;
            // 图片存储路径
            String filePath = imgPath.ABUSOLUTE_IMG_PATH + fileName;
            File saveFile = new File(filePath);
            // 设置课程的图片文件路径
            course.setImgpath(imgPath.RELATIVE_IMG_PATH + fileName);
            try {
                // 将上传的文件保存到项目目录
                file.transferTo(saveFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        courseMapper.changeCourInfo(course);  //基于xml
        //courseMapper.changeCourInfo02(course);  //基于注解
    }

    @Override
    public void deleteCourInfoByID(Integer id){
        courseMapper.deleteCourInfoByID(id);  //基于xml
        //courseMapper.deleteCourInfoByID02(name);  //基于注解
    }

}
