package com.example.school.service.impl;

import com.example.school.dto.MarksDTO;
import com.example.school.dto.ResultDTO;
import com.example.school.entity.MarksEntity;

import com.example.school.mapper.MarksMapper;

import com.example.school.repository.MarksRepository;
import com.example.school.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        marks = marksRepository.findById(marksDTO.getMarksId()).map(mark->{
            if(marksDTO.getStudId()!=0)
                mark.setStudId(marksDTO.getStudId());
            if (marksDTO.getSubjId()!=0)
                mark.setSubjId(marksDTO.getMarksId());
            if(marksDTO.getMarks()!=0)
                mark.setMarks(marksDTO.getMarks());
            return mark;
        }).get();
        return  MarksMapper.INSTANCE.toMarksDto(marks);
    }

    @Override
    public String deleteMarks(MarksDTO marksDTO) {
        marksRepository.deleteById(marksDTO.getMarksId());
        return "Deleted Record: "+marksDTO.getMarksId();
    }

    @Override
    public String deleteAllMarks() {
        marksRepository.deleteAll();
        return "Deleted All Records";
    }

    @Override
    public MarksDTO showMarks(MarksDTO marksDTO) {
        MarksEntity marks = new MarksEntity();
        marks = marksRepository.getById(marksDTO.getMarksId());
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

    @Override
    public List<ResultDTO> getResults() {
        List<ResultDTO> resultDTOArrayList = new ArrayList<>();
        List<MarksEntity> marksEntityList = marksRepository.findAll();


        marksEntityList.forEach(marks->{
            ResultDTO resultDTO = new ResultDTO();
            String s;
            int id = marks.getStudId();
            double attn = marksRepository.getAttendance(id);
            String std= marksRepository.getstuId(id);
            String sub= marksRepository.getsubjname(marks.getSubjId());

            resultDTO.setRollNo(id);
            resultDTO.setStudName(std);
            resultDTO.setSubjName(sub);
            resultDTO.setMarks(marks.getMarks());
            resultDTO.setAttendancePercentage(attn);
            if(marks.getMarks()>45 && attn>65)
                s="P";
            else
                s="F";
            resultDTO.setStatus(s);
            resultDTOArrayList.add(resultDTO);
        });
        return resultDTOArrayList;
    }
}
