package com.master.caps.Model;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Lecturer extends Person{
    @ManyToOne
    @JoinColumn(name = "lecturerfacultyid")
    private Faculty faculty;
}
