package com.b.controller;

import com.b.entity.*;
import com.b.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller//实例化当前类为一个控制器
@RequestMapping("/student")//加入访问路径
@CrossOrigin(origins ="*",maxAge=3600)
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/find_info")//get
    @ResponseBody
    public Student find_info(@RequestBody Id id) {
        System.out.println("================find_info=====start==================");
        System.out.println(id);
        System.out.println(studentService.find_info(id.getId()));
        return studentService.find_info(id.getId());
    }

    @PutMapping("/find_info/update1")
    @ResponseBody
    public int update1(@RequestBody Id3 id3) {//sphonenum和spassword和sid
        System.out.println("========update1=====start========");
        System.out.println(id3);
        studentService.update1(id3.getId_1(),id3.getId_2(),id3.getId_3());
        return 200;
    }

    @PutMapping("/find_info/update2")//选课
    @ResponseBody
    public int update2(@RequestBody Update update) {
        System.out.println("==================update2=====start===============");
        System.out.println(update);
        String[] cids = update.getCid();
        String cid;
        for (int chooseid =1;chooseid<=3;chooseid++) {
            try {
                cid=cids[chooseid-1];
            }catch (ArrayIndexOutOfBoundsException e) {
                cid="10000";
            }
            studentService.update2(update.getSid(),Integer.toString(chooseid),cid);
        }
        return 200;
    }

    @GetMapping("/find_cour")
    @ResponseBody
    public List<Course> find_cour() {
        return studentService.find_cour();
    }
}