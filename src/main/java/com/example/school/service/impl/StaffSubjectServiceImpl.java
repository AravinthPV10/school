package com.example.school.service.impl;

import com.example.school.dto.StaffSubjectDTO;
import com.example.school.entity.StaffSubject;
import com.example.school.mapper.StaffSubjectMapper;
import com.example.school.repository.StaffSubjectRepository;
import com.example.school.service.StaffSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StaffSubjectServiceImpl implements StaffSubjectService {

    @Autowired
    StaffSubjectRepository staffSubjectRepository;
    @Override
    public StaffSubjectDTO addStaffSubject(StaffSubjectDTO staffSubjectDTO) {
        StaffSubject staffSubject = new StaffSubject();
        staffSubject= StaffSubjectMapper.INSTANCE.toStaffSubEntity(staffSubjectDTO);
        staffSubject=staffSubjectRepository.save(staffSubject);
        return StaffSubjectMapper.INSTANCE.toStaffSubDto(staffSubject);
    }

    @Override
    public StaffSubjectDTO updateStaffSubject(StaffSubjectDTO staffSubjectDTO) {
        StaffSubject staffSubject = new StaffSubject();
        staffSubject = staffSubjectRepository.findById(staffSubjectDTO.getStaff_roll_number()).map(res->{
            if(staffSubjectDTO.getStaff_id()!=0)
                res.setStaff_id(staffSubjectDTO.getStaff_id());
            if(staffSubjectDTO.getSubject_standard_id()!=0)
                res.setSubject_standard_id(staffSubjectDTO.getSubject_standard_id());
            return res;
        }).get();
        return  StaffSubjectMapper.INSTANCE.toStaffSubDto(staffSubject);
    }

    @Override
    public String deleteStaffSubject(StaffSubjectDTO staffSubjectDTO) {
        staffSubjectRepository.deleteById(staffSubjectDTO.getStaff_roll_number());
        return "Deleted Record: "+staffSubjectDTO.getStaff_roll_number();
    }

    @Override
    public String deleteAllStaffSubject() {
        staffSubjectRepository.deleteAll();
        return "Deleted All Record.";
    }

    @Override
    public StaffSubjectDTO showStaffSubject(StaffSubjectDTO staffSubjectDTO) {
        StaffSubject ss = new StaffSubject();
        ss = staffSubjectRepository.getById(staffSubjectDTO.getStaff_roll_number());
        return StaffSubjectMapper.INSTANCE.toStaffSubDto(ss);
    }

    @Override
    public List<StaffSubjectDTO> showAllStaffSubject() {
        return Optional.of(staffSubjectRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(StaffSubjectMapper.INSTANCE::toStaffSubDto)
                .collect(Collectors.toList());
    }
}
