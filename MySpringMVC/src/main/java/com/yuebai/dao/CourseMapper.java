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
    List<Map<String,Object>> findCourAndAmyNameByID(Integer id);

    List<Map<String,Object>> findCourAndAmyNameByName(String name);

    List<Map<String,Object>> allCourAndAmyName();

    Course findCourByID(Integer id);

    List<Course> findCourByAID(Integer aid);

    List<Course> findCourByName(String name);

    void addCourInfo(Course course);

    void changeCourInfo(Course course);

    void deleteCourInfoByID(Integer ID);
}

