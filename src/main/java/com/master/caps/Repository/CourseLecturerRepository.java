package com.master.caps.Repository;

import com.master.caps.Model.CourseLecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseLecturerRepository extends JpaRepository<CourseLecturer, Integer> {

}