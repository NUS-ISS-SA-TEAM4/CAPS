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
    private final LecturerxRepository lecturerRepository;

    public LecturerController(LecturerxRepository lecturerRepository)
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

        lecturer.setUsername(updatedLecturer.getUsername());
        lecturer.setBirthday(updatedLecturer.getBirthday());
        lecturer.setGender(updatedLecturer.getGender());
        lecturer.setFaculty(updatedLecturer.getFaculty());
        lecturer.setFirstname(updatedLecturer.getFirstname());
        lecturer.setLastname(updatedLecturer.getLastname());
        lecturer.setPassword(updatedLecturer.getPassword());
        lecturer.setSurname(updatedLecturer.getSurname());
        lecturer.setAddress(updatedLecturer.getAddress());
        lecturer.setContactnumber(updatedLecturer.getContactnumber());
        lecturer.setEmail(updatedLecturer.getEmail());
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
interface LecturerxRepository extends JpaRepository<Lecturer,Long>{}
