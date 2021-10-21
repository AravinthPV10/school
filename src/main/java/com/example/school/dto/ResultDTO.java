package com.example.school.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Getter@Setter
public class ResultDTO {
    private int rollNo;
    private String student_name;
    private List<ResultMarksDTO> subjects;
    private int days_present;
    private int days_absent;
    private int total_working_days;
    private double attendance_percentage;
    private String status;
}
