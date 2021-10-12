package com.example.school.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter@Setter
public class ResultDTO {
    private int rollNo;
    private String studName;
    private String subjName;
    private float marks;
    private double attendancePercentage;
    private String status;
}
