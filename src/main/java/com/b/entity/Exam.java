package com.b.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Exam {
    String sid;
    String sname;
    String cid;
    String cname;
    String scollege;
    String testid;
    String examDate;
    int score;
    int totalscore;
}
