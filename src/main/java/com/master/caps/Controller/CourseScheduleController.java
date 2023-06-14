package com.master.caps.Controller;

import com.master.caps.Model.CourseSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course-schedules")
public class CourseScheduleController {

    private final IRepository<CourseSchedule> courseScheduleRepository;

    @Autowired
    public CourseScheduleController(IRepository<CourseSchedule>courseScheduleRepository) {
        this.courseScheduleRepository = courseScheduleRepository;
    }

    // 获取所有课程安排
    @GetMapping
    public ResponseEntity<List<CourseSchedule>> getAllCourseSchedules() {
        List<CourseSchedule> courseSchedules = courseScheduleRepository.findAll();
        return new ResponseEntity<>(courseSchedules, HttpStatus.OK);
    }

    // 获取单个课程安排
    @GetMapping("/{id}")
    public ResponseEntity<CourseSchedule> getCourseScheduleById(@PathVariable Long id) {
        Optional<CourseSchedule> optionalCourseSchedule = courseScheduleRepository.findById(id);
        if (optionalCourseSchedule.isPresent()) {
            CourseSchedule courseSchedule = optionalCourseSchedule.get();
            return new ResponseEntity<>(courseSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 创建课程安排
    @PostMapping
    public ResponseEntity<CourseSchedule> createCourseSchedule(@RequestBody CourseSchedule courseSchedule) {
        CourseSchedule createdCourseSchedule = courseScheduleRepository.save(courseSchedule);
        return new ResponseEntity<>(createdCourseSchedule, HttpStatus.CREATED);
    }

    // 更新课程安排
    @PutMapping("/{id}")
    public ResponseEntity<CourseSchedule> updateCourseSchedule(@PathVariable Long id, @RequestBody CourseSchedule courseSchedule) {
        Optional<CourseSchedule> optionalCourseSchedule = courseScheduleRepository.findById(id);
        if (optionalCourseSchedule.isPresent()) {
            CourseSchedule existingCourseSchedule = optionalCourseSchedule.get();
            existingCourseSchedule.setCourse(courseSchedule.getCourse());
            existingCourseSchedule.setSchedule(courseSchedule.getSchedule());
            existingCourseSchedule.setRoomNumber(courseSchedule.getRoomNumber());
            CourseSchedule updatedCourseSchedule = courseScheduleRepository.save(existingCourseSchedule);
            return new ResponseEntity<>(updatedCourseSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 删除课程安排
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseSchedule(@PathVariable Long id) {
        Optional<CourseSchedule> optionalCourseSchedule = courseScheduleRepository.findById(id);
        if (optionalCourseSchedule.isPresent()) {
            courseScheduleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
