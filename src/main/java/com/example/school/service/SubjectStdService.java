package com.example.school.service;

import com.example.school.dto.SubjectStandardDTO;

import java.util.List;

public interface SubjectStdService {
    SubjectStandardDTO addSubStd(SubjectStandardDTO subjectStandardDTO);
    SubjectStandardDTO updateSubStd(SubjectStandardDTO subjectStandardDTO);
    String deleteSubStd(SubjectStandardDTO subjectStandardDTO);
    String deleteAllSubStd();
    SubjectStandardDTO showSubStd(SubjectStandardDTO subjectStandardDTO);
    List<SubjectStandardDTO> showAllSubStd();
}
