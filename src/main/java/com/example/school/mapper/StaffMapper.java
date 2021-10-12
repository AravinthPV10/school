package com.example.school.mapper;

import com.example.school.dto.StaffDTO;
import com.example.school.entity.StaffEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface StaffMapper {
    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);
    StaffEntity toStaffEntity(StaffDTO staffDTO);
    StaffDTO toStaffDto(StaffEntity staffEntity);
}
