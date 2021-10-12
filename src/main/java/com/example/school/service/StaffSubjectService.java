package com.example.school.service;

import com.example.school.dto.StaffSubjectDTO;

import java.util.List;

public interface StaffSubjectService {
    StaffSubjectDTO addStaffSub(StaffSubjectDTO staffSubjectDTO);
    StaffSubjectDTO updateStaffSub(StaffSubjectDTO staffSubjectDTO);
    String deleteStaffSub(StaffSubjectDTO staffSubjectDTO);
    String deleteAllStaffSub();
    StaffSubjectDTO showStaffSub(StaffSubjectDTO staffSubjectDTO);
    List<StaffSubjectDTO> showAllStaffSub();
}
