package com.master.caps.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "course_student")
public class CourseStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name ="course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name ="student_id")
    private Student student;

    private String Grade;
    private Integer status;
}
