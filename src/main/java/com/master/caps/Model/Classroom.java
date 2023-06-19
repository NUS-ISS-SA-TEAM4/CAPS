package com.master.caps.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="classroomname")
    private String classRoomName;
    @Column(name="classroomsize")
    private Integer classRoomSize;
}
