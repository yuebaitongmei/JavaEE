package com.yuebai.service;

import com.yuebai.domain.Course;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
*@Description:课程业务层接口
*@Author:YueBai
*@Date:2022/4/21 20:55
*@Version 1.0
*
*/
public interface CourseService {


    /**
    *@Description:根据ID获取课程信息及其开设学院名称
    *@Author:YueBai
    *@Date:2022/4/26 17:26
    *@Version 1.0
    *
    */
    public List<Map<String,Object>> findCourAndAmyNameByID(Integer id);

    /**
     *@Description:根据名称获取课程信息及其开设学院名称
     *@Author:YueBai
     *@Date:2022/4/26 17:26
     *@Version 1.0
     *
     */
    public List<Map<String,Object>> findCourAndAmyNameByName(String name);

    /**
     *@Description:所有课程信息及其开设学院名称
     *@Author:YueBai
     *@Date:2022/4/26 17:26
     *@Version 1.0
     *
     */
    public List<Map<String,Object>> allCourAndAmyName();

    /**
    *@Description:根据ID获取课程信息
    *@Author:YueBai
    *@Date:2022/4/24 18:03
    *@Version 1.0
    *
    */
    public Course findCourByID(Integer id);

    /**
    *@Description:根据名称获取课程信息
    *@Author:YueBai
    *@Date:2022/4/24 18:03
    *@Version 1.0
    *
    */
    public List<Course> findCourByName(String name);

    /**
     *@Description:根据学院ID获取课程信息
     *@Author:YueBai
     *@Date:2022/4/24 18:03
     *@Version 1.0
     *
     */
    public List<Course> findCourByAID(Integer aid);

    /**
     *@Description:添加课程信息
     *@Author:YueBai
     *@Date:2022/4/24 18:03
     *@Version 1.0
     *
     */
    public void addCourInfo(Course course,MultipartFile file);

    /**
     *@Description:修改课程信息
     *@Author:YueBai
     *@Date:2022/4/24 18:03
     *@Version 1.0
     *
     */
    public void changeCourInfo(Course course, MultipartFile file);

    /**
     *@Description:根据ID删除课程信息
     *@Author:YueBai
     *@Date:2022/4/24 18:03
     *@Version 1.0
     *
     */
    public void deleteCourInfoByID(Integer ID);
}
