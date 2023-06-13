package com.master.caps.Model;

import jakarta.persistence.*;
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
    @Temporal(TemporalType.DATE)
    private Integer birthday;

    @Column(unique = true)
    private String username;

    private String password;
}
