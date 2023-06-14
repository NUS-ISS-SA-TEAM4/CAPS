package com.master.caps.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "course_lecturer")
@Data
public class CourseLecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name ="lecturer_id")
    private Lecturer lecturer;
}
