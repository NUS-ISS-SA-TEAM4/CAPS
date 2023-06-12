package com.master.caps.Controller;
import com.master.caps.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // 获取所有学生
    @GetMapping("/students")
    public Model getAllStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return model;
    }

    // 获取单个学生
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) throws Exception {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new Exception("Student not found with id: " + id));
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // 创建学生
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentRepository.save(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    // 更新学生
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) throws Exception {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new Exception("Student not found with id: " + id));

        student.setName(updatedStudent.getName());
        student.setMatricNo(updatedStudent.getMatricNo());
        student.setGender(updatedStudent.getGender());
        student.setYob(updatedStudent.getYob());
        student.setGrade(updatedStudent.getGrade());
        student.setGpa(updatedStudent.getGpa());
        student.setRegisteringStatus(updatedStudent.getRegisteringStatus());
        student.setProgramId(updatedStudent.getProgramId());
        student.setCourseId(updatedStudent.getCourseId());

        Student updatedStudentEntity = studentRepository.save(student);
        return new ResponseEntity<>(updatedStudentEntity, HttpStatus.OK);
    }

    // 删除学生
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) throws Exception {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new Exception("Student not found with id: " + id));

        studentRepository.delete(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

interface StudentRepository extends JpaRepository<Student, Long> {
}


