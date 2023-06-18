// package com.master.caps.Service;

// import com.master.caps.Model.CourseLecturer;
// import com.master.caps.Repository.CourseLecturerRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class CourseLecturerService {

//     private final CourseLecturerRepository courseLecturerRepository;

//     @Autowired
//     public CourseLecturerService(CourseLecturerRepository courseLecturerRepository) {
//         this.courseLecturerRepository = courseLecturerRepository;
//     }

//     public List<CourseLecturer> getAllCourseLecturers() {
//         return courseLecturerRepository.findAll();
//     }

//     public CourseLecturer getCourseLecturerById(Integer id) throws Exception {
//         return courseLecturerRepository.findById(id)
//                 .orElseThrow(() -> new Exception("Course lecturer not found with id: " + id));
//     }

//     public CourseLecturer createCourseLecturer(CourseLecturer courseLecturer) {
//         return courseLecturerRepository.save(courseLecturer);
//     }

//     public CourseLecturer updateCourseLecturer(Integer id, CourseLecturer updatedCourseLecturer) throws Exception {
//         CourseLecturer courseLecturer = courseLecturerRepository.findById(id)
//                 .orElseThrow(() -> new Exception("Course lecturer not found with id: " + id));

//         courseLecturer.setCourse(updatedCourseLecturer.getCourse());
//         courseLecturer.setLecturer(updatedCourseLecturer.getLecturer());

//         return courseLecturerRepository.save(courseLecturer);
//     }

//     public void deleteCourseLecturer(Integer id) {
//         courseLecturerRepository.deleteById(id);
//     }
// }
