package com.yuebai.dao;

import com.yuebai.domain.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;


public interface CourseMapper {
    /**
    *基于注解
    */
    @Select(" select * from s_course where id = #{id}")
    Course findCourByID02(int id);

    @Select(" select * from s_course where aid = #{aid}")
    Course findCourByAID02(int aid);

    @Select(" select * from s_course where name like concat('%',#{name},'%')")
    Course findCourByName02(String name);

    @Insert("insert into s_course(id,name,hours,aid) values (#{id}, #{name},#{hours},#{aid})")
    void addCourInfo02(Course course);

    @Update(" update s_course set name=#{name}, hours=#{hours}, aid=#{aid} where id=#{id}")
    void changeCourInfo02(Course course);

    @Delete("delete  from  s_course  where id=#{id}")
    void deleteCourInfoByID02(Integer id);

    /**
     *基于xml
     */
    //通过课程ID查询课程及其所属学院名称
    List<Map<String,Object>> findCourAndAmyNameByID(Integer id);
    //通过课程名称查询课程及其所属学院名称
    List<Map<String,Object>> findCourAndAmyNameByName(String name);
    //获取所有课程及其所属学院信息
    List<Map<String,Object>> allCourAndAmyName();
    //通过课程ID获取课程
    Course findCourByID(Integer id);
    //通过学院ID获取课程
    List<Course> findCourByAID(Integer aid);
    //通过课程名称获取课程
    List<Course> findCourByName(String name);
    //添加课程信息
    void addCourInfo(Course course);
    //修改课程信息
    void changeCourInfo(Course course);
    //通过课程ID删除课程信息
    void deleteCourInfoByID(Integer ID);
}

