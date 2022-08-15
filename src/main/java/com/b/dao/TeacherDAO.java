package com.b.dao;

import com.b.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherDAO {
    Teacher login(String id,String password);
    Teacher find_info(String tid);
    void update(String tphonenum,String tpassword,String tid);
    List<String> find_cour(String tid);
}
