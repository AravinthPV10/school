package com.example.school.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class StandardDTO {
    private int standard_id;
    private String standard_name;
}
