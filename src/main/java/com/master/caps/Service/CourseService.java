// package com.master.caps.Service;

// import com.master.caps.Model.Course;
// import com.master.caps.Repository.CourseRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class CourseService {

//     private final CourseRepository courseRepository;

//     @Autowired
//     public CourseService(CourseRepository courseRepository) {
//         this.courseRepository = courseRepository;
//     }

//     public List<Course> getAllCourses() {
//         return courseRepository.findAll();
//     }

//     public Course getCourseById(Integer id) throws Exception {
//         return courseRepository.findById(id)
//                 .orElseThrow(() -> new Exception("Course not found with id: " + id));
//     }

//     public Course createCourse(Course course) {
//         return courseRepository.save(course);
//     }

//     public Course updateCourse(Integer id, Course updatedCourse) throws Exception {
//         Course course = courseRepository.findById(id)
//                 .orElseThrow(() -> new Exception("Course not found with id: " + id));

//         course.setCourseid(updatedCourse.getCourseid());
//         course.setCoursename(updatedCourse.getCoursename());
//         course.setCoursecredits(updatedCourse.getCoursecredits());
//         course.setCoursecapacity(updatedCourse.getCoursecapacity());
//         course.setCoursevacancy(updatedCourse.getCoursevacancy());
//         course.setCourseenrollmentstatus(updatedCourse.getCourseenrollmentstatus());

//         return courseRepository.save(course);
//     }

//     public void deleteCourse(Integer id) {
//         courseRepository.deleteById(id);
//     }
// }

