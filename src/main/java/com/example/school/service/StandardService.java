package com.example.school.service;

import com.example.school.dto.StandardDTO;

import java.util.List;

public interface StandardService {
    StandardDTO addStd(StandardDTO standardDTO);
    StandardDTO updateStd(StandardDTO standardDTO);
    String deleteStd(StandardDTO standardDTO);
    String deleteAllStd();
    StandardDTO showStd(StandardDTO standardDTO);
    List<StandardDTO> showAllStd();
}
