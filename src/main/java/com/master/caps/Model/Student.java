package com.master.caps.Model;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;


@Entity
@Data
public class Student extends Person{
      @Temporal(TemporalType.DATE)
private Date enrollmentdate;

    @ManyToOne
    @JoinColumn(name = "studentfacultyid")
    private Faculty studentfaculty;

    private Float gpa;

//     public void setBirthday(Date date) {
//     this.enrollmentdate = date;
// }

//     public void setEnrollmentdate(Date date) {
//         this.enrollmentdate = date;
//     }
}
