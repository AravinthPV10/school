package com.example.school.service;

import com.example.school.dto.AttendancePercentageDTO;
import com.example.school.dto.StaffAttendanceDTO;

import java.util.List;

public interface StaffAttendanceService {
    StaffAttendanceDTO addStaffAttendance(StaffAttendanceDTO staffAttendanceDTO);
    StaffAttendanceDTO updateStaffAttendance(StaffAttendanceDTO staffAttendanceDTO);
    String deleteStaffAttendance(StaffAttendanceDTO staffAttendanceDTO);
    String deleteAllStaffAttendance();
    StaffAttendanceDTO showStaffAttendance(StaffAttendanceDTO staffAttendanceDTO);
    List<StaffAttendanceDTO> showAllStaffAttendance();
    AttendancePercentageDTO getStaffAttendancePercentage(int id);

}
