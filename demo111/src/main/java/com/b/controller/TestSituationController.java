package com.b.controller;

import com.b.entity.Exam;
import com.b.entity.Id2;
import com.b.service.ExamService;
import com.b.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teacher")
@CrossOrigin(origins ="*",maxAge=3600)
public class TestSituationController {

    @Autowired
    private ExamService examService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/find_situ")
    @ResponseBody
    public List<Exam> teacher_find() {
        return examService.teacher_find();
   }

   @PostMapping("/find_situ/specific")
    @ResponseBody
    public List<Exam> find(@RequestBody Id2 id2) {
        return examService.find(id2.getId_1(),id2.getId_2());
   }
}
