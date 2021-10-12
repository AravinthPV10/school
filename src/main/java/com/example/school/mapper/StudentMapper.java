package com.example.school.mapper;

import com.example.school.dto.StudentDTO;
import com.example.school.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    StudentEntity toStudentEntity(StudentDTO studentDTO);
    StudentDTO toStudentDto(StudentEntity studentEntity);
}
