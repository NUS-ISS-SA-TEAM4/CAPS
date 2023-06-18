package com.master.caps.Service;

import java.util.List;

import com.master.caps.Model.Lecturer;
public interface LecturerService {

    List<Lecturer> findAllLecturers();
    Lecturer findLecturer(int id) throws Throwable;

    Lecturer createLecturer(Lecturer lec);
    Lecturer changeLecturer(Lecturer lec);
    void removeLecturer(Lecturer lec);
}
