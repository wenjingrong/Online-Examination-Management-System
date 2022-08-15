package com.b.controller;

import com.b.entity.Id;
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

    //按教学课程展示试卷
    @PostMapping("/show")
    @ResponseBody
    public List<TestPaper> show(@RequestBody Id id) {
        System.out.println("=======");
        return testPaperService.show(id.getId());
    }

    @PostMapping("/add")//创建试卷（考试）
    @ResponseBody
    public int add(@RequestBody TestPaper testPaper) {
        System.out.println(testPaper);
        testPaperService.add(testPaper);
        return 200;
    }

}
