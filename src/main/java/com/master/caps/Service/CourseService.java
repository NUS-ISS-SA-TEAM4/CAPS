package com.master.caps.Service;

import com.master.caps.Model.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourse();
    Course findById(int id) throws Throwable;

    Course create(Course course);

    Course update(Course course);

    void delete(Course course);

}
