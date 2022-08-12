package com.b.dao;

import com.b.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionDAO {
    List<Question> find_ques(String cid,String testid);
    void add_ques(Question question);
    void delete_ques(@Param("cid") String cid,@Param("testid") String testid, @Param("qid") String qid);
    void change_ques(Question question);
    Question find_single_ques(String cid,String testid,String qid);
}