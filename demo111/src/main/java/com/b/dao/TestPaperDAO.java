package com.b.dao;

import com.b.entity.TestPaper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestPaperDAO {
    List<TestPaper> show();
    void add(TestPaper testPaper);
    void update_totalscore(String cid,String testid,String totalscore);
    TestPaper find_testpaper(String cid,String testid);
    List<TestPaper> find_stu_test(String sid);
}
