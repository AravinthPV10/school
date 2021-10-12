package com.example.school.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="marks")
public class MarksEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int marksId;
    private int studId;
    private int subjId;
    private float marks;
}
