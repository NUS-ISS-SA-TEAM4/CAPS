package com.master.caps.Model;
import jakarta.persistence.*;

import lombok.Data;

import java.util.Date;


@Entity
@Data
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String studentMatriculationNumber;

    private String studentLastName;

    private String studentFirstMidName;

    @Temporal(TemporalType.DATE)
    private Date studentEnrollmentDate;

    private String studentGender;

    @Temporal(TemporalType.DATE)
    private Date studentDateOfBirth;

    @ManyToOne
    @JoinColumn(name = "studentFacultyId")
    private Faculty studentFaculty;

    private Float studentGradePointAverage;

    private String studentPassword;



}
