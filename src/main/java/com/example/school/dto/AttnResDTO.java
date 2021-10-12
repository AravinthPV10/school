package com.example.school.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter@Setter
public class AttnResDTO {
    @Id
    private int stud_id;
    private double percent;
}
