package com.example.school.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter@Setter@Component
public class StudentDTO {
    private int studId;
    private String studName;
    private int studAge;
    private long studPhone;
}
