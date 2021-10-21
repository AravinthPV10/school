package com.example.school.controller;

import com.example.school.dto.SubjectDTO;
import com.example.school.dto.SubjectStandardDTO;
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
    public ResponseEntity<SubjectDTO> addSubject(@RequestBody SubjectDTO subjectDTO){

        SubjectDTO subjectDTO1 = new SubjectDTO();
        subjectDTO1 = subjectService.addSub(subjectDTO);
        return new ResponseEntity<>(subjectDTO1, HttpStatus.OK);

    }

    @PutMapping("/update-subject")
    public ResponseEntity<SubjectDTO> updateSubject(@RequestBody SubjectDTO subjectDTO){

        SubjectDTO subjectDTO1 = new SubjectDTO();
        subjectDTO1 = subjectService.updateSub(subjectDTO1);
        return new ResponseEntity<>(subjectDTO1,HttpStatus.OK);

    }

    @DeleteMapping("/subject")
    public ResponseEntity<String> deleteSubject(@RequestBody SubjectDTO subjectDTO){

        String message = subjectService.deleteSub(subjectDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);

    }

    @DeleteMapping("/all-subject")
    public ResponseEntity<String> deleteAllSubject(@RequestBody SubjectDTO subjectDTO){

        String message = subjectService.deleteAllSub();
        return new ResponseEntity<>(message,HttpStatus.OK);

    }

    @GetMapping("/single-subject")
    public ResponseEntity<SubjectDTO> showSubject(@RequestBody SubjectDTO subjectDTO){

        SubjectDTO subjectDTO1 = new SubjectDTO();
        subjectDTO1 = subjectService.showSub(subjectDTO);
        return new ResponseEntity<>(subjectDTO1,HttpStatus.OK);

    }

    @GetMapping("/all-subject")
    public ResponseEntity<List<SubjectDTO>> showAllSubject(){

        List<SubjectDTO> subjectDTOList = subjectService.showAllSub();
        return new ResponseEntity<>(subjectDTOList,HttpStatus.OK);

    }

    //Subject's Standard//

    @Autowired
    SubjectStdServiceImpl subjectStdService;

    @PostMapping("/add-standard")
    public ResponseEntity<SubjectStandardDTO> addSubjectStandard(@RequestBody SubjectStandardDTO subjectStandardDTO){

        SubjectStandardDTO subjectStandardDTO1 = new SubjectStandardDTO();
        subjectStandardDTO1 = subjectStdService.addSubStd(subjectStandardDTO);
        return new ResponseEntity<>(subjectStandardDTO1, HttpStatus.OK);

    }

    @PutMapping("/update-standard")
    public ResponseEntity<SubjectStandardDTO> updateSubjectStandard(@RequestBody SubjectStandardDTO subjectStandardDTO){

        SubjectStandardDTO subjectStandardDTO1 = new SubjectStandardDTO();
        subjectStandardDTO1 = subjectStdService.updateSubStd(subjectStandardDTO);
        return new ResponseEntity<>(subjectStandardDTO1,HttpStatus.OK);

    }

    @DeleteMapping("/standard")
    public ResponseEntity<String> deleteSubjectStandard(@RequestBody SubjectStandardDTO subjectStandardDTO){

        String message = subjectStdService.deleteSubStd(subjectStandardDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);

    }

    @DeleteMapping("/all-standard")
    public ResponseEntity<String> deleteAllSubjectStandard(){

        String message = subjectStdService.deleteAllSubStd();
        return new ResponseEntity<>(message,HttpStatus.OK);

    }

    @GetMapping("/single-standard")
    public ResponseEntity<SubjectStandardDTO> showSubjectStandard(@RequestBody SubjectStandardDTO subjectStandardDTO){

        SubjectStandardDTO subjectStandardDTO1 = subjectStdService.showSubStd(subjectStandardDTO);
        return new ResponseEntity<>(subjectStandardDTO1,HttpStatus.OK);

    }

    @GetMapping("/all-standard")
    public ResponseEntity<List<SubjectStandardDTO>> showAllSubjectStandard(){

        List<SubjectStandardDTO> subjectStandardDTOList = subjectStdService.showAllSubStd();
        return new ResponseEntity<>(subjectStandardDTOList,HttpStatus.OK);

    }

}
