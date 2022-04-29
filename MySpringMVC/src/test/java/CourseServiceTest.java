import com.yuebai.domain.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.yuebai.service.CourseService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:spring-mvc.xml", "classpath:spring-dao.xml"})
public class CourseServiceTest {
    @Autowired
    private CourseService courseService;

    @Test
    public void findbookByID(){
        Course course=courseService.findCourByID(1);
        System.out.println("课程ID:"+course.getId()+" 课程名称:"
                +course.getName()+" 课时:"+course.getHours()+" 开设学院:"+ course.getAid());
    }

    @Test
    public void findbookByName(){
        List<Course> courses=courseService.findCourByName("");
        for(Course course : courses)
            System.out.println(course.getName());
    }


}
