package com.b.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//实体类
public class Student {
    private String sid;
    private String spassword;
    private String sname;
    private String sgender;
    private String sphonenum;
    private String scollege;
    private List<Course> scourses;
}
