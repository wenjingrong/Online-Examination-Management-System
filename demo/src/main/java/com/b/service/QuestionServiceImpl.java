package com.b.service;

import com.b.dao.QuestionDAO;
import com.b.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionDAO questionDAO;

    @Override
    public List<Question> find_ques(String cid,String testid) {
        return questionDAO.find_ques(cid,testid);
    }

    @Override
    public void add_ques(Question question) {
        questionDAO.add_ques(question);
    }

    @Override
    public void delete_ques(String cid,String testid,String qid) {
        questionDAO.delete_ques(cid,testid,qid);
    }

    @Override
    public void change_ques(Question question) {
        questionDAO.change_ques(question);
    }

    @Override
    public Question find_single_ques(String cid, String testid, String qid) {
        return questionDAO.find_single_ques(cid,testid,qid);
    }


}
