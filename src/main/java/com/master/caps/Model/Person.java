package com.master.caps.Model;

import com.master.caps.Service.Password;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
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

    public String getPassword() throws Exception {
        return Password.decrypt(password);
    }

    public void setPassword(String password) throws Exception {
        this.password = Password.encrypt(password);
    }


}
