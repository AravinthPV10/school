package com.example.school.controller;

import com.example.school.dto.StandardDTO;
import com.example.school.service.impl.StandardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/std")
public class StandardController {

    //Standard//

    @Autowired
    StandardServiceImpl standardService;

    @PostMapping("/new-standard")
    public ResponseEntity<StandardDTO> addStd(@RequestBody StandardDTO standardDTO){

        StandardDTO standardDTO1 = new StandardDTO();
        standardDTO1 = standardService.addStd(standardDTO);
        return new ResponseEntity<>(standardDTO1, HttpStatus.OK);
    }

    @PutMapping("/update-standard")
    public ResponseEntity<StandardDTO> updateStd(@RequestBody StandardDTO standardDTO){

        StandardDTO standardDTO1 = new StandardDTO();
        standardDTO1 = standardService.updateStd(standardDTO);
        return new ResponseEntity<>(standardDTO1,HttpStatus.OK);
    }

    @DeleteMapping("/standard")
    public ResponseEntity<String> deleteStd(@RequestBody StandardDTO standardDTO){

        String message = standardService.deleteStd(standardDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/all-standard")
    public ResponseEntity<String> deleteAllStd(){

        String message = standardService.deleteAllStd();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/single-standard")
    public ResponseEntity<StandardDTO> showStd(@RequestBody StandardDTO standardDTO){

        StandardDTO standardDTO1 = new StandardDTO();
        standardDTO1 = standardService.showStd(standardDTO);
        return new ResponseEntity<>(standardDTO1,HttpStatus.OK);
    }

    @GetMapping("/all-standard")
    public ResponseEntity<List<StandardDTO>> showAllStd(){

        List<StandardDTO> list;
        list = standardService.showAllStd();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}