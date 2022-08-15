package com.b.service;

import com.b.dao.TeacherDAO;
import com.b.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherDAO teacherDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Teacher login(String id, String password) {
        return teacherDAO.login(id, password);
    }

    @Override
    public Teacher find_info(String tid) {
        return teacherDAO.find_info(tid);
    }

    @Override
    public void update(String tphonenum,String tpassword,String tid) {
        teacherDAO.update(tphonenum,tpassword,tid);
    }

    @Override
    public List<String> find_cour(String tid) {
        return teacherDAO.find_cour(tid);
    }
}
