package com.master.caps.Service;

import com.master.caps.Model.Course;
import com.master.caps.Model.CourseStudent;
import com.master.caps.Model.Student;
import com.master.caps.Repository.CourseRepository;
import com.master.caps.Repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseStudentService courseStudentService;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Integer id) throws Exception {
        return courseRepository.findById(id)
                .orElseThrow(() -> new Exception("Course not found with id: " + id));
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Integer id, Course updatedCourse) throws Exception {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new Exception("Course not found with id: " + id));

        course.setCourseid(updatedCourse.getCourseid());
        course.setCoursename(updatedCourse.getCoursename());
        course.setCoursecredits(updatedCourse.getCoursecredits());
        course.setCoursecapacity(updatedCourse.getCoursecapacity());
        course.setCoursevacancy(updatedCourse.getCoursevacancy());
        course.setCourseenrollmentstatus(updatedCourse.getCourseenrollmentstatus());

        return courseRepository.save(course);
    }

    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }


     public List<Course> getAvailableCoursesByStudentId(Integer id) throws Exception
    {
        //get all courses 
        List<Course> listall=courseRepository.findAll();
       
        //whether it is student or not
        Optional<Student> optional_student=studentRepository.findById(id);
        
        if(optional_student.isPresent()){
        
            //get enrolled course by student id
        List<CourseStudent> courseStudent=courseStudentService.findByStudent(optional_student.get());
        List<Integer> enrolledCourses=courseStudent.stream().map(c->c.getCourse().getId()).collect(Collectors.toList());
        
        List<Course> resultList=listall.stream()
        .filter(x->x.getCoursevacancy()>0 &&  // check vacancy is greatern than 0
        !(enrolledCourses).contains(x.getId()))  //it shoudn't contain enrolled courseid
        .collect(Collectors.toList());
        return resultList;
        }
        throw new Exception("student not found with id: " + id);
    
       // return courseRepository.findAvailableCourseByStudentId(id);

    }
}

