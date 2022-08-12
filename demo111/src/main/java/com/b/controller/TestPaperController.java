package com.b.controller;

import com.b.entity.TestPaper;
import com.b.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teacher")
@CrossOrigin(origins ="*",maxAge=3600)
public class TestPaperController {

    @Autowired
    TestPaperService testPaperService;

    //展示所有试卷//按教学课程
    @GetMapping("/show")
    @ResponseBody
    public List<TestPaper> show() {
        System.out.println("=======");
        return testPaperService.show();
    }

    @PostMapping("/add")
    @ResponseBody
    public int add(@RequestBody TestPaper testPaper) {
        System.out.println(testPaper);
        testPaperService.add(testPaper);
        return 200;
    }

}
