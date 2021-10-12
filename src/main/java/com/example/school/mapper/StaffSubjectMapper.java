package com.example.school.mapper;


import com.example.school.dto.StaffSubjectDTO;
import com.example.school.entity.StaffSubject;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface StaffSubjectMapper {

    StaffSubjectMapper INSTANCE = Mappers.getMapper(StaffSubjectMapper.class);
    StaffSubjectDTO toStaffSubDto(StaffSubject staffSubject);
    StaffSubject toStaffSubEntity(StaffSubjectDTO staffSubjectDTO);

}
