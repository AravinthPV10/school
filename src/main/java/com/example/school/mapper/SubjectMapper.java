package com.example.school.mapper;

import com.example.school.dto.SubjectDTO;
import com.example.school.entity.SubjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface SubjectMapper {
    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

    SubjectEntity toSubEntity(SubjectDTO subjectDTO);
    SubjectDTO toSubDto(SubjectEntity subjectEntity);
}
