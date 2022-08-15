package com.b.controller;

import com.b.entity.*;
import com.b.service.ExamService;
import com.b.service.QuestionService;
import com.b.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
@CrossOrigin(origins ="*",maxAge=3600)
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private TestPaperService testPaperService;

    @Autowired
    private QuestionService questionService;

    @PostMapping("/find_test")
    @ResponseBody
    public List<TestPaper> find_test(@RequestBody Id id) {
        return testPaperService.find_stu_test(id.getId());
    }

    @PostMapping("/find_score")
    @ResponseBody
    public int show(@RequestBody Id2 id2) {
        int a = examService.show(id2.getId_1(),id2.getId_2());
        String b=a+"";
        if("".equals(b)) {
            return -1;
        }else {
            return a;
        }
    }

    @PostMapping("/exam1")//试卷
    @ResponseBody
    private TestPaper find_testpaper(@RequestBody Id2 id2) {
        return testPaperService.find_teatpaper(id2.getId_1(),id2.getId_2());
    }

    @PostMapping("/exam2")//试题
    @ResponseBody
    private List<Question> find_testquestion(@RequestBody Id2 id2) {
        return questionService.find_ques(id2.getId_1(),id2.getId_2());
    }

    @PostMapping("/submit")
    @ResponseBody
    private int submit(@RequestBody Exam exam) {
        examService.submit(exam);
        return 200;
    }

}