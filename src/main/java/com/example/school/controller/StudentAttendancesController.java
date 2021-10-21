package com.example.school.controller;

import com.example.school.dto.AttendancePercentageDTO;
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

    @PostMapping("/add-attendance")
    public ResponseEntity<StudentAttendancesDTO> addAttendance(@RequestBody StudentAttendancesDTO studentAttendancesDTO){

        StudentAttendancesDTO studentAttendancesDTO1 = new StudentAttendancesDTO();
        studentAttendancesDTO1 = studentAttendancesService.addAttendance(studentAttendancesDTO);
        return new ResponseEntity<>(studentAttendancesDTO1, HttpStatus.OK);
    }

    @PutMapping("/update-attendance")
    public ResponseEntity<StudentAttendancesDTO> updateAttendance(@RequestBody StudentAttendancesDTO studentAttendancesDTO){

        StudentAttendancesDTO studentAttendancesDTO1 = new StudentAttendancesDTO();
        studentAttendancesDTO1 = studentAttendancesService.updateAttendance(studentAttendancesDTO);
        return new ResponseEntity<>(studentAttendancesDTO1,HttpStatus.OK);
    }

    @DeleteMapping("/attendance")
    public ResponseEntity<String> deleteAttendance(@RequestBody StudentAttendancesDTO studentAttendancesDTO){

        String message = studentAttendancesService.deleteAttendance(studentAttendancesDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/all-attendance")
    public ResponseEntity<String> deleteAllAttendance(){

        String message = studentAttendancesService.deleteAllAttendance();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/single-attendance")
    public ResponseEntity<StudentAttendancesDTO> showAttendance(@RequestBody StudentAttendancesDTO studentAttendancesDTO){

        StudentAttendancesDTO studentAttendancesDTO1 = new StudentAttendancesDTO();
        studentAttendancesDTO1 = studentAttendancesService.showAttendance(studentAttendancesDTO);
        return new ResponseEntity<>(studentAttendancesDTO1,HttpStatus.OK);
    }

    @GetMapping("/all-attendance")
    public ResponseEntity<List<StudentAttendancesDTO>> showAllAttendance(){

        List<StudentAttendancesDTO> AttendanceList ;
        AttendanceList = studentAttendancesService.showAllAttendance();
        return new ResponseEntity<>(AttendanceList,HttpStatus.OK);
    }

    //Attendance Percent//

    @GetMapping("/attendance-percent/{id}")
    public ResponseEntity<AttendancePercentageDTO> attendancePercent(@PathVariable("id")int id){

        AttendancePercentageDTO attendance = studentAttendancesService.getStudentAttendancePercent(id);
        return new ResponseEntity<>(attendance,HttpStatus.OK);
    }
}
