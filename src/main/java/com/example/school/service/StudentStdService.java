package com.example.school.service;

import com.example.school.dto.ResultDTO;
import com.example.school.dto.StudentStandardDTO;

import java.util.List;

public interface StudentStdService {
    StudentStandardDTO addStudStd(StudentStandardDTO studentStandardDTO);
    StudentStandardDTO updateStudStd(StudentStandardDTO studentStandardDTO);
    String deleteStudStd(StudentStandardDTO studentStandardDTO);
    String deleteAllStudStd();
    StudentStandardDTO showStudStd(StudentStandardDTO studentStandardDTO);
    List<StudentStandardDTO> showAllStudStd();
    List<ResultDTO> getResults();
}
