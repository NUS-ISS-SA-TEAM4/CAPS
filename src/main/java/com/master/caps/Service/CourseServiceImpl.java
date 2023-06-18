package com.master.caps.Service;

import com.master.caps.Model.Course;
import com.master.caps.Model.Lecturer;
import com.master.caps.Repository.CourseRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id) throws Throwable {
        return (Course) courseRepository.findById(id).orElseThrow(()->new Exception("Course not found with id:"+id));
    }

    @Override
    public Course create(Course course) {
        return (Course) courseRepository.saveAndFlush(course);
    }

    @Override
    public Course update(Course course) {
        return (Course) courseRepository.saveAndFlush(course);
    }

    @Override
    public void delete(Course course) {
        courseRepository.delete(course);
    }
}
