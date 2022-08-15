package com.b.dao;

import com.b.entity.Exam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamDAO {
    int show(String sid,String cid);
    void submit(Exam exam);
    List<Exam> find(String sid,String cid);
    List<Exam> teacher_find();
}
