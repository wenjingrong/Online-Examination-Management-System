package com.b.dao;

import com.b.entity.Course;
import com.b.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


//持久层dao接口，定义操作数据库方法
@Mapper
public interface StudentDAO {
    //    Student login(@Param("sid") String sid, @Param("spassword") String spassword);
    Student login(String id,String password);

    void update1(String sphonenum,String spassword,String sid);

    void update2(String sid,String chooseid,String cid);

    Student find_info(String sid);

    List<Course> find_cour();

    String find_name(String sid);
}
