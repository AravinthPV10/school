package com.example.school.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ResultMarksDTO {
    @JsonIgnore
    private int student_id;
    private String subject_name;
    private float marks;
    private String status;
}
