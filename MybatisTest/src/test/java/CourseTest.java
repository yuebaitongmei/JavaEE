import POJO.Academy;
import POJO.Course;
import Utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
*@ClassName:CourseTest
*@Description:课程测试类
*@Author:YueBai
*@Date:2022/4/10 23:28
*@Version 1.0
*
*/
public class CourseTest {
    /**
    *@Description:通过ID查找课程（基于xml和基于注解）
    *@Author:YueBai
    *@Date:2022/4/11 23:41
    *@Version 1.0
    *
    */
    @Test
    public void findCourByID(){
        SqlSession session= MyBatisUtils.getSession();
        Course course=session.selectOne("findCourByID",2);   //xml
//        Course course=session.selectOne("findCourByID02",2);  //注解
        System.out.println("课程ID:"+course.getId()+" 课程名称:"
                +course.getName()+" 课时:"+course.getHours()+"开设学院:"+ course.getAid());
        session.close();
    }

    /**
    *@Description:通过学院ID查找课程（基于xml和基于注解）
    *@Author:YueBai
    *@Date:2022/4/11 23:42
    *@Version 1.0
    *
    */
    @Test
    public void findCourByAID(){
        SqlSession session= MyBatisUtils.getSession();
        List<Course> courses=session.selectList("findCourByAID",1);  //xml
//        List<Course> courses=session.selectList("findCourByAID02",1);  //注解
        for(Course course:courses)
        System.out.println("课程ID:"+course.getId()+" 课程名称:"
                +course.getName()+" 课时:"+course.getHours()+"开设学院:"+ course.getAid());
        session.close();
    }

    /**
    *@Description:通过名称查找课程（基于xml和基于注解）
    *@Author:YueBai
    *@Date:2022/4/11 23:42
    *@Version 1.0
    *
    */
    @Test
    public void findCourByName(){
        SqlSession session= MyBatisUtils.getSession();
        List<Course> courses=session.selectList("findCourByName","英语");  //xml
//        List<Course> courses=session.selectList("findCourByName02","大");  //注解
        for(Course course:courses)
            System.out.println("课程ID:"+course.getId()+" 课程名称:"
                    +course.getName()+" 课时:"+course.getHours()+"开设学院:"+ course.getAid());
        session.close();
    }

    /**
    *@Description:添加课程信息（基于xml和基于注解）
    *@Author:YueBai
    *@Date:2022/4/11 23:51
    *@Version 1.0
    *
    */
    @Test
    public void addCourInfo() {
        SqlSession session=MyBatisUtils.getSession();
        Course course=new Course(5,"大数据存储",32,1);
        int res=session.insert("addCourInfo",course);  //xml
//        int res=session.insert("addCourInfo02",course);  //注解
        session.commit();
        if(res==1)
            System.out.println("课程-大数据存储 信息添加成功！");
        else
            System.out.println("添加失败！");
        session.close();
    }

    /**
    *@Description:修改课程信息（基于xml和基于注解）
    *@Author:YueBai
    *@Date:2022/4/12 0:06
    *@Version 1.0
    *
    */
    @Test
    public void changeCourInfo(){
        SqlSession session=MyBatisUtils.getSession();
        Course course=new Course(1,"C++语言程序设计",70,1);
        int res=session.update("changeCourInfo",course);  //xml
//        int res=session.update("changeCourInfo02",course);  //配置
        session.commit();
        if(res==1)
            System.out.println("课程信息修改成功！");
        else
            System.out.println("修改失败！");
        session.close();
    }

    /**
    *@Description:根据名称删除课程信息（基于xml和基于注解）
    *@Author:YueBai
    *@Date:2022/4/12 0:08
    *@Version 1.0
    *
    */
    @Test
    public void deleteCourInfoByName(){
        SqlSession session=MyBatisUtils.getSession();
        int res=session.delete("deleteCourInfoByName","大数据存储");  //xml
//        int res=session.delete("deleteCourInfoByName02","大数据存储");  //配置
        session.commit();
        if(res==1)
            System.out.println("课程-大数据存储 信息删除成功！");
        else
            System.out.println("删除失败！");
        session.close();
    }
}
