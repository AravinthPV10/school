package com.example.school.service;

import com.example.school.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO addStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(StudentDTO studentDTO);
    String deleteStudent(StudentDTO studentDTO);
    String deleteAllStudents();
    StudentDTO showStudent(StudentDTO studentDTO);
    List<StudentDTO> showAllStudents();
}
