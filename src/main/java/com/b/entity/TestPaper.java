package com.b.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TestPaper {
    private String cid;
    private String cname;
    private String testid;
    private String introduction;
    private String grade;
    private String startDate;
    private String duration;
    private int totalScore;
}
