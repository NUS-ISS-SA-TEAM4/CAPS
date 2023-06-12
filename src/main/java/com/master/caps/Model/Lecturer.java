package com.master.caps.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Lecturer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String lecturerusername;

    private String lecturerlastname;

    private String lecturerfirstname;

    private String lecturergender;

    @Temporal(TemporalType.DATE)
    private Date lecturerbirthday;

    private String lecturerpassword;

    private String lecturerfaculty;
}
