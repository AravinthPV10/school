package com.example.school.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
@Table(name="staff_subject")
public class StaffSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staff_roll_number;
    private int staff_id;
    private int subject_standard_id;
}
