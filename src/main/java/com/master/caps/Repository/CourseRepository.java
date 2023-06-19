package com.master.caps.Repository;

import com.master.caps.Model.Course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {


    //@Query(value = "SELECT * FROM course c where c.coursevacancy>0 and c.id not in (select course_id from course_student where student_id=?1)",  nativeQuery = true)
    //List<Course> findAvailableCourseByStudentId(Integer student_id);
}