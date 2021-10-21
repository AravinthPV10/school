package com.example.school.service.impl;

import com.example.school.dto.AttendancePercentageDTO;
import com.example.school.dto.StaffAttendanceDTO;
import com.example.school.entity.StaffAttendanceEntity;
import com.example.school.mapper.StaffAttendanceMapper;
import com.example.school.repository.AttendancePercentageRepository;
import com.example.school.repository.StaffAttendanceRepository;
import com.example.school.service.StaffAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StaffAttendanceServiceImpl implements StaffAttendanceService {

    @Autowired
    StaffAttendanceRepository staffAttendanceRepository;

    @Autowired
    AttendancePercentageRepository attendancePercentageRepository;
    @Override
    public StaffAttendanceDTO addStaffAttendance(StaffAttendanceDTO staffAttendanceDTO) {
        StaffAttendanceEntity staffAttendanceEntity = new StaffAttendanceEntity();
        staffAttendanceEntity = StaffAttendanceMapper.INSTANCE.toStaffAttnEntity(staffAttendanceDTO);
        staffAttendanceEntity = staffAttendanceRepository.save(staffAttendanceEntity);
        return StaffAttendanceMapper.INSTANCE.toStaffAttnDto(staffAttendanceEntity);
    }

    @Override
    public StaffAttendanceDTO updateStaffAttendance(StaffAttendanceDTO staffAttendanceDTO) {
        StaffAttendanceEntity staffAttendance = new StaffAttendanceEntity();
        staffAttendance = staffAttendanceRepository.findById(staffAttendanceDTO.getId()).map(attendance->{
            if(staffAttendanceDTO.getStaff_roll_number()!=0)
                attendance.setStaff_roll_number(staffAttendanceDTO.getStaff_roll_number());
            if(staffAttendanceDTO.getDate()!=null)
                attendance.setDate(staffAttendanceDTO.getDate());
            if(staffAttendanceDTO.getStatus()!=null)
                attendance.setStatus(staffAttendanceDTO.getStatus());
            return attendance;
        }).get();
        return StaffAttendanceMapper.INSTANCE.toStaffAttnDto(staffAttendance);
    }

    @Override
    public String deleteStaffAttendance(StaffAttendanceDTO staffAttendanceDTO) {
        staffAttendanceRepository.deleteById(staffAttendanceDTO.getId());
        return "Deleted Record: "+staffAttendanceDTO.getId();
    }

    @Override
    public String deleteAllStaffAttendance() {
        staffAttendanceRepository.deleteAll();
        return "Deleted All Records.";
    }

    @Override
    public StaffAttendanceDTO showStaffAttendance(StaffAttendanceDTO staffAttendanceDTO) {
        StaffAttendanceEntity staffAttendance = new StaffAttendanceEntity();
        staffAttendance = staffAttendanceRepository.getById(staffAttendanceDTO.getId());
        return StaffAttendanceMapper.INSTANCE.toStaffAttnDto(staffAttendance);
    }

    @Override
    public List<StaffAttendanceDTO> showAllStaffAttendance() {
        return Optional.of(staffAttendanceRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(StaffAttendanceMapper.INSTANCE::toStaffAttnDto)
                .collect(Collectors.toList());
    }
    @Override
    public AttendancePercentageDTO getStaffAttendancePercentage(int id) {
        AttendancePercentageDTO attendancePercentageDTO = new AttendancePercentageDTO();
        attendancePercentageDTO = attendancePercentageRepository.getStaffAttendancePercentage(id);
        return attendancePercentageDTO;
    }
}
