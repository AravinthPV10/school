package com.example.school.service;

import com.example.school.dto.AttnResDTO;
import com.example.school.dto.StaffAttendanceDTO;

import java.util.List;

public interface StaffAttendanceService {
    StaffAttendanceDTO addStaffAttn(StaffAttendanceDTO staffAttendanceDTO);
    StaffAttendanceDTO updateStaffAttn(StaffAttendanceDTO staffAttendanceDTO);
    String deleteStaffAttn(StaffAttendanceDTO staffAttendanceDTO);
    String deleteAllStaffAttn();
    StaffAttendanceDTO showStaffAttn(StaffAttendanceDTO staffAttendanceDTO);
    List<StaffAttendanceDTO> showAllStaffAttn();
    AttnResDTO getStaffAttendance(int id);

}
