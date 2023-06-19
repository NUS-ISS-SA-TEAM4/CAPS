package com.master.caps.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Schedule{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer scheduledayofweek;
    private Integer schedulestarttime;
    private Integer scheduleendtime;

    public Schedule(int id, Integer scheduledayofweek, Integer schedulestarttime, Integer scheduleendtime) {
        this.id = id;
        this.scheduledayofweek = scheduledayofweek;
        this.schedulestarttime = schedulestarttime;
        this.scheduleendtime = scheduleendtime;
    }

    public Schedule() {
        id=0;

    }

    public boolean isAvailable()
    {
        return id==0;
    }

}
