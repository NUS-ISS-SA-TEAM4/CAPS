package com.master.caps.Model;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Schedule{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer scheduledayofweek;
    // @Temporal(TemporalType.DATE)
    private Date  schedulestarttime;
    // @Temporal(TemporalType.DATE)
    private Date scheduleendtime;
}
