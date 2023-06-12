package com.master.caps.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Lecturer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lecturerusername;

    private String lecturerlastname;

    private String lecturerfirstname;

    private String lecturergender;

    private Date lecturerbirthday;

    private String lecturerpassword;

    private String lecturerfaculty;
}
