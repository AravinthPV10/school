package com.example.school.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter@Getter
@Table(name="subject_std")
public class SubjectStd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int subjectId;
    private int standardId;

}
