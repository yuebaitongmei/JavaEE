package Dao;

import POJO.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CourseMapper {
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

    @Delete("delete  from  s_course  where name=#{AcademyName}")
    void deleteCourInfoByName02(String name);
}
