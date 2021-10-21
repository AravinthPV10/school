package com.example.school.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarksDTO {
    private int marks_id;
    private int student_id;
    private int subject_id;
    private float marks;
}
