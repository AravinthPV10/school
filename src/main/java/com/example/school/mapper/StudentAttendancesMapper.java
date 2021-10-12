package com.example.school.mapper;

import com.example.school.dto.StudentAttendancesDTO;
import com.example.school.entity.StudentAttendancesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentAttendancesMapper {
    StudentAttendancesMapper INSTANCE = Mappers.getMapper(StudentAttendancesMapper.class);
    StudentAttendancesDTO toAttnDto(StudentAttendancesEntity studentAttendancesEntity);
    StudentAttendancesEntity toAttnEntity(StudentAttendancesDTO studentAttendancesDTO);
}
