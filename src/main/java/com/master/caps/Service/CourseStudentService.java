package com.master.caps.Service;

import com.master.caps.Model.CourseStudent;
import com.master.caps.Repository.CourseStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseStudentService {

    private final CourseStudentRepository courseStudentRepository;

    @Autowired
    public CourseStudentService(CourseStudentRepository courseStudentRepository) {
        this.courseStudentRepository = courseStudentRepository;
    }

    public List<CourseStudent> getAllCourseStudents() {
        return courseStudentRepository.findAll();
    }

    public CourseStudent getCourseStudentById(Integer id) throws Exception {
        return courseStudentRepository.findById(id)
                .orElseThrow(() -> new Exception("Course student not found with id: " + id));
    }

    public CourseStudent createCourseStudent(CourseStudent courseStudent) {
        return courseStudentRepository.save(courseStudent);
    }

    public CourseStudent updateCourseStudent(Integer id, CourseStudent updatedCourseStudent) throws Exception {
        CourseStudent courseStudent = courseStudentRepository.findById(id)
                .orElseThrow(() -> new Exception("Course student not found with id: " + id));

        courseStudent.setCourse(updatedCourseStudent.getCourse());
        courseStudent.setStudent(updatedCourseStudent.getStudent());
        courseStudent.setGrade(updatedCourseStudent.getGrade());

        return courseStudentRepository.save(courseStudent);
    }

    public void deleteCourseStudent(Integer id) {
        courseStudentRepository.deleteById(id);
    }
}
