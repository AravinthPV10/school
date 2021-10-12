package com.example.school.service.impl;

import com.example.school.dto.StudentStdDTO;
import com.example.school.entity.StudentStd;
import com.example.school.mapper.StudentStdMapper;
import com.example.school.repository.StudentStdRepository;
import com.example.school.service.StudentStdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentStdServiceImpl implements StudentStdService {

    @Autowired
    StudentStdRepository studentStdRepository;

    @Override
    public StudentStdDTO addStudStd(StudentStdDTO studentStdDTO) {
        StudentStd studentStd = new StudentStd();
        studentStd = StudentStdMapper.INSTANCE.toStudStdEntity(studentStdDTO);
        studentStd = studentStdRepository.save(studentStd);
        return StudentStdMapper.INSTANCE.toStudStdDto(studentStd);
    }

    @Override
    public StudentStdDTO updateStudStd(StudentStdDTO studentStdDTO) {
        StudentStd studentStd = new StudentStd();
        studentStd= studentStdRepository.findById(studentStdDTO.getId()).map(res->{
            if(studentStdDTO.getStudentId()!=0)
                res.setStudentId(studentStdDTO.getStudentId());
            if(studentStdDTO.getStandardId()!=0)
                res.setStandardId(studentStdDTO.getStandardId());
            return res;
        }).get();
        return StudentStdMapper.INSTANCE.toStudStdDto(studentStd);
    }

    @Override
    public String deleteStudStd(StudentStdDTO studentStdDTO) {
        studentStdRepository.deleteById(studentStdDTO.getId());
        return "Deleted record: "+studentStdDTO.getId();
    }

    @Override
    public String deleteAllStudStd() {
        studentStdRepository.deleteAll();
        return "Deleted All Records.";
    }

    @Override
    public StudentStdDTO showStudStd(StudentStdDTO studentStdDTO) {
        StudentStd studentStd = new StudentStd();
        studentStd = studentStdRepository.getById(studentStdDTO.getId());
        return StudentStdMapper.INSTANCE.toStudStdDto(studentStd);
    }

    @Override
    public List<StudentStdDTO> showAllStudStd() {
        return Optional.of(studentStdRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(StudentStdMapper.INSTANCE::toStudStdDto)
                .collect(Collectors.toList());
    }
}
