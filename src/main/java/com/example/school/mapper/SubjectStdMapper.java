package com.example.school.mapper;

import com.example.school.dto.SubjectStdDTO;
import com.example.school.entity.StudentStd;
import com.example.school.entity.SubjectStd;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectStdMapper {
    SubjectStdMapper INSTANCE = Mappers.getMapper(SubjectStdMapper.class);
    SubjectStd toSubStdEntity(SubjectStdDTO subjectStdDTO);
    SubjectStdDTO toSubStdDto(SubjectStd subjectStd);
}
