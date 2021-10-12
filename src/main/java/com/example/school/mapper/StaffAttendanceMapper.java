package com.example.school.mapper;

import com.example.school.dto.StaffAttendanceDTO;
import com.example.school.entity.StaffAttendanceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface StaffAttendanceMapper {
    StaffAttendanceMapper INSTANCE = Mappers.getMapper(StaffAttendanceMapper.class);

    StaffAttendanceEntity toStaffAttnEntity(StaffAttendanceDTO staffAttendanceDTO);
    StaffAttendanceDTO toStaffAttnDto(StaffAttendanceEntity staffAttendanceEntity);
}
