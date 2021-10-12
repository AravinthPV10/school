package com.example.school.mapper;

import com.example.school.dto.StudentStdDTO;
import com.example.school.entity.StudentStd;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentStdMapper {

    StudentStdMapper INSTANCE = Mappers.getMapper(StudentStdMapper.class);
    StudentStd toStudStdEntity(StudentStdDTO studentStdDTO);
    StudentStdDTO toStudStdDto(StudentStd studentStd);
}
