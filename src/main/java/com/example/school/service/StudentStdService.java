package com.example.school.service;

import com.example.school.dto.StudentStdDTO;

import java.util.List;

public interface StudentStdService {
    StudentStdDTO addStudStd(StudentStdDTO studentStdDTO);
    StudentStdDTO updateStudStd(StudentStdDTO studentStdDTO);
    String deleteStudStd(StudentStdDTO studentStdDTO);
    String deleteAllStudStd();
    StudentStdDTO showStudStd(StudentStdDTO studentStdDTO);
    List<StudentStdDTO> showAllStudStd();
}
