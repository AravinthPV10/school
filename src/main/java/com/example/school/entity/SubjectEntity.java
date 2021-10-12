package com.example.school.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity@Getter@Setter
@Table(name="subject")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjId;
    private String subjName;
}
