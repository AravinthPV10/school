package com.example.school.service;

import com.example.school.dto.AttnResDTO;
import com.example.school.dto.StudentAttendancesDTO;

import java.util.List;

public interface StudentAttendancesService {
    StudentAttendancesDTO addAttn(StudentAttendancesDTO studentAttendancesDTO);
    StudentAttendancesDTO updateAttn(StudentAttendancesDTO studentAttendancesDTO);
    String deleteAttn(StudentAttendancesDTO studentAttendancesDTO);
    String deleteAllAttn();
    StudentAttendancesDTO showAttn(StudentAttendancesDTO studentAttendancesDTO);
    List<StudentAttendancesDTO> showAllAttn();
    AttnResDTO getStuAttendance(int id);
}
