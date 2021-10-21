package com.example.school.service;

import com.example.school.dto.AttendancePercentageDTO;
import com.example.school.dto.StudentAttendancesDTO;

import java.util.List;

public interface StudentAttendancesService {
    StudentAttendancesDTO addAttendance(StudentAttendancesDTO studentAttendancesDTO);
    StudentAttendancesDTO updateAttendance(StudentAttendancesDTO studentAttendancesDTO);
    String deleteAttendance(StudentAttendancesDTO studentAttendancesDTO);
    String deleteAllAttendance();
    StudentAttendancesDTO showAttendance(StudentAttendancesDTO studentAttendancesDTO);
    List<StudentAttendancesDTO> showAllAttendance();
    AttendancePercentageDTO getStudentAttendancePercent(int id);
}
