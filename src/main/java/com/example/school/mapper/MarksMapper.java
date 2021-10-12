package com.example.school.mapper;

import com.example.school.dto.MarksDTO;
import com.example.school.entity.MarksEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MarksMapper {
    MarksMapper INSTANCE = Mappers.getMapper(MarksMapper.class);

    MarksEntity toMarksEntity(MarksDTO marksDTO);
    MarksDTO toMarksDto(MarksEntity marksEntity);
}
