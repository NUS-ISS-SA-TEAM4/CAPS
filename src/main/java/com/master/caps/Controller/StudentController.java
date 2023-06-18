package com.master.caps.Controller;

import com.master.caps.Model.Faculty;
import com.master.caps.Model.Student;
import com.master.caps.Repository.StudentRepository;
import com.master.caps.Service.StudentService;
// import com.master.caps.Service.StudentServiceImp;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            List<Student> students = studentService.getStudentList();
           
            
            // if (students.isEmpty()) {
            //     System.out.println("Empty content");
            // }
            return new ResponseEntity<>(students, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
    // try {
    // Optional<Student> optionalStudent = studentRepository.findById(id);
    // if (optionalStudent.isPresent()) {
    // Student student = optionalStudent.get();
    // return new ResponseEntity<>(student, HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // get student details by Id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) throws Exception {
        try {

            Student student = studentRepository.findById(id).orElse(null);
            if (student != null) {

                return new ResponseEntity<>(student, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new Exception("Student not found with id: " + id);
        }
    }

    // .orElseThrow(() -> new Exception("Student not found with id: " + id));
    // return new ResponseEntity<>(student, HttpStatus.OK);
    // }

    // // 创建学生
    // @Operation(summary = "Create new student", description = "Create a new announcement")
    // @PostMapping("/students")
    // public ResponseEntity<Student> createStudent(@RequestBody Student student) {
    //     Student createdStudent = studentRepository.save(student);
    //     return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    // }

    // 创建学生
    @PostMapping
public ResponseEntity<Student> createStudent() {
    Student student =new Student();
    student.setFirstname("John1");
    student.setLastname("Doe");
    student.setGender("Male");
    // student.setBirthday(new Date());
    student.setUsername("johndoe");
    student.setPassword("password");
    student.setSurname("Doe");
    student.setEmail("johndoe@example.com");
    student.setAddress("123 Main St");
    student.setContactnumber("123456789");
    // student.setEnrollmentdate(new Date(System.currentTimeMillis()));
    student.setGpa(3.5f);
    
    try {
        // student.setStudentfaculty(studentService.FindStudentfaculty(1));
        Student createdStudent = studentRepository.save(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}



    // 更新学生
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent)
            throws Exception {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new Exception("Student not found with id: " + id));

        student.setFirstname(updatedStudent.getFirstname());
        student.setLastname(updatedStudent.getLastname());
        student.setGender(updatedStudent.getGender());
        student.setBirthday(updatedStudent.getBirthday());
        student.setGpa(updatedStudent.getGpa());
        student.setEnrollmentdate(updatedStudent.getEnrollmentdate());
        student.setUsername(updatedStudent.getUsername());
        student.setPassword(updatedStudent.getPassword());
        student.setStudentfaculty(updatedStudent.getStudentfaculty());
        student.setSurname(updatedStudent.getSurname());
        student.setContactnumber(updatedStudent.getContactnumber());
        student.setAddress(updatedStudent.getAddress());
        student.setEmail(updatedStudent.getEmail());
        Student updatedStudentEntity = studentRepository.save(student);
        return new ResponseEntity<>(updatedStudentEntity, HttpStatus.OK);
    }

    // 删除学生
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) throws Exception {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new Exception("Student not found with id: " + id));

        studentRepository.delete(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
