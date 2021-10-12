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
    public StaffSubjectDTO addStaffSub(StaffSubjectDTO staffSubjectDTO) {
        StaffSubject staffSubject = new StaffSubject();
        staffSubject= StaffSubjectMapper.INSTANCE.toStaffSubEntity(staffSubjectDTO);
        staffSubject=staffSubjectRepository.save(staffSubject);
        return StaffSubjectMapper.INSTANCE.toStaffSubDto(staffSubject);
    }

    @Override
    public StaffSubjectDTO updateStaffSub(StaffSubjectDTO staffSubjectDTO) {
        StaffSubject staffSubject = new StaffSubject();
        staffSubject = staffSubjectRepository.findById(staffSubjectDTO.getId()).map(res->{
            if(staffSubjectDTO.getStaffId()!=0)
                res.setStaffId(staffSubjectDTO.getStaffId());
            if(staffSubjectDTO.getSubStdId()!=0)
                res.setSubStdId(staffSubjectDTO.getSubStdId());
            return res;
        }).get();
        return  StaffSubjectMapper.INSTANCE.toStaffSubDto(staffSubject);
    }

    @Override
    public String deleteStaffSub(StaffSubjectDTO staffSubjectDTO) {
        staffSubjectRepository.deleteById(staffSubjectDTO.getId());
        return "Deleted Record: "+staffSubjectDTO.getId();
    }

    @Override
    public String deleteAllStaffSub() {
        staffSubjectRepository.deleteAll();
        return "Deleted All Record.";
    }

    @Override
    public StaffSubjectDTO showStaffSub(StaffSubjectDTO staffSubjectDTO) {
        StaffSubject ss = new StaffSubject();
        ss = staffSubjectRepository.getById(staffSubjectDTO.getId());
        return StaffSubjectMapper.INSTANCE.toStaffSubDto(ss);
    }

    @Override
    public List<StaffSubjectDTO> showAllStaffSub() {
        return Optional.of(staffSubjectRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(StaffSubjectMapper.INSTANCE::toStaffSubDto)
                .collect(Collectors.toList());
    }
}
