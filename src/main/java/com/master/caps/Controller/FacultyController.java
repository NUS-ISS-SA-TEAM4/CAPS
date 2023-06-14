package com.master.caps.Controller;

import com.master.caps.Model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

    @Autowired
    private IRepository<Faculty>  facultyRepository;

    @GetMapping
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable Integer id) throws Exception {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new Exception("Faculty not found with id: " + id));
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @PutMapping("/{id}")
    public Faculty updateFaculty(@PathVariable Integer id, @RequestBody Faculty updatedFaculty) throws Exception {
        return facultyRepository.findById(id)
                .map(faculty -> {
                    faculty.setFacultyname(updatedFaculty.getFacultyname());
                    return facultyRepository.save(faculty);
                })
                .orElseThrow(() -> new Exception("Faculty not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable Integer id) {
        facultyRepository.deleteById(id);
    }
}
