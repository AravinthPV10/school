package com.example.school.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
@Table(name="student_std")
public class StudentStandard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roll_number;
    private int student_id;
    private int standard_id;
}
