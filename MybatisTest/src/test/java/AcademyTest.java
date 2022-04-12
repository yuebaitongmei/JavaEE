import POJO.Academy;
import Utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


/**
*@ClassName:Academy
*@Description:学院测试类
*@Author:YueBai
*@Date:2022/4/10 23:15
*@Version 1.0
*
*/
public class AcademyTest {

    /**
    *@Description:通过ID查找学院
    *@Author:YueBai
    *@Date:2022/4/11 22:52
    *@Version 1.0
    *
    */
    @Test
    public void findAmyByID(){
        SqlSession session=MyBatisUtils.getSession();
        Academy academy=session.selectOne("findAmyByID",1);
        System.out.println("学院名称:"+academy.getAcademyName());
        session.close();
    }

    /**
    *@Description:通过名称查找学院
    *@Author:YueBai
    *@Date:2022/4/11 22:52
    *@Version 1.0
    *
    */
    @Test
    public void findAmyByName(){
        SqlSession session=MyBatisUtils.getSession();
        List<Academy> academys=session.selectList("findAmyByName","计算机");
        for (Academy academy:academys)
            System.out.println("学院ID:"+academy.getId()+"学院名称:"+academy.getAcademyName());
        session.close();
    }

    /**
    *@Description:添加学院信息
    *@Author:YueBai
    *@Date:2022/4/11 22:53
    *@Version 1.0
    *
    */
    @Test
    public void addAmyInfo(){
        SqlSession session=MyBatisUtils.getSession();
        Academy academy=new Academy(3,"商学院");
        int res=session.insert("addAmyInfo",academy);
        session.commit();
        if(res==1)
            System.out.println("商学院信息添加成功！");
        else
            System.out.println("添加失败！");
        session.close();
    }

    /**
    *@Description:修改学院信息
    *@Author:YueBai
    *@Date:2022/4/11 22:59
    *@Version 1.0
    *
    */
    @Test
    public void changeAmyInfo(){
        SqlSession session=MyBatisUtils.getSession();
        Academy academy=new Academy(1,"计算机科学与工程学院");
        int res=session.update("changeAmyInfo",academy);
        session.commit();
        if(res==1)
            System.out.println("计算机学院信息修改成功！");
        else
            System.out.println("修改失败！");
        session.close();
    }

    /**
    *@Description:根据ID删除学院信息
    *@Author:YueBai
    *@Date:2022/4/11 23:37
    *@Version 1.0
    *
    */
    @Test
    public void deleteAmyInfoByID(){
        SqlSession session=MyBatisUtils.getSession();
        int res=session.delete("deleteAmyInfoByID",1);
        session.commit();
        if(res==1)
            System.out.println("计算机学院信息删除成功！");
        else
            System.out.println("删除失败！");
        session.close();
    }

    /**
    *@Description:根据名称删除学院信息
    *@Author:YueBai
    *@Date:2022/4/11 23:39
    *@Version 1.0
    *
    */
    @Test
    public void deleteAmyInfoByName(){
        SqlSession session=MyBatisUtils.getSession();
        int res=session.delete("deleteAmyInfoByName","计算机学院");
        session.commit();
        if(res==1)
            System.out.println("计算机学院信息删除成功！");
        else
            System.out.println("删除失败！");
        session.close();
    }

}
