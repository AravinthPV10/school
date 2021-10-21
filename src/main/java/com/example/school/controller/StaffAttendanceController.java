package com.example.school.controller;

import com.example.school.dto.AttendancePercentageDTO;
import com.example.school.dto.StaffAttendanceDTO;
import com.example.school.service.impl.StaffAttendanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff-attendance")
public class StaffAttendanceController {

    //Staff Attendance//

    @Autowired
    StaffAttendanceServiceImpl staffAttendanceService;

    @PostMapping("/add-attendance")
    public ResponseEntity<StaffAttendanceDTO> addStaffAttendance(@RequestBody StaffAttendanceDTO staffAttendanceDTO){

        StaffAttendanceDTO staffAttendanceDTO1 = new StaffAttendanceDTO();
        staffAttendanceDTO1 = staffAttendanceService.addStaffAttendance(staffAttendanceDTO);
        return new ResponseEntity<>(staffAttendanceDTO1, HttpStatus.OK);
    }

    @PutMapping("/update-attendance")
    public ResponseEntity<StaffAttendanceDTO> updateStaffAttendance(@RequestBody StaffAttendanceDTO staffAttendanceDTO){

        StaffAttendanceDTO staffAttendanceDTO1 = new StaffAttendanceDTO();
        staffAttendanceDTO1 = staffAttendanceService.updateStaffAttendance(staffAttendanceDTO);
        return new ResponseEntity<>(staffAttendanceDTO1,HttpStatus.OK);
    }

    @DeleteMapping("/attendance")
    public ResponseEntity<String> deleteStaffAttendance(@RequestBody StaffAttendanceDTO staffAttendanceDTO){

        String message = staffAttendanceService.deleteStaffAttendance(staffAttendanceDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/all-attendance")
    public ResponseEntity<String> deleteAllStaffAttendance(){

        String message = staffAttendanceService.deleteAllStaffAttendance();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/single-attendance")
    public ResponseEntity<StaffAttendanceDTO> showStaffAttendance(@RequestBody StaffAttendanceDTO staffAttendanceDTO){

        StaffAttendanceDTO staffAttendanceDTO1 = staffAttendanceService.showStaffAttendance(staffAttendanceDTO);
        return new ResponseEntity<>(staffAttendanceDTO1,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StaffAttendanceDTO>> showAllStaffAttendance(){

        List<StaffAttendanceDTO> attendanceList = staffAttendanceService.showAllStaffAttendance();
        return new ResponseEntity<>(attendanceList,HttpStatus.OK);
    }

    //Staff Attendance Average//

    @GetMapping("/attendance-percentage/{id}")
    public ResponseEntity<AttendancePercentageDTO> attendancePercentage(@PathVariable("id") int id){

        AttendancePercentageDTO attendancePercentage = new AttendancePercentageDTO();
        attendancePercentage= staffAttendanceService.getStaffAttendancePercentage(id);
        return new ResponseEntity<>(attendancePercentage,HttpStatus.OK);
    }
}