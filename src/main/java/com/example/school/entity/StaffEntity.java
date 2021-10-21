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
    private int staff_id;
    private String staff_name;
    private int staff_age;
    private long staff_phone;
    private String staff_qualification;
}
