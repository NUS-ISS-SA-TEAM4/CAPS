package com.master.caps.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.yaml.snakeyaml.events.Event;

@Entity
@Data
@Table(name = "Course_Student")
public class CourseStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name ="course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name ="student_id")
    private Student student;

    private String Grade;
    private Integer status;
}
