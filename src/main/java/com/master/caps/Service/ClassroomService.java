package com.master.caps.Service;

import com.master.caps.Model.Classroom;
import com.master.caps.Repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {
    private ClassroomRepository classroomRepository;

@Autowired
    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<Classroom> getAllClassRoom()
    {
        return classroomRepository.findAll();
    }

}
