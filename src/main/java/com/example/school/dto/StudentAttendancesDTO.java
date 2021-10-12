package com.example.school.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter@Setter
public class StudentAttendancesDTO {
    private int id;
    private int studId;
    private Date date;
    private String status;
}
