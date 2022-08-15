package com.b.service;

import com.b.dao.ExamDAO;
import com.b.entity.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component//配置一个bean
public class ExamServiceImpl implements ExamService{

    @Autowired
    private ExamDAO examDAO;

    @Override
    public int show(String sid,String cid) {
        return examDAO.show(sid, cid);
    }

    @Override
    public void submit(Exam exam) {
        examDAO.submit(exam);
    }

    @Override
    public List<Exam> find(String sid, String cid) {
        return examDAO.find(sid, cid);
    }

    @Override
    public List<Exam> teacher_find() {
        return examDAO.teacher_find();
    }

}
