package com.example.school.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
public class StaffDTO {
    private int staff_id;
    private String staff_name;
    private int staff_age;
    private long staff_phone;
    private String staff_qualification;
}
