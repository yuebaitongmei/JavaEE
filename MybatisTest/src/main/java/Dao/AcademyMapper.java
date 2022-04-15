package Dao;

import POJO.Academy;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AcademyMapper {
    @Select("select * from s_academy where id = #{id}")
    Academy findAmyByID02(int id);

    @Select(" select * from s_academy where academyname like concat('%',#{academyname},'%')")
    Academy findAmyByName02(String name);

    @Insert(" insert into s_academy(id,academyname) values (#{id}, #{AcademyName})")
    void addAmyInfo02(Academy academy);

    @Update(" update s_academy set academyname=#{AcademyName} where id=#{id}")
    void changeAmyInfo02(Academy academy);

    @Delete(" delete  from  s_academy  where id=#{id}")
    void deleteAmyInfoByID02(int id);

    @Delete(" delete  from  s_academy  where academyname=#{AcademyName}")
    void deleteAmyInfoByName02(String name);
}
