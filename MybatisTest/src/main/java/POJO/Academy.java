package POJO;

/**
*@ClassName:Academy
*@Description:学院
*@Author:YueBai
*@Date:2022/4/10 22:34
*@Version 1.0
*
*/
public class Academy {
    private int   id;
    private String AcademyName;

    public Academy(int id,String AcademyName){
        this.id=id;
        this.AcademyName=AcademyName;
    }

    public String getAcademyName() {
        return AcademyName;
    }

    public void setAcademyName(String academyName) {
        AcademyName = academyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
