package com.b.service;

import com.b.entity.Question;
import com.b.entity.TestPaper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestPaperService {
    List<TestPaper> show(String tid);
    void add(TestPaper testPaper);
    void update_totalscore(List<Question> questions,String cid,String testid);
    TestPaper find_teatpaper(String cid,String testid);
    List<TestPaper> find_stu_test(String sid);
}
