package com.master.caps.Repository;

import com.master.caps.Model.CourseStudent;
import com.master.caps.Model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CourseStudentRepository extends JpaRepository<CourseStudent, Integer> {

    List<CourseStudent> findByStudent(Student student);
}