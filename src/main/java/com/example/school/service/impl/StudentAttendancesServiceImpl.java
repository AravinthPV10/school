package com.example.school.service.impl;

import com.example.school.dto.AttnResDTO;
import com.example.school.dto.StudentAttendancesDTO;
import com.example.school.entity.StudentAttendancesEntity;
import com.example.school.mapper.StudentAttendancesMapper;
import com.example.school.repository.AttnResRepo;
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
    AttnResRepo attnResRepo;
    @Override
    public StudentAttendancesDTO addAttn(StudentAttendancesDTO studentAttendancesDTO) {
        StudentAttendancesEntity studentAttendances = new StudentAttendancesEntity();
        studentAttendances = StudentAttendancesMapper.INSTANCE.toAttnEntity(studentAttendancesDTO);
        studentAttendances = studentAttendancesRepository.save(studentAttendances);
        return StudentAttendancesMapper.INSTANCE.toAttnDto(studentAttendances);
    }

    @Override
    public StudentAttendancesDTO updateAttn(StudentAttendancesDTO studentAttendancesDTO) {
        StudentAttendancesEntity studentAttendances = new StudentAttendancesEntity();
        studentAttendances = studentAttendancesRepository.findById(studentAttendancesDTO.getId()).map(res->{
            if(studentAttendancesDTO.getDate()!=null)
                res.setDate(studentAttendancesDTO.getDate());
            if(studentAttendancesDTO.getStatus()!=null)
                res.setStatus(studentAttendancesDTO.getStatus());
            return res;
        }).get();
        return StudentAttendancesMapper.INSTANCE.toAttnDto(studentAttendances);
    }

    @Override
    public String deleteAttn(StudentAttendancesDTO studentAttendancesDTO) {
        studentAttendancesRepository.deleteById(studentAttendancesDTO.getId());
        return "Deleted Record: "+studentAttendancesDTO.getId();
    }

    @Override
    public String deleteAllAttn() {
        studentAttendancesRepository.deleteAll();
        return "Deleted All Records.";
    }

    @Override
    public StudentAttendancesDTO showAttn(StudentAttendancesDTO studentAttendancesDTO) {
        StudentAttendancesEntity studentAttendances = new StudentAttendancesEntity();
        studentAttendances = studentAttendancesRepository.findById(studentAttendancesDTO.getId()).get();
        return StudentAttendancesMapper.INSTANCE.toAttnDto(studentAttendances);
    }

    @Override
    public List<StudentAttendancesDTO> showAllAttn() {
        return Optional.of(studentAttendancesRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(StudentAttendancesMapper.INSTANCE::toAttnDto)
                .collect(Collectors.toList());
    }

    @Override
    public AttnResDTO getStuAttendance(int id) {
        AttnResDTO attnResDTO = new AttnResDTO();
        attnResDTO= attnResRepo.getAttendance(id);
        return attnResDTO;
    }

}
