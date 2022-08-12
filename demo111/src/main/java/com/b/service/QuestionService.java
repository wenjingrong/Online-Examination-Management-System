package com.b.service;

import com.b.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    List<Question> find_ques(String cid,String testid);

    void add_ques(Question question);

    void delete_ques(String cid,String testid,String qid);

    void change_ques(Question question);

    Question find_single_ques(String cid,String testid,String qid);
}
