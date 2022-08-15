package com.b.controller;

import com.b.entity.Id;
import com.b.entity.Id3;
import com.b.entity.Teacher;
import com.b.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher")
@CrossOrigin(origins ="*",maxAge=3600)
public class TeacherController {

    @Autowired
    private TeacherService teacherservice;

    @PostMapping("/find_info")
    @ResponseBody
    public Teacher find_info(@RequestBody Id id) {
        System.out.println(id);
        return teacherservice.find_info(id.getId());
    }

    @PutMapping("/find_info/update")
    @ResponseBody
    public int update(@RequestBody Id3 id3) {//tphonenum和tpassword和tid
        System.out.println("========update=====start========");
        System.out.println(id3);
        teacherservice.update(id3.getId_1(),id3.getId_2(),id3.getId_3());
        return 200;
    }

}
