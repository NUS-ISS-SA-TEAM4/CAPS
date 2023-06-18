// package com.master.caps.Service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;

// import com.master.caps.Model.Student;
// import com.master.caps.Repository.StudentRepository;

// public class StudentServiceImp {
//     @Autowired
//     StudentRepository studentRepository; 

//     public StudentServiceImp(StudentRepository repo) {
//         this.studentRepository = repo;
//     }



//     @Override
//     public Student saveStudent(Student student) {
//         return studentRepository.save(student);
//     }

//     @Override
//     public List<Student> getStudentList() {
//         return studentRepository.findAll();
//     }
// }
