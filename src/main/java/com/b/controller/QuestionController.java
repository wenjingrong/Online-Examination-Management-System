package com.b.controller;

import com.b.entity.Id2;
import com.b.entity.Id3;
import com.b.entity.Question;
import com.b.service.QuestionService;
import com.b.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teacher/show")
@CrossOrigin(origins ="*",maxAge=3600)
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TestPaperService testPaperService;

    @PostMapping("/find_ques")//get
    @ResponseBody
    public List<Question> find_ques(@RequestBody Id2 id2) {
        System.out.println(id2);
        return questionService.find_ques(id2.getId_1(),id2.getId_2());
    }

    @PostMapping("/add_ques")
    @ResponseBody
    public int add_ques(@RequestBody Question question) {
        System.out.println(question);
        questionService.add_ques(question);
        testPaperService.update_totalscore(questionService.find_ques(question.getCid(),question.getTestid()),question.getCid(),question.getTestid());
        return 200;
    }

    @DeleteMapping("/delete_ques")
    @ResponseBody
    public int delete_ques(@RequestBody Id3 id3) {
        questionService.delete_ques(id3.getId_1(),id3.getId_2(),id3.getId_3());
        testPaperService.update_totalscore(questionService.find_ques(id3.getId_1(),id3.getId_2()),id3.getId_1(),id3.getId_2());
        return 200;
    }

    @PutMapping("/change_ques")
    @ResponseBody
    public int change_ques(@RequestBody Question question) {
        questionService.change_ques(question);
        testPaperService.update_totalscore(questionService.find_ques(question.getCid(),question.getTestid()),question.getCid(),question.getTestid());
        return 200;
    }

    @PostMapping("/find_single_ques")//get
    @ResponseBody
    public Question find_single_ques(@RequestBody Id3 id3) {
        System.out.println(id3);
        return questionService.find_single_ques(id3.getId_1(),id3.getId_2(),id3.getId_3());
    }
}