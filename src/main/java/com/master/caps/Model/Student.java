package com.master.caps.Model;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Student{

    @Id
    private Long id;
    private String name;
    private String matricNo;
    private String gender;
    private Integer yob;
    private String grade;
    private Double gpa;
    private String registeringStatus;
    private Long programId;
    private Long courseId;


}
