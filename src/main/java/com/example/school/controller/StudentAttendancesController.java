package com.example.school.controller;

import com.example.school.dto.AttnResDTO;
import com.example.school.dto.StudentAttendancesDTO;
import com.example.school.service.impl.StudentAttendancesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-attendance")
public class StudentAttendancesController {

    //Student Attendance//

    @Autowired
    StudentAttendancesServiceImpl studentAttendancesService;

    @PostMapping("/new-attendance")
    public ResponseEntity<StudentAttendancesDTO> addAttn(@RequestBody StudentAttendancesDTO studentAttendancesDTO){

        StudentAttendancesDTO studentAttendancesDTO1 = new StudentAttendancesDTO();
        studentAttendancesDTO1 = studentAttendancesService.addAttn(studentAttendancesDTO);
        return new ResponseEntity<>(studentAttendancesDTO1, HttpStatus.OK);
    }

    @PutMapping("/update-attendance")
    public ResponseEntity<StudentAttendancesDTO> updateAttn(@RequestBody StudentAttendancesDTO studentAttendancesDTO){

        StudentAttendancesDTO studentAttendancesDTO1 = new StudentAttendancesDTO();
        studentAttendancesDTO1 = studentAttendancesService.updateAttn(studentAttendancesDTO);
        return new ResponseEntity<>(studentAttendancesDTO1,HttpStatus.OK);
    }

    @DeleteMapping("/attendance")
    public ResponseEntity<String> deleteAttn(@RequestBody StudentAttendancesDTO studentAttendancesDTO){

        String message = studentAttendancesService.deleteAttn(studentAttendancesDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/all-attendance")
    public ResponseEntity<String> deleteAllAttn(){

        String message = studentAttendancesService.deleteAllAttn();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/single-attendance")
    public ResponseEntity<StudentAttendancesDTO> showAttn(@RequestBody StudentAttendancesDTO studentAttendancesDTO){

        StudentAttendancesDTO studentAttendancesDTO1 = new StudentAttendancesDTO();
        studentAttendancesDTO1 = studentAttendancesService.showAttn(studentAttendancesDTO);
        return new ResponseEntity<>(studentAttendancesDTO1,HttpStatus.OK);
    }

    @GetMapping("/all-attendance")
    public ResponseEntity<List<StudentAttendancesDTO>> showAllAttn(){

        List<StudentAttendancesDTO> AttendanceList ;
        AttendanceList = studentAttendancesService.showAllAttn();
        return new ResponseEntity<>(AttendanceList,HttpStatus.OK);
    }

    //Attendance Percent//

    @GetMapping("/attendance-percent/{id}")
    public ResponseEntity<AttnResDTO> attnPercent(@PathVariable("id")int id){

        AttnResDTO attendance = studentAttendancesService.getStuAttendance(id);
        return new ResponseEntity<>(attendance,HttpStatus.OK);
    }
}
