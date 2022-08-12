package com.b.service;

import com.b.dao.TestPaperDAO;
import com.b.entity.Question;
import com.b.entity.TestPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Service
//@Transactional
@Component
@Repository
public class TestPaperServiceImpl implements TestPaperService{

    @Autowired
    private TestPaperDAO testPaperDAO;

    @Override
    public List<TestPaper> show() {
        return testPaperDAO.show();
    }

    @Override
    public void add(TestPaper testPaper) {
        testPaperDAO.add(testPaper);
    }

    @Override
    public void update_totalscore(List<Question> questions,String cid,String testid) {
        int totalscore=0;
        for (Question question:questions) {
            totalscore+=question.getScore();
        }
        testPaperDAO.update_totalscore(cid,testid,Integer.toString(totalscore));
    }

    @Override
    public TestPaper find_teatpaper(String cid, String testid) {
        return testPaperDAO.find_testpaper(cid,testid);
    }

    @Override
    public List<TestPaper> find_stu_test(String sid) {
        return testPaperDAO.find_stu_test(sid);
    }


}
