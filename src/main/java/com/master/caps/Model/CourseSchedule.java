package com.master.caps.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "course_schedule")
public class CourseSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "classroomid")
    private Classroom classroom;

    public CourseSchedule(Course course, Schedule schedule, Classroom classroom) {
        this.course = course;
        this.schedule = schedule;
        this.classroom = classroom;
    }

    public CourseSchedule() {

    }
}
