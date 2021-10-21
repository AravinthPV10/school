package com.example.school.mapper;

import com.example.school.dto.SubjectDTO;
import com.example.school.entity.SubjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface SubjectMapper {
    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);
    @Mapping(source = "subjectName", target = "subject_name")
    SubjectEntity toSubEntity(SubjectDTO subjectDTO);
    @Mapping(source = "subject_name", target = "subjectName")
    SubjectDTO toSubDto(SubjectEntity subjectEntity);
}
