package com.example.school.service.impl;

import com.example.school.dto.StandardDTO;
import com.example.school.entity.StandardEntity;
import com.example.school.mapper.StandardMapper;
import com.example.school.repository.StandardRepository;
import com.example.school.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StandardServiceImpl implements StandardService {

    @Autowired
    StandardRepository standardRepository;

    @Override
    public StandardDTO addStandard(StandardDTO standardDTO) {
        StandardEntity s = new StandardEntity();
        s= StandardMapper.INSTANCE.toStdEntity(standardDTO);
        s = standardRepository.save(s);
        return StandardMapper.INSTANCE.toStdDto(s);
    }

    @Override
    public StandardDTO updateStandard(StandardDTO standardDTO) {
        StandardEntity standard = new StandardEntity();
        standard = standardRepository.findById(standardDTO.getStandard_id()).map(res->{
            if(standardDTO.getStandard_name()!=null)
                res.setStandard_name(standardDTO.getStandard_name());
            return res;
        }).get();
        return  StandardMapper.INSTANCE.toStdDto(standard);
    }

    @Override
    public String deleteStandard(StandardDTO standardDTO) {
        standardRepository.deleteById(standardDTO.getStandard_id());
        return "Deleted Record: "+standardDTO.getStandard_id();
    }

    @Override
    public String deleteAllStandard() {
        standardRepository.deleteAll();
        return "Deleted All Records. ";
    }

    @Override
    public StandardDTO showStandard(StandardDTO standardDTO) {
        StandardEntity standard = new StandardEntity();
        standard = standardRepository.findById(standardDTO.getStandard_id()).get();
        return StandardMapper.INSTANCE.toStdDto(standard);
    }

    @Override
    public List<StandardDTO> showAllStandard() {
        return Optional.of(standardRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(StandardMapper.INSTANCE::toStdDto)
                .collect(Collectors.toList());
    }
}
