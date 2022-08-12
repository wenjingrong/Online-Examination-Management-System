package com.b.service;

import com.b.entity.Course;
import com.b.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    Student login(String id, String password);

    void update1(String sphonenum,String spassword,String sid);

    void update2(String sid,String chooseid,String cid);

    Student find_info(String sid);

    List<Course> find_cour();

    String find_name(String sid);
}

