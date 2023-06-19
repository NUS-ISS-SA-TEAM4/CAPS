package com.master.caps.Repository;

import com.master.caps.Model.CourseSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseScheduleRepository extends JpaRepository<CourseSchedule, Integer> {

}

