package com.master.caps.Controller;

import com.master.caps.Model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final IRepository<Schedule> scheduleRepository;

    @Autowired
    public ScheduleController(IRepository<Schedule> scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // 获取所有课程安排
    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    // 获取单个课程安排
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Integer id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            Schedule schedule = optionalSchedule.get();
            return new ResponseEntity<>(schedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 创建课程安排
    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
        Schedule createdSchedule = scheduleRepository.save(schedule);
        return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);
    }

    // 更新课程安排
    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Integer id, @RequestBody Schedule schedule) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            Schedule existingSchedule = optionalSchedule.get();
            existingSchedule.setScheduledayofweek(schedule.getScheduledayofweek());
            existingSchedule.setSchedulestarttime(schedule.getSchedulestarttime());
            existingSchedule.setScheduleendtime(schedule.getScheduleendtime());
            Schedule updatedSchedule = scheduleRepository.save(existingSchedule);
            return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 删除课程安排
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Integer id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            scheduleRepository.delete(optionalSchedule.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
