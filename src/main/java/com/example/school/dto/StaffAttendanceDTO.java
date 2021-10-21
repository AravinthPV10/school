package com.example.school.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
public class StaffAttendanceDTO {
    private int id;
    private int staff_roll_number;
    private Date date;
    private String status;
}
