package com.example.school.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter@Setter@Component
public class StudentDTO {
    private int student_id;
    private String student_name;
    private int student_age;
    private long student_phone;
}
