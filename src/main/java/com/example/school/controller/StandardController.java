package com.example.school.controller;

import com.example.school.dto.StandardDTO;
import com.example.school.service.impl.StandardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/standard")
public class StandardController {

    //Standard//

    @Autowired
    StandardServiceImpl standardService;

    @PostMapping("/add-standard")
    public ResponseEntity<StandardDTO> addStandard(@RequestBody StandardDTO standardDTO){

        StandardDTO standardDTO1 = new StandardDTO();
        standardDTO1 = standardService.addStandard(standardDTO);
        return new ResponseEntity<>(standardDTO1, HttpStatus.OK);
    }

    @PutMapping("/update-standard")
    public ResponseEntity<StandardDTO> updateStandard(@RequestBody StandardDTO standardDTO){

        StandardDTO standardDTO1 = new StandardDTO();
        standardDTO1 = standardService.updateStandard(standardDTO);
        return new ResponseEntity<>(standardDTO1,HttpStatus.OK);
    }

    @DeleteMapping("/standard")
    public ResponseEntity<String> deleteStandard(@RequestBody StandardDTO standardDTO){

        String message = standardService.deleteStandard(standardDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/all-standard")
    public ResponseEntity<String> deleteAllStandard(){

        String message = standardService.deleteAllStandard();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/single-standard")
    public ResponseEntity<StandardDTO> showStandard(@RequestBody StandardDTO standardDTO){

        StandardDTO standardDTO1 = new StandardDTO();
        standardDTO1 = standardService.showStandard(standardDTO);
        return new ResponseEntity<>(standardDTO1,HttpStatus.OK);
    }

    @GetMapping("/all-standard")
    public ResponseEntity<List<StandardDTO>> showAllStandard(){

        List<StandardDTO> list;
        list = standardService.showAllStandard();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}