package com.master.caps.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String facultyname;
}
