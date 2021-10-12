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
    public StandardDTO addStd(StandardDTO standardDTO) {
        StandardEntity s = new StandardEntity();
        s= StandardMapper.INSTANCE.toStdEntity(standardDTO);
        s = standardRepository.save(s);
        return StandardMapper.INSTANCE.toStdDto(s);
    }

    @Override
    public StandardDTO updateStd(StandardDTO standardDTO) {
        StandardEntity standard = new StandardEntity();
        standard = standardRepository.findById(standardDTO.getStdId()).map(res->{
            if(standardDTO.getStdName()!=null)
                res.setStdName(standardDTO.getStdName());
            return res;
        }).get();
        return  StandardMapper.INSTANCE.toStdDto(standard);
    }

    @Override
    public String deleteStd(StandardDTO standardDTO) {
        standardRepository.deleteById(standardDTO.getStdId());
        return "Deleted Record: "+standardDTO.getStdId();
    }

    @Override
    public String deleteAllStd() {
        standardRepository.deleteAll();
        return "Deleted All Records. ";
    }

    @Override
    public StandardDTO showStd(StandardDTO standardDTO) {
        StandardEntity standard = new StandardEntity();
        standard = standardRepository.findById(standardDTO.getStdId()).get();
        return StandardMapper.INSTANCE.toStdDto(standard);
    }

    @Override
    public List<StandardDTO> showAllStd() {
        return Optional.of(standardRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(StandardMapper.INSTANCE::toStdDto)
                .collect(Collectors.toList());
    }
}
