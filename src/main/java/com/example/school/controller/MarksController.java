package com.example.school.controller;


import com.example.school.dto.MarksDTO;
import com.example.school.dto.ResultDTO;
import com.example.school.service.impl.MarksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarksController {

    //Student Marks//

    @Autowired
    MarksServiceImpl marksService;

    @PostMapping("/new-marks")
    public ResponseEntity<MarksDTO> addMarks(@RequestBody MarksDTO marksDTO){

        MarksDTO marksDTO1 = new MarksDTO();
        marksDTO1 = marksService.addMarks(marksDTO);
        return new ResponseEntity<>(marksDTO1, HttpStatus.OK);
    }

    @PutMapping("/update-marks")
    public ResponseEntity<MarksDTO> updateMarks(@RequestBody MarksDTO marksDTO){

        MarksDTO marksDTO1 = new MarksDTO();
        marksDTO1 = marksService.updateMarks(marksDTO);
        return new ResponseEntity<>(marksDTO1,HttpStatus.OK);
    }

    @DeleteMapping("/marks")
    public ResponseEntity<String> deleteMarks(@RequestBody MarksDTO marksDTO){

        String message = marksService.deleteMarks(marksDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/all-marks")
    public ResponseEntity<String> deleteAllMarks(){

        String message = marksService.deleteAllMarks();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/single-marks")
    public ResponseEntity<MarksDTO> showMarks(@RequestBody MarksDTO marksDTO){

        MarksDTO marksDTO1 =new MarksDTO();
        marksDTO1 = marksService.showMarks(marksDTO);
        return new ResponseEntity<>(marksDTO1,HttpStatus.OK);
    }
    @GetMapping("/all-marks")
    public ResponseEntity<List<MarksDTO>> showAllMarks(){

        List<MarksDTO> marksList = marksService.showAllMarks();
        return new ResponseEntity<>(marksList,HttpStatus.OK);
    }

    //Generate Results//

    @GetMapping("/results")
    public ResponseEntity<List<ResultDTO>> getResults(){

        List<ResultDTO> results = marksService.getResults();
        return new ResponseEntity<>(results,HttpStatus.OK);
    }
}