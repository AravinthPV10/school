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
    private int marks_id;
    private int student_id;
    private int subject_id;
    private float marks;
}
