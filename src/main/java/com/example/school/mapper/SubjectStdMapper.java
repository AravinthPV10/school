package com.example.school.mapper;

import com.example.school.dto.SubjectStandardDTO;
import com.example.school.entity.SubjectStandard;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectStdMapper {
    SubjectStdMapper INSTANCE = Mappers.getMapper(SubjectStdMapper.class);
    SubjectStandard toSubStdEntity(SubjectStandardDTO subjectStandardDTO);
    SubjectStandardDTO toSubStdDto(SubjectStandard subjectStandard);
}
