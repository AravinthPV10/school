package com.example.school.service;

import com.example.school.dto.SubjectStdDTO;

import java.util.List;

public interface SubjectStdService {
    SubjectStdDTO addSubStd(SubjectStdDTO subjectStdDTO);
    SubjectStdDTO updateSubStd(SubjectStdDTO subjectStdDTO);
    String deleteSubStd(SubjectStdDTO subjectStdDTO);
    String deleteAllSubStd();
    SubjectStdDTO showSubStd(SubjectStdDTO subjectStdDTO);
    List<SubjectStdDTO> showAllSubStd();
}
