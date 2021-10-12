package com.example.school.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
public class StaffDTO {
    private int staffId;
    private String staffName;
    private int staffAge;
    private long staffPhone;
    private String qual;
}
