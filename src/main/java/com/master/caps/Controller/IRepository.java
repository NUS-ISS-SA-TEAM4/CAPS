package com.master.caps.Controller;

import com.master.caps.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository<T> extends JpaRepository<T, Long> {
}
