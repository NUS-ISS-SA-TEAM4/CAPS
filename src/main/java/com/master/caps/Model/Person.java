package com.master.caps.Model;

import java.sql.Date;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String firstname;

    private String lastname;

    private String gender;
    //   @Temporal(TemporalType.DATE)
    private int birthday;

    @Column(unique = true)
    private String username;

    private String password;

    private String surname;

    private String email;

    private String address;

    private String contactnumber;
}
