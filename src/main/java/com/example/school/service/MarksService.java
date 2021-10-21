package com.example.school.service;

import com.example.school.dto.MarksDTO;
import com.example.school.dto.ResultDTO;

import java.util.List;

public interface MarksService {

    MarksDTO addMarks(MarksDTO marksDTO);

    MarksDTO updateMarks(MarksDTO marksDTO);

    String deleteMarks(MarksDTO marksDTO);
    String deleteAllMarks();
    MarksDTO showMarks(MarksDTO marksDTO);
    List<MarksDTO> showAllMarks();
}
