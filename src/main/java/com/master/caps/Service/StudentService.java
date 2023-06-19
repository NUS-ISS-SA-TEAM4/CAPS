package com.master.caps.Service;

import com.master.caps.Model.Student;
import com.master.caps.Repository.FacultyRepository;

import com.master.caps.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id) throws Exception {
        return studentRepository.findById(id)
                .orElseThrow(() -> new Exception("Student not found with id: " + id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Integer id, Student updatedStudent) throws Exception {
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

        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) throws Exception {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new Exception("Student not found with id: " + id));

        studentRepository.delete(student);
    }
}

