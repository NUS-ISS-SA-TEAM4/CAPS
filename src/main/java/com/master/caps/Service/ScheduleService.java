package com.master.caps.Service;

import com.master.caps.Model.Schedule;
import com.master.caps.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Optional<Schedule> getScheduleById(Integer id) {
        return scheduleRepository.findById(id);
    }

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Optional<Schedule> updateSchedule(Integer id, Schedule schedule) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            Schedule existingSchedule = optionalSchedule.get();
            existingSchedule.setScheduledayofweek(schedule.getScheduledayofweek());
            existingSchedule.setSchedulestarttime(schedule.getSchedulestarttime());
            existingSchedule.setScheduleendtime(schedule.getScheduleendtime());
            return Optional.of(scheduleRepository.save(existingSchedule));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteSchedule(Integer id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            scheduleRepository.delete(optionalSchedule.get());
            return true;
        } else {
            return false;
        }
    }


}