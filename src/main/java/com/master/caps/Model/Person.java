package com.master.caps.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    /**
     * @roleType the 3 type of persons
     * 0 means student
     * 1 means lecturer
     * 2 means admin
     * @author susie
     */
    @NonNull
    private Integer roleType;

    @Column(unique = true)
    private String username;

    @NonNull
    private String password;
    private String firstname;
    private String lastname;

    private String gender;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    private String surname;

    private String email;

    private String address;

    private String contactnumber;

    public String getFullName()
    {
        return firstname+" "+lastname;
    }

}
