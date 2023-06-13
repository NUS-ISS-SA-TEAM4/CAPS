package com.master.caps.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String adminfirstname;

    private String adminlastname;

    private String admingender;
    @Temporal(TemporalType.DATE)
    private Integer adminbirthday;

    @Column(unique = true)
    private String adminusername;

    private String adminpassword;


}
