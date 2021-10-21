package com.example.school.service.impl;

import com.example.school.dto.MarksDTO;
import com.example.school.entity.MarksEntity;
import com.example.school.mapper.MarksMapper;
import com.example.school.repository.MarksRepository;
import com.example.school.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarksServiceImpl implements MarksService {

    @Autowired
    MarksRepository marksRepository;
    @Autowired
    StudentAttendancesServiceImpl studentAttendancesService;

    @Override
    public MarksDTO addMarks(MarksDTO marksDTO) {
        MarksEntity marksEntity = new MarksEntity();
        marksEntity = MarksMapper.INSTANCE.toMarksEntity(marksDTO);
        marksEntity = marksRepository.save(marksEntity);
        return MarksMapper.INSTANCE.toMarksDto(marksEntity);
    }

    @Override
    public MarksDTO updateMarks(MarksDTO marksDTO) {
        MarksEntity marks = new MarksEntity();
        marks = marksRepository.findById(marksDTO.getMarks_id()).map(mark->{
            if(marksDTO.getStudent_id()!=0)
                mark.setStudent_id(marksDTO.getStudent_id());
            if (marksDTO.getSubject_id()!=0)
                mark.setSubject_id(marksDTO.getSubject_id());
            if(marksDTO.getMarks()!=0)
                mark.setMarks(marksDTO.getMarks());
            return mark;
        }).get();
        return  MarksMapper.INSTANCE.toMarksDto(marks);
    }

    @Override
    public String deleteMarks(MarksDTO marksDTO) {
        marksRepository.deleteById(marksDTO.getMarks_id());
        return "Deleted Record: "+marksDTO.getMarks_id();
    }

    @Override
    public String deleteAllMarks() {
        marksRepository.deleteAll();
        return "Deleted All Records";
    }

    @Override
    public MarksDTO showMarks(MarksDTO marksDTO) {
        MarksEntity marks = new MarksEntity();
        marks = marksRepository.getById(marksDTO.getMarks_id());
        return MarksMapper.INSTANCE.toMarksDto(marks);
    }

    @Override
    public List<MarksDTO> showAllMarks() {
        return Optional.of(marksRepository.findAll())
                .orElse(Collections.emptyList())
                .stream()
                .map(MarksMapper.INSTANCE::toMarksDto)
                .collect(Collectors.toList());
    }

}
