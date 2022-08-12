package com.b.service;

import com.b.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    Teacher login(String id, String password);

    //    List<List<String>> find_info(String tid);
    Teacher find_info(String tid);

    void update(String tphonenum,String tpassword,String tid);

    List<String> find_cour(String tid);
}