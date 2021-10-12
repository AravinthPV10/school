package com.example.school.service.impl;

import com.example.school.dto.SubjectDTO;
import com.example.school.entity.SubjectEntity;
import com.example.school.mapper.SubjectMapper;
import com.example.school.repository.SubjectRepository;
import com.example.school.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public SubjectDTO addSub(SubjectDTO subjectDTO) {
        SubjectEntity subject = new SubjectEntity();
        subject = SubjectMapper.INSTANCE.toSubEntity(subjectDTO);
        subject = subjectRepository.save(subject);
        return SubjectMapper.INSTANCE.toSubDto(subject);
    }

    @Override
    public SubjectDTO updateSub(SubjectDTO subjectDTO) {
        SubjectEntity subject = new SubjectEntity();
        subject = subjectRepository.findById(subjectDTO.getSubjId()).map(res->{
            if(subjectDTO.getSubjName()!=null)
                res.setSubjName(subjectDTO.getSubjName());
            return res;
        }).get();
        return  SubjectMapper.INSTANCE.toSubDto(subject);
    }

    @Override
    public String deleteSub(SubjectDTO subjectDTO) {
        subjectRepository.deleteById(subjectDTO.getSubjId());
        return "Deleted Record: "+subjectDTO.getSubjId();
    }

    @Override
    public String deleteAllSub() {
        subjectRepository.deleteAll();
        return "Deleted All Records.";
    }

    @Override
    public SubjectDTO showSub(SubjectDTO subjectDTO) {
        SubjectEntity subject = new SubjectEntity();
        subject= subjectRepository.findById(subjectDTO.getSubjId()).get();
        return SubjectMapper.INSTANCE.toSubDto(subject);
    }

    @Override
    public List<SubjectDTO> showAllSub() {
        return Optional.of(subjectRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(SubjectMapper.INSTANCE::toSubDto)
                .collect(Collectors.toList());
    }
}