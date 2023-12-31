package com.master.caps.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Course{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String courseid;

    private String coursename;

    private Integer coursecredits;

    private Integer coursecapacity;

    private Integer coursevacancy;

    private Boolean courseenrollmentstatus;
    @ManyToOne
    @JoinColumn(name = "coursefacultyid")
    private Faculty faculty;
}
