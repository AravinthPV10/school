package com.example.school.mapper;

import com.example.school.dto.StudentStandardDTO;
import com.example.school.entity.StudentStandard;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentStdMapper {

    StudentStdMapper INSTANCE = Mappers.getMapper(StudentStdMapper.class);
    StudentStandard toStudStdEntity(StudentStandardDTO studentStandardDTO);
    StudentStandardDTO toStudStdDto(StudentStandard studentStandard);
}
