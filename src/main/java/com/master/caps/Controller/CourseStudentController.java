package com.master.caps.Controller;

import com.master.caps.Model.CourseStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course-students")
public class CourseStudentController {

    private final CourseStudentRepository courseStudentRepository;

    @Autowired
    public CourseStudentController(CourseStudentRepository courseStudentRepository) {
        this.courseStudentRepository = courseStudentRepository;
    }

    // 获取所有课程学生关联
    @GetMapping
    public ResponseEntity<List<CourseStudent>> getAllCourseStudents() {
        List<CourseStudent> courseStudents = courseStudentRepository.findAll();
        return new ResponseEntity<>(courseStudents, HttpStatus.OK);
    }

    // 获取单个课程学生关联
    @GetMapping("/{id}")
    public ResponseEntity<CourseStudent> getCourseStudentById(@PathVariable Long id) {
        Optional<CourseStudent> optionalCourseStudent = courseStudentRepository.findById(id);
        if (optionalCourseStudent.isPresent()) {
            CourseStudent courseStudent = optionalCourseStudent.get();
            return new ResponseEntity<>(courseStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 创建课程学生关联
    @PostMapping
    public ResponseEntity<CourseStudent> createCourseStudent(@RequestBody CourseStudent courseStudent) {
        CourseStudent createdCourseStudent = courseStudentRepository.save(courseStudent);
        return new ResponseEntity<>(createdCourseStudent, HttpStatus.CREATED);
    }

    // 更新课程学生关联
    @PutMapping("/{id}")
    public ResponseEntity<CourseStudent> updateCourseStudent(@PathVariable Long id, @RequestBody CourseStudent courseStudent) {
        Optional<CourseStudent> optionalCourseStudent = courseStudentRepository.findById(id);
        if (optionalCourseStudent.isPresent()) {
            CourseStudent existingCourseStudent = optionalCourseStudent.get();
            existingCourseStudent.setCourse(courseStudent.getCourse());
            existingCourseStudent.setStudent(courseStudent.getStudent());
            existingCourseStudent.setGrade(courseStudent.getGrade());
            CourseStudent updatedCourseStudent = courseStudentRepository.save(existingCourseStudent);
            return new ResponseEntity<>(updatedCourseStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 删除课程学生关联
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseStudent(@PathVariable Long id) {
        Optional<CourseStudent> optionalCourseStudent = courseStudentRepository.findById(id);
        if (optionalCourseStudent.isPresent()) {
            courseStudentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

interface CourseStudentRepository extends JpaRepository<CourseStudent, Long> {
}
