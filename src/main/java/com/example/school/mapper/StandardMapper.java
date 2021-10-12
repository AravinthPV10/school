package com.example.school.mapper;

import com.example.school.dto.StandardDTO;
import com.example.school.entity.StandardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface StandardMapper {
    StandardMapper INSTANCE = Mappers.getMapper(StandardMapper.class);

    StandardEntity toStdEntity(StandardDTO standardDTO);
    StandardDTO toStdDto(StandardEntity standardEntity);
}
