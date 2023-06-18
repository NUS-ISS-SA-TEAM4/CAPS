package com.master.caps.Controller;


import com.master.caps.Model.Course;
import com.master.caps.Model.CourseStudent;
import com.master.caps.Model.Student;
import com.master.caps.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/enrolcourse")
public class CourseSelectionController {

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @Autowired
    CourseStudentService courseStudentService;

    @GetMapping("/view")
    public String list(Model model, HttpSession session){

        //Check if the person has logged in via Session
        //May need to change the code
        if(studentService.checkSession() == null)
            return "redirect:/login";
        filteroutcourse(session);

        //This is to display the available courses for the students to see and select...
        int currentpage = 0;
        List<Course> viewWithPagination = courseService.findAllCourse(currentpage, pageSize:5);

    }

    //In our course selection, we can only apply to one course at at time...
    @GetMapping("/{courseId")
    @Transactional
    //Process for course registration should be transactional.
    public String register(@PathVariable("courseId") int courseId,HttpSession session, Model model) throws Throwable {

        if(studentService.checkSession() == null)
            return "redirect:/login";

        //If the session is valid
        Student student = session.getAttribute("studentId");
        model.addAttribute("student", student);
        Course course = courseService.findById(courseId);

        //coursecounter is the current course counter, if someone applied for the course, the counter will increase
        //I think we can use the count from CourseStudent Model
        int coursecounter = CourseStudent.getCourseId("courseID").count();
        int coursesize = Course.getCourseCapacity();

        //Time element can be added here too
        if(coursecounter < coursesize && session.getAttribute("time") < registration.time){
            //Addind the student into the CourseStudent Model
            //This will also automatically increase the number of student
            CourseStudent.setStudentId("studentId");
            //Add the course object into the model
            model.addAttribute("course", course);
            //Once successful, automatically generate a email to notify student of the course registered
            sendCourseRegEmail(model);
            //Student will see the Enrolment Completed page
            return "EnrollCompleted.html";
        }
        //If the coursecounter > coursesize OR student is late
        else {
            //Fail to register for the course
            return "EnrollUnsuccessful.html";
        }
    }

    public void sendCourseRegEmail(Model model, @PathVariable("Id") Integer Id, String courseId){

        //Getting the email of the student
        Student StudentEmail = studentService.findbyId(Id);

        //https://www.baeldung.com/spring-email
    }
}