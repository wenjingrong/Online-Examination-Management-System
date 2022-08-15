package com.b.service;

import com.b.dao.StudentDAO;
import com.b.entity.Course;
import com.b.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDAO studentDAO;

    @Override//表明这是父类方法的重写
    @Transactional(propagation = Propagation.SUPPORTS)
    public Student login(String id, String password) {
        return studentDAO.login(id, password);
    }

    @Override
    public Student find_info(String sid) {
        return studentDAO.find_info(sid);
    }

    @Override
    public String find_name(String sid) {
        return studentDAO.find_name(sid);
    }

    @Override
    public void update1(String sphonenum,String spassword,String sid) {
        studentDAO.update1(sphonenum,spassword,sid);
    }

    public void update2(String sid,String chooseid,String cid) {
        studentDAO.update2(sid,chooseid,cid);
    }

    @Override
    public List<Course> find_cour() {
        return studentDAO.find_cour();
    }
}
