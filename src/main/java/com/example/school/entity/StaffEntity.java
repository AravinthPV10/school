package com.example.school.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="staff_entity")
public class StaffEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int staffId;
    private String staffName;
    private int staffAge;
    private long staffPhone;
    private String qual;
}
