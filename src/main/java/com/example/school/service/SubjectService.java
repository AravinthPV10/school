package com.example.school.service;

import com.example.school.dto.SubjectDTO;

import java.util.List;


public interface SubjectService {
    SubjectDTO addSub(SubjectDTO subjectDTO);
    SubjectDTO updateSub(SubjectDTO subjectDTO);
    String deleteSub(SubjectDTO subjectDTO);
    String deleteAllSub();
    SubjectDTO showSub(SubjectDTO subjectDTO);
    List<SubjectDTO> showAllSub();
}
