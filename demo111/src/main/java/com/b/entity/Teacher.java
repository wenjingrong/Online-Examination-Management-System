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
public class Teacher {
    private String tid;
    private String tpassword;
    private String tname;
    private String tgender;
    private String tphonenum;
    private String tcollege;
    private List<Course> tcourses;
}