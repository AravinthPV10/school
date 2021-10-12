package com.example.school.controller;

import com.example.school.dto.SubjectDTO;
import com.example.school.dto.SubjectStdDTO;
import com.example.school.service.SubjectService;
import com.example.school.service.impl.SubjectServiceImpl;
import com.example.school.service.impl.SubjectStdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    //Subjects//

    @Autowired
    SubjectServiceImpl subjectService;

    @PostMapping("/new-subject")
    public ResponseEntity<SubjectDTO> addSub(@RequestBody SubjectDTO subjectDTO){

        SubjectDTO subjectDTO1 = new SubjectDTO();
        subjectDTO1 = subjectService.addSub(subjectDTO);
        return new ResponseEntity<>(subjectDTO1, HttpStatus.OK);

    }

    @PutMapping("/update-subject")
    public ResponseEntity<SubjectDTO> updateSub(@RequestBody SubjectDTO subjectDTO){

        SubjectDTO subjectDTO1 = new SubjectDTO();
        subjectDTO1 = subjectService.updateSub(subjectDTO1);
        return new ResponseEntity<>(subjectDTO1,HttpStatus.OK);

    }

    @DeleteMapping("/subject")
    public ResponseEntity<String> deleteSub(@RequestBody SubjectDTO subjectDTO){

        String message = subjectService.deleteSub(subjectDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);

    }

    @DeleteMapping("/all-subject")
    public ResponseEntity<String> deleteAllSub(@RequestBody SubjectDTO subjectDTO){

        String message = subjectService.deleteAllSub();
        return new ResponseEntity<>(message,HttpStatus.OK);

    }

    @GetMapping("/single-subject")
    public ResponseEntity<SubjectDTO> showSub(@RequestBody SubjectDTO subjectDTO){

        SubjectDTO subjectDTO1 = new SubjectDTO();
        subjectDTO1 = subjectService.showSub(subjectDTO);
        return new ResponseEntity<>(subjectDTO1,HttpStatus.OK);

    }

    @GetMapping("/all-subject")
    public ResponseEntity<List<SubjectDTO>> showAllSub(){

        List<SubjectDTO> subjectDTOList = subjectService.showAllSub();
        return new ResponseEntity<>(subjectDTOList,HttpStatus.OK);

    }

    //Subject's Standard//

    @Autowired
    SubjectStdServiceImpl subjectStdService;

    @PostMapping("/add-standard")
    public ResponseEntity<SubjectStdDTO> addSubStd(@RequestBody SubjectStdDTO subjectStdDTO){

        SubjectStdDTO subjectStdDTO1 = new SubjectStdDTO();
        subjectStdDTO1 = subjectStdService.addSubStd(subjectStdDTO);
        return new ResponseEntity<>(subjectStdDTO1, HttpStatus.OK);

    }

    @PutMapping("/update-standard")
    public ResponseEntity<SubjectStdDTO> updateSubStd(@RequestBody SubjectStdDTO subjectStdDTO){

        SubjectStdDTO subjectStdDTO1 = new SubjectStdDTO();
        subjectStdDTO1 = subjectStdService.updateSubStd(subjectStdDTO);
        return new ResponseEntity<>(subjectStdDTO1,HttpStatus.OK);

    }

    @DeleteMapping("/standard")
    public ResponseEntity<String> deleteSubStd(@RequestBody SubjectStdDTO subjectStdDTO){

        String message = subjectStdService.deleteSubStd(subjectStdDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);

    }

    @DeleteMapping("/all-standard")
    public ResponseEntity<String> deleteAllSubStd(){

        String message = subjectStdService.deleteAllSubStd();
        return new ResponseEntity<>(message,HttpStatus.OK);

    }

    @GetMapping("/single-standard")
    public ResponseEntity<SubjectStdDTO> showSubStd(@RequestBody SubjectStdDTO subjectStdDTO){

        SubjectStdDTO subjectStdDTO1 = subjectStdService.showSubStd(subjectStdDTO);
        return new ResponseEntity<>(subjectStdDTO1,HttpStatus.OK);

    }

    @GetMapping("/all-standard")
    public ResponseEntity<List<SubjectStdDTO>> showAllSubStd(){

        List<SubjectStdDTO> subjectStdDTOList = subjectStdService.showAllSubStd();
        return new ResponseEntity<>(subjectStdDTOList,HttpStatus.OK);

    }

}
