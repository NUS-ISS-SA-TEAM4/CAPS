package com.master.caps.Controller;

import com.master.caps.Model.Lecturer;
import com.master.caps.Service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LecturerController {

    private final LecturerService lecturerService;
    @Autowired
    public LecturerController(LecturerService lecturerService)
    {
        this.lecturerService = lecturerService;
    }

    @GetMapping("/lecturers")
    public Model getAllLecturers(Model model)
    {
        List<Lecturer> lecturers = lecturerService.getAllLecturers();
        model.addAttribute("lecturers",lecturers);
        return model;
    }
    // get the list of all lecturers

    @GetMapping("/{id}")
    public ResponseEntity<Lecturer> getLecturerById(@PathVariable Integer id)throws Exception
    {
        Lecturer lecturer = lecturerService.getLecturerById(id);
        return new ResponseEntity<>(lecturer, HttpStatus.OK);
    }
    /*
    //get the lecturer whose id is xxx
    @PutMapping("/{id}")
    public ResponseEntity<Lecturer> updateLecturer(@PathVariable Integer id, @RequestBody Lecturer updatedLecturer) throws Exception {
        Lecturer lecturer = lecturerService.getLecturerById(id);

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
        Lecturer updatedLecturerEntity = lecturerService.
        return new ResponseEntity<>(updatedLecturerEntity, HttpStatus.OK);
    }
    //update the information of lecturer whose id is xxx
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLecturer(@PathVariable Integer id)
    {
       Lecturer lecturer = lecturerService.findById(id).orElseThrow(()-> new RuntimeException("Lecturer not found with id: \" + id"));
       lecturerService.delete(lecturer);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    */
}

