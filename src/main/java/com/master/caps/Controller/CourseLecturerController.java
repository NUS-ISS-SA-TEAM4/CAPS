package com.master.caps.Controller;

import com.master.caps.Model.Course;
import com.master.caps.Model.CourseLecturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course-lecturers")
public class CourseLecturerController {

    private final IRepository<CourseLecturer> courseLecturerRepository;

    @Autowired
    public CourseLecturerController(IRepository<CourseLecturer> courseLecturerRepository) {
        this.courseLecturerRepository = courseLecturerRepository;
    }

    // 获取所有课程讲师关联
    @GetMapping
    public ResponseEntity<List<CourseLecturer>> getAllCourseLecturers() {
        List<CourseLecturer> courseLecturers = courseLecturerRepository.findAll();
        return new ResponseEntity<>(courseLecturers, HttpStatus.OK);
    }

    // 获取单个课程讲师关联
    @GetMapping("/{id}")
    public ResponseEntity<CourseLecturer> getCourseLecturerById(@PathVariable Integer id) {
        Optional<CourseLecturer> optionalCourseLecturer = courseLecturerRepository.findById(id);
        if (optionalCourseLecturer.isPresent()) {
            CourseLecturer courseLecturer = optionalCourseLecturer.get();
            return new ResponseEntity<>(courseLecturer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 创建课程讲师关联
    @PostMapping
    public ResponseEntity<CourseLecturer> createCourseLecturer(@RequestBody CourseLecturer courseLecturer) {
        CourseLecturer createdCourseLecturer = courseLecturerRepository.save(courseLecturer);
        return new ResponseEntity<>(createdCourseLecturer, HttpStatus.CREATED);
    }

    // 更新课程讲师关联
    @PutMapping("/{id}")
    public ResponseEntity<CourseLecturer> updateCourseLecturer(@PathVariable Integer id, @RequestBody CourseLecturer courseLecturer) {
        Optional<CourseLecturer> optionalCourseLecturer = courseLecturerRepository.findById(id);
        if (optionalCourseLecturer.isPresent()) {
            CourseLecturer existingCourseLecturer = optionalCourseLecturer.get();
            existingCourseLecturer.setCourse(courseLecturer.getCourse());
            existingCourseLecturer.setLecturer(courseLecturer.getLecturer());
            CourseLecturer updatedCourseLecturer = courseLecturerRepository.save(existingCourseLecturer);
            return new ResponseEntity<>(updatedCourseLecturer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 删除课程讲师关联
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseLecturer(@PathVariable Integer id) {
        Optional<CourseLecturer> optionalCourseLecturer = courseLecturerRepository.findById(id);
        if (optionalCourseLecturer.isPresent()) {
            courseLecturerRepository.delete(optionalCourseLecturer.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


