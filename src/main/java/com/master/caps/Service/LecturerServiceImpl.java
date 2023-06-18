package com.master.caps.Service;



import com.master.caps.Model.Lecturer;
import com.master.caps.Repository.LecturerRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {

    @Resource
    private LecturerRepository lecturerRepository;

    @Override
    public List<Lecturer> findAllLecturers() {
        return lecturerRepository.findAll();
    }

    @Override
    public Lecturer findLecturer(int id) throws Throwable {
        return (Lecturer) lecturerRepository.findById(id).orElseThrow(()->new Exception("Lecturer not found with id:"+id));
    }

    @Override
    public Lecturer createLecturer(Lecturer lec) {
        return (Lecturer) lecturerRepository.saveAndFlush(lec);
    }

    @Override
    public Lecturer changeLecturer(Lecturer lec) {
        return (Lecturer) lecturerRepository.saveAndFlush(lec);
    }

    @Override
    public void removeLecturer(Lecturer lec) {
        lecturerRepository.delete(lec);
    }
}
