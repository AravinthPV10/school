package com.example.school.service.impl;

import com.example.school.dto.SubjectStdDTO;
import com.example.school.entity.SubjectStd;
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
    public SubjectStdDTO addSubStd(SubjectStdDTO subjectStdDTO) {
        SubjectStd subjectStd = new SubjectStd();
        subjectStd = SubjectStdMapper.INSTANCE.toSubStdEntity(subjectStdDTO);
        subjectStd = subjectStdRepository.save(subjectStd);
        return SubjectStdMapper.INSTANCE.toSubStdDto(subjectStd);
    }

    @Override
    public SubjectStdDTO updateSubStd(SubjectStdDTO subjectStdDTO) {
        SubjectStd subjectStd = new SubjectStd();
        subjectStd = subjectStdRepository.findById(subjectStdDTO.getId()).map(res->{
            if(subjectStdDTO.getSubjectId()!=0)
                res.setSubjectId(subjectStdDTO.getSubjectId());
            if(subjectStdDTO.getStandardId()!=0)
                res.setSubjectId(subjectStdDTO.getSubjectId());
            return res;
        }).get();
        return  SubjectStdMapper.INSTANCE.toSubStdDto(subjectStd);
    }

    @Override
    public String deleteSubStd(SubjectStdDTO subjectStdDTO) {
        subjectStdRepository.deleteById(subjectStdDTO.getId());
        return "Deleted Record: "+subjectStdDTO.getId();
    }

    @Override
    public String deleteAllSubStd() {
        subjectStdRepository.deleteAll();
        return "Deleted All Records.";
    }

    @Override
    public SubjectStdDTO showSubStd(SubjectStdDTO subjectStdDTO) {
        SubjectStd subjectStd = new SubjectStd();
        subjectStd = subjectStdRepository.getById(subjectStdDTO.getId());
        return SubjectStdMapper.INSTANCE.toSubStdDto(subjectStd);
    }

    @Override
    public List<SubjectStdDTO> showAllSubStd() {
        return Optional.of(subjectStdRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(SubjectStdMapper.INSTANCE::toSubStdDto)
                .collect(Collectors.toList());
    }
}
