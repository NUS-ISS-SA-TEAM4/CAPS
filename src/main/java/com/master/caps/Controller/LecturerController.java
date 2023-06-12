package com.master.caps.Controller;

import com.master.caps.Model.Lecturer;
import com.master.caps.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LecturerController {
    @Autowired
    private final LecturerRepository lecturerRepository;

    public LecturerController(LecturerRepository lecturerRepository)
    {
        this.lecturerRepository = lecturerRepository;
    }

    @GetMapping("/lecturers")
    public Model getAllLecturers(Model model)
    {
        List<Lecturer> lecturers = lecturerRepository.findAll();
        model.addAttribute("lecturers",lecturers);
        return model;
    }
    // get the list of all lecturers

    @GetMapping("/{id}")
    public ResponseEntity<Lecturer> getLecturerById(@PathVariable Long id)throws Exception
    {
        Lecturer lecturer = lecturerRepository.findById(id).orElseThrow(()->new Exception("Lecturer not found with id:"+id));
        return new ResponseEntity<>(lecturer, HttpStatus.OK);
    }
    //get the lecturer whose id is xxx
    @PutMapping("/{id}")
    public ResponseEntity<Lecturer> updateLecturer(@PathVariable Long id, @RequestBody Lecturer updatedLecturer) throws Exception {
        Lecturer lecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new Exception("Student not found with id: " + id));

        lecturer.setLecturerusername(updatedLecturer.getLecturerusername());
        lecturer.setLecturerbirthday(updatedLecturer.getLecturerbirthday());
        lecturer.setLecturergender(updatedLecturer.getLecturergender());
        lecturer.setLecturerfaculty(updatedLecturer.getLecturerfaculty());
        lecturer.setLecturerfirstname(updatedLecturer.getLecturerfirstname());
        lecturer.setLecturerlastname(updatedLecturer.getLecturerlastname());
        lecturer.setLecturerpassword(updatedLecturer.getLecturerpassword());

        Lecturer updatedLecturerEntity = lecturerRepository.save(lecturer);
        return new ResponseEntity<>(updatedLecturerEntity, HttpStatus.OK);
    }
    //update the information of lecturer whose id is xxx
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLecturer(@PathVariable Long id) throws Exception
    {
       Lecturer lecturer = lecturerRepository.findById(id).orElseThrow(()-> new RuntimeException("Lecturer not found with id: \" + id"));
       lecturerRepository.delete(lecturer);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
    //delete the student whose id is xxx
interface LecturerRepository extends JpaRepository<Lecturer,Long>{}
