package com.master.caps.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Schedule{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseid;

    private String coursename;

    private String coursecredits;

    private Integer coursecapacity;

    private String coursevacancy;

    private Double courseenrollmentstatus;
}
