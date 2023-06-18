package com.master.caps.Controller;

import com.master.caps.Model.Faculty;
import com.master.caps.Repository.IRepository;
import com.master.caps.Service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public List<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable Integer id) throws Exception {
        return facultyService.getFacultyById(id);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping("/{id}")
    public Faculty updateFaculty(@PathVariable Integer id, @RequestBody Faculty updatedFaculty) throws Exception {
        return facultyService.updateFaculty(id, updatedFaculty);
    }

    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable Integer id) {
        facultyService.deleteFaculty(id);
    }
}
