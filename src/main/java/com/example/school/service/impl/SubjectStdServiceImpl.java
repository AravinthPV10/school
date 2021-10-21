package com.example.school.service.impl;

import com.example.school.dto.SubjectStandardDTO;
import com.example.school.entity.SubjectStandard;
import com.example.school.mapper.SubjectStdMapper;
import com.example.school.repository.SubjectStdRepository;
import com.example.school.service.SubjectStdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class SubjectStdServiceImpl implements SubjectStdService {

    @Autowired
    SubjectStdRepository subjectStdRepository;

    @Override
    public SubjectStandardDTO addSubStd(SubjectStandardDTO subjectStandardDTO) {
        SubjectStandard subjectStandard = new SubjectStandard();
        subjectStandard = SubjectStdMapper.INSTANCE.toSubStdEntity(subjectStandardDTO);
        subjectStandard = subjectStdRepository.save(subjectStandard);
        return SubjectStdMapper.INSTANCE.toSubStdDto(subjectStandard);
    }

    @Override
    public SubjectStandardDTO updateSubStd(SubjectStandardDTO subjectStandardDTO) {
        SubjectStandard subjectStandard = new SubjectStandard();
        subjectStandard = subjectStdRepository.findById(subjectStandardDTO.getId()).map(res->{
            if(subjectStandardDTO.getSubject_id()!=0)
                res.setSubject_id(subjectStandardDTO.getSubject_id());
            if(subjectStandardDTO.getStandard_id()!=0)
                res.setStandard_id(subjectStandardDTO.getStandard_id());
            return res;
        }).get();
        return  SubjectStdMapper.INSTANCE.toSubStdDto(subjectStandard);
    }

    @Override
    public String deleteSubStd(SubjectStandardDTO subjectStandardDTO) {
        subjectStdRepository.deleteById(subjectStandardDTO.getId());
        return "Deleted Record: "+ subjectStandardDTO.getId();
    }

    @Override
    public String deleteAllSubStd() {
        subjectStdRepository.deleteAll();
        return "Deleted All Records.";
    }

    @Override
    public SubjectStandardDTO showSubStd(SubjectStandardDTO subjectStandardDTO) {
        SubjectStandard subjectStandard = new SubjectStandard();
        subjectStandard = subjectStdRepository.getById(subjectStandardDTO.getId());
        return SubjectStdMapper.INSTANCE.toSubStdDto(subjectStandard);
    }

    @Override
    public List<SubjectStandardDTO> showAllSubStd() {
        return Optional.of(subjectStdRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(SubjectStdMapper.INSTANCE::toSubStdDto)
                .collect(Collectors.toList());
    }
}
