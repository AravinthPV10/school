package com.example.school.service;

import com.example.school.dto.StaffSubjectDTO;

import java.util.List;

public interface StaffSubjectService {
    StaffSubjectDTO addStaffSubject(StaffSubjectDTO staffSubjectDTO);
    StaffSubjectDTO updateStaffSubject(StaffSubjectDTO staffSubjectDTO);
    String deleteStaffSubject(StaffSubjectDTO staffSubjectDTO);
    String deleteAllStaffSubject();
    StaffSubjectDTO showStaffSubject(StaffSubjectDTO staffSubjectDTO);
    List<StaffSubjectDTO> showAllStaffSubject();
}
