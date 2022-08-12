package com.b.service;

import com.b.entity.Exam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamService {
    int show(String sid,String cid);
    void submit(Exam exam);
    List<Exam> find(String sid,String cid);
    List<Exam> teacher_find();
}
