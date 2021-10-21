package com.example.school.service.impl;

import com.example.school.dto.AttendancePercentageDTO;
import com.example.school.dto.StudentAttendancesDTO;
import com.example.school.entity.StudentAttendancesEntity;
import com.example.school.mapper.StudentAttendancesMapper;
import com.example.school.repository.AttendancePercentageRepository;
import com.example.school.repository.StudentAttendancesRepository;
import com.example.school.service.StudentAttendancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class StudentAttendancesServiceImpl implements StudentAttendancesService {

    @Autowired
    StudentAttendancesRepository studentAttendancesRepository;
    @Autowired
    AttendancePercentageRepository attendancePercentageRepository;
    @Override
    public StudentAttendancesDTO addAttendance(StudentAttendancesDTO studentAttendancesDTO) {
        StudentAttendancesEntity studentAttendances = new StudentAttendancesEntity();
        studentAttendances = StudentAttendancesMapper.INSTANCE.toAttnEntity(studentAttendancesDTO);
        studentAttendances = studentAttendancesRepository.save(studentAttendances);
        return StudentAttendancesMapper.INSTANCE.toAttnDto(studentAttendances);
    }

    @Override
    public StudentAttendancesDTO updateAttendance(StudentAttendancesDTO studentAttendancesDTO) {
        StudentAttendancesEntity studentAttendances = new StudentAttendancesEntity();
        studentAttendances = studentAttendancesRepository.findById(studentAttendancesDTO.getId()).map(res->{
            if(studentAttendancesDTO.getRoll_number()!=0)
                res.setRoll_number(studentAttendancesDTO.getRoll_number());
            if(studentAttendancesDTO.getDate()!=null)
                res.setDate(studentAttendancesDTO.getDate());
            if(studentAttendancesDTO.getStatus()!=null)
                res.setStatus(studentAttendancesDTO.getStatus());
            return res;
        }).get();
        return StudentAttendancesMapper.INSTANCE.toAttnDto(studentAttendances);
    }

    @Override
    public String deleteAttendance(StudentAttendancesDTO studentAttendancesDTO) {
        studentAttendancesRepository.deleteById(studentAttendancesDTO.getId());
        return "Deleted Record: "+studentAttendancesDTO.getId();
    }

    @Override
    public String deleteAllAttendance() {
        studentAttendancesRepository.deleteAll();
        return "Deleted All Records.";
    }

    @Override
    public StudentAttendancesDTO showAttendance(StudentAttendancesDTO studentAttendancesDTO) {
        StudentAttendancesEntity studentAttendances = new StudentAttendancesEntity();
        studentAttendances = studentAttendancesRepository.findById(studentAttendancesDTO.getId()).get();
        return StudentAttendancesMapper.INSTANCE.toAttnDto(studentAttendances);
    }

    @Override
    public List<StudentAttendancesDTO> showAllAttendance() {
        return Optional.of(studentAttendancesRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(StudentAttendancesMapper.INSTANCE::toAttnDto)
                .collect(Collectors.toList());
    }

    @Override
    public AttendancePercentageDTO getStudentAttendancePercent(int id) {
        AttendancePercentageDTO attendancePercentageDTO = new AttendancePercentageDTO();
        attendancePercentageDTO = attendancePercentageRepository.getStudentAttendancePercentage(id);
        return attendancePercentageDTO;
    }

}
