package com.example.school.service;

import com.example.school.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    StaffDTO addStaff(StaffDTO staffDTO);
    StaffDTO updateStaff(StaffDTO staffDTO);
    String deleteStaff(StaffDTO staffDTO);
    String deleteAllStaffs();
    StaffDTO showStaff(StaffDTO staffDTO);
    List<StaffDTO> showAllStaffs();
}
