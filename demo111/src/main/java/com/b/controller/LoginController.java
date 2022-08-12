package com.b.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.b.entity.Student;
import com.b.entity.Teacher;
import com.b.entity.User;
import com.b.service.StudentService;
import com.b.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

@Controller
@CrossOrigin(origins ="*",maxAge=3600)//跨域
public class LoginController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherservice;

//    @PostMapping("/login")
//    public String login(String id,String password) {
//        System.out.println("login!");
//
//        Student slogin = studentService.login(id, password);
//        Teacher tlogin = teacherservice.login(id, password);
//        if (slogin != null) {
//            return "redirect:/student/find_info";//逻辑名，去找classpath：/templates/逻辑名.html
//        } else if (tlogin != null) {
//            return "redirect:/teacher/find_info";
//        } else {
//            return "redirect:/login";
//        }
//    }

    @PostMapping("/login")
    @ResponseBody
    public User login(@RequestBody User user) {
        System.out.println("===========登录==========");
        Student slogin = studentService.login(user.getUsername(), user.getPassword());
        Teacher tlogin = teacherservice.login(user.getUsername(), user.getPassword());

        String secret = "abcdefg";
        Calendar instance = Calendar.getInstance();//当前时间
        instance.add(Calendar.HOUR,2);//增加两小时
        String token = JWT.create().
                withClaim("userid",user.getUsername()).
                withExpiresAt(instance.getTime()). //令牌过期时间
                sign(Algorithm.HMAC256(secret));//签名
        System.out.println("token:"+token);

        if (slogin != null) {
            user.setRole("2");
            user.setToken(token);
            user.setName(slogin.getSname());
            user.setCollege(slogin.getScollege());
            return user;
        } else if (tlogin != null) {
            user.setRole("1");
            user.setToken(token);
            user.setName(tlogin.getTname());
            user.setCollege(tlogin.getTcollege());
            return user;
        } else {
            System.out.println("登录失败");
            user.setRole("0");
            user.setToken("");
            return user;
        }
    }
}
