package com.example.school.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter@Setter
@Table(name="staff_attendance")
public class StaffAttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int staff_roll_number;
    private Date date;
    private String status;

}
