package com.example.school.service;

import com.example.school.dto.StandardDTO;

import java.util.List;

public interface StandardService {
    StandardDTO addStandard(StandardDTO standardDTO);
    StandardDTO updateStandard(StandardDTO standardDTO);
    String deleteStandard(StandardDTO standardDTO);
    String deleteAllStandard();
    StandardDTO showStandard(StandardDTO standardDTO);
    List<StandardDTO> showAllStandard();
}
